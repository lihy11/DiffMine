package cn.net.cobot.mining.util;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

import org.eclipse.jgit.api.CheckoutCommand;
import org.eclipse.jgit.api.Git;
import org.eclipse.jgit.api.ResetCommand.ResetType;
import org.eclipse.jgit.api.errors.CheckoutConflictException;
import org.eclipse.jgit.api.errors.GitAPIException;
import org.eclipse.jgit.api.errors.InvalidRefNameException;
import org.eclipse.jgit.api.errors.RefAlreadyExistsException;
import org.eclipse.jgit.api.errors.RefNotFoundException;
import org.eclipse.jgit.diff.DiffFormatter;
import org.eclipse.jgit.errors.AmbiguousObjectException;
import org.eclipse.jgit.errors.IncorrectObjectTypeException;
import org.eclipse.jgit.errors.MissingObjectException;
import org.eclipse.jgit.errors.RevisionSyntaxException;
import org.eclipse.jgit.lib.ObjectId;
import org.eclipse.jgit.lib.ObjectReader;
import org.eclipse.jgit.lib.Repository;
import org.eclipse.jgit.revwalk.RevCommit;
import org.eclipse.jgit.revwalk.RevWalk;
import org.eclipse.jgit.treewalk.AbstractTreeIterator;
import org.eclipse.jgit.treewalk.CanonicalTreeParser;

import com.google.common.collect.Lists;

public class GitCommand {

	public String prjPath;
	public Git git;
	Repository repository;
	List<RevCommit> commitList;

	public GitCommand(String prjPath) {
		this.prjPath=prjPath;
		try {
			File dir = new File(prjPath +File.separator + ".git");
			this.git = Git.init().setGitDir(dir).setDirectory(dir.getParentFile()).call();
			this.repository = git.getRepository();
			Iterable<RevCommit> commits = git.log().call();
			this.commitList = Lists.newArrayList(commits);
		} catch (GitAPIException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} 
	}
	
	public List<String> getCommitIdList() {
		List<String> commitIds = new ArrayList<String>();
		for (RevCommit commit:commitList) {
		 	String commitId = commit.getId().getName();
			commitIds.add(commitId);	
		}
		return commitIds;
	}
	public String getCommitMsg(String commitID) {
		try {
			for(RevCommit commit : commitList) {
				if(commitID.equals(commit.getId().getName()))
					return commit.getFullMessage();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "";
	}
	
	public void resetHardGit() {
		try {
			git.reset().setMode(ResetType.HARD).call();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public void resetCommitHard(String commitID) {
		try {
			git.reset().setMode(ResetType.HARD).setRef(commitID).call();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	/**
	 * checkout commit by commitID
	 * @param commitId
	 */
	public void checkOutCommit(String commitId){
		try {
			CheckoutCommand checkoutCmd = this.git.checkout().setName(commitId);
			checkoutCmd.call();
		} catch (RefAlreadyExistsException e) {
			e.printStackTrace();
		} catch (RefNotFoundException e) {
			e.printStackTrace();
		} catch (InvalidRefNameException e) {
			e.printStackTrace();
		} catch (CheckoutConflictException e) {
			e.printStackTrace();
		} catch (GitAPIException e) {
			e.printStackTrace();
		}catch (Exception e) {
			e.printStackTrace();
		}finally{
		}				
	}
	
	/**
	 * get diff string from commit ID
	 * @param commitId
	 * @return
	 */
	public String getDiff(String commitId){
	    //Get the commit you are looking for.
	    RevCommit newCommit = null;
	    String diff = null;
	    RevWalk walk =null;
	    try  {
	    	walk = new RevWalk(repository);
	        newCommit = walk.parseCommit(repository.resolve(commitId));
		    diff=getDiffOfCommit(newCommit);
	    } catch (RevisionSyntaxException e) {
			e.printStackTrace();
		} catch (MissingObjectException e) {
			e.printStackTrace();
		} catch (IncorrectObjectTypeException e) {
			e.printStackTrace();
		} catch (AmbiguousObjectException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}finally{
			if(walk!=null){
		        walk.dispose();
				walk.close();
			}
			if(newCommit!=null)
				newCommit.disposeBody();
		}
		return diff;

	}
	/**
	 * gets the diff as a string
	 * @param newCommit
	 * @return
	 * @throws IOException
	 */
	private String getDiffOfCommit(RevCommit newCommit) throws IOException {

	    //Get commit that is previous to the current one.
	    RevCommit oldCommit = getPrevCommit(newCommit);
	    if(oldCommit == null){
	        return "Start of repo";
	    }
	    //Use treeIterator to diff.
	    AbstractTreeIterator oldTreeIterator = getCanonicalTreeParser(oldCommit);
	    AbstractTreeIterator newTreeIterator = getCanonicalTreeParser(newCommit);
	    OutputStream outputStream = new ByteArrayOutputStream();
	    try (DiffFormatter formatter = new DiffFormatter(outputStream)) {
	        formatter.setRepository(repository);
	        formatter.format(oldTreeIterator, newTreeIterator);
	    }
	    String diff = outputStream.toString();
	    outputStream.close();
	    return diff;
	}	

	/**
	 * get the previous commit.
	 * @param commit
	 * @return
	 * @throws IOException
	 */
	public RevCommit getPrevCommit(RevCommit commit)  throws  IOException {
		RevWalk walk=null;
	    try {
	        // Starting point
	    	walk = new RevWalk(repository);
	        walk.markStart(commit);
	        int count = 0;
	        for (RevCommit rev : walk) {
	            // got the previous commit.
	            if (count == 1) {
	                return rev;
	            }
	            count++;
	        }
	        walk.dispose();
	    }finally{
	    	if(walk!=null){
		        walk.dispose();
	    		walk.close();
	    	}
	    }
	    //Reached end and no previous commits.
	    return null;
	}

	/**
	 * get the tree of the changes in a commit.
	 * @param commitId
	 * @return
	 * @throws IOException
	 */
	private AbstractTreeIterator getCanonicalTreeParser(ObjectId commitId) throws IOException {
	    try (RevWalk walk = new RevWalk(git.getRepository())) {
	        RevCommit commit = walk.parseCommit(commitId);
	        ObjectId treeId = commit.getTree().getId();
	        ObjectReader reader=null;
	        try {
	        	reader= repository.newObjectReader();
	            return new CanonicalTreeParser(null, reader, treeId);
	        }finally{
	 
	        }
	    }
	}
	
	public void realseGit(){
		this.git.close();
		this.commitList.clear();
		this.repository.close();
	}
}