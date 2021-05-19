package cn.net.cobot.mining.test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class CommitVector {
	HashMap<String, FileVector> fileVectors;
	String commitID = "";
	public CommitVector() {
		fileVectors = new HashMap<String, FileVector>();
	}
}
class FileVector{
	String path = "";
	ArrayList<HashSet<String>> secVectors;
	ArrayList<HashMap<String, Integer>> changeSet ;
	public FileVector() {
		secVectors = new ArrayList<HashSet<String>>();
		changeSet = new ArrayList<HashMap<String,Integer>>();
	}
	public boolean isEmpty() {
		for(HashSet<String> vec : secVectors) {
			if(vec.size() != 0)
				return false;
		}
		return true;
	}
}
class FrequentSetSupportInfo{
	ArrayList<String> projName;
	ArrayList<String> commitID;
	ArrayList<String> filePath;
	ArrayList<HashMap<String, Integer>> changeMap;
	HashSet<String> frequentSet;
	public FrequentSetSupportInfo(HashSet<String> frequentSet) {
		this.projName = new ArrayList<String>();
		this.commitID = new ArrayList<String>();
		this.filePath = new ArrayList<String>();
		this.changeMap = new ArrayList<HashMap<String,Integer>>();
		this.frequentSet = frequentSet;
	}
}