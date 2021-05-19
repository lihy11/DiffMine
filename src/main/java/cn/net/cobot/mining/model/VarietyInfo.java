package cn.net.cobot.mining.model;

import java.util.HashMap;
import java.util.HashSet;

import cn.net.cobot.mining.action.DiffMsgInfCollect;

public class VarietyInfo {
	/*
	 * changeinfo_id	project_id	project_name	
	 * project_commit_id	file_path	add_possion	add_width	
	 * del_possion	del_width	add_method	del_method
	 * */
	
	private String varietyinfo_id = "";
	private String project_id = "";
	private String project_name = "";
	private String project_commit_id = "";
	private String file_path = "";
	private String add_possions = "";
	private String add_widths = "";
	private String del_possions = "";
	private String del_widths = "";	
	private String add_methods = "";	
	private String del_methods = "";
	public static String SPLIT = ";";
	public VarietyInfo(FileVector fileVector) {
		this.file_path = fileVector.path;
		this.project_commit_id = fileVector.commitID;
		for(int i = 0; i < fileVector.changeSet.size(); i ++) {
			HashSet<String> methodVector = fileVector.methodVectorSets.get(i);
			String mAdd = "";
			String mDel = "";
			for(String m : methodVector) {
				if(m.startsWith("-"))
					mDel += m + ",";
				else 
					mAdd += m + ",";
			}
			this.add_methods += mAdd + SPLIT;
			this.del_methods += mDel + SPLIT;
			HashMap<String, Integer> changeMap = fileVector.changeSet.get(i);
			this.add_widths += String.valueOf(changeMap.get(DiffMsgInfCollect.ADD_WIDTH)) + SPLIT;
			this.add_possions += String.valueOf(changeMap.get(DiffMsgInfCollect.ADD_POSSION)) + SPLIT;
			this.del_widths += String.valueOf(changeMap.get(DiffMsgInfCollect.DEL_WIDTH)) + SPLIT;
			this.del_possions += String.valueOf(changeMap.get(DiffMsgInfCollect.DEL_POSSION)) + SPLIT;
		}
	}
	public VarietyInfo() {
		
	}
	public FileVector toFileVector() {
		FileVector fileVector = new FileVector();
		fileVector.projectName = this.project_name;
		fileVector.projectID = this.project_id;
		fileVector.commitID = this.project_commit_id;
		fileVector.path = this.file_path;
		String[] add_p = this.add_possions.split(SPLIT);
		String[] add_w = this.add_widths.split(SPLIT);
		String[] del_p = this.del_possions.split(SPLIT);
		String[] del_w = this.del_widths.split(SPLIT);
		String[] add_m = this.add_methods.split(SPLIT);
		String[] del_m = this.del_methods.split(SPLIT);
		for(int i = 0; i < add_p.length; i ++) {
			HashMap<String, Integer> change = new HashMap<String, Integer>();
			change.put(DiffMsgInfCollect.ADD_POSSION, Integer.valueOf(add_p[i]));
			change.put(DiffMsgInfCollect.ADD_WIDTH, Integer.valueOf(add_w[i]));
			change.put(DiffMsgInfCollect.DEL_POSSION, Integer.valueOf(del_p[i]));
			change.put(DiffMsgInfCollect.DEL_WIDTH, Integer.valueOf(del_w[i]));
			fileVector.changeSet.add(change);
			
			HashSet<String> methodSet = new HashSet<String>();
			
			if(add_m.length > i) {
				String[] methodsAdd = add_m[i].trim().split(",");
				for(String s : methodsAdd) {
					if(s.length() != 0)
						methodSet.add(s);
				}
			}
			if(del_m.length > i) {
				String[] methodDel = del_m[i].trim().split(",");
				for(String s : methodDel) {
					if(s.length() != 0)
						methodSet.add(s);
				}
			}
			fileVector.methodVectorSets.add(methodSet);
		}
		return fileVector;
	}
	public String getVarietyinfo_id() {
		return varietyinfo_id;
	}

	public void setVarietyinfo_id(String varietyinfo_id) {
		this.varietyinfo_id = varietyinfo_id;
	}
	public String getProject_id() {
		return project_id;
	}
	public void setProject_id(String project_id) {
		this.project_id = project_id;
	}
	public String getProject_name() {
		return project_name;
	}
	public void setProject_name(String project_name) {
		this.project_name = project_name;
	}
	public String getProject_commit_id() {
		return project_commit_id;
	}
	public void setProject_commit_id(String project_commit_id) {
		this.project_commit_id = project_commit_id;
	}
	public String getFile_path() {
		return file_path;
	}
	public void setFile_path(String file_path) {
		this.file_path = file_path;
	}
	public String getAdd_possions() {
		return add_possions;
	}
	public void setAdd_possions(String add_possions) {
		this.add_possions = add_possions;
	}
	public String getAdd_widths() {
		return add_widths;
	}
	public void setAdd_widths(String add_widths) {
		this.add_widths = add_widths;
	}
	public String getDel_possions() {
		return del_possions;
	}
	public void setDel_possions(String del_possions) {
		this.del_possions = del_possions;
	}
	public String getDel_widths() {
		return del_widths;
	}
	public void setDel_widths(String del_widths) {
		this.del_widths = del_widths;
	}
	public String getAdd_methods() {
		return add_methods;
	}
	public void setAdd_methods(String add_methods) {
		this.add_methods = add_methods;
	}
	public String getDel_methods() {
		return del_methods;
	}
	public void setDel_methods(String del_methods) {
		this.del_methods = del_methods;
	}

}
