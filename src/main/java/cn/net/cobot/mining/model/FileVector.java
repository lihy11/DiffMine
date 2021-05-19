package cn.net.cobot.mining.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class FileVector {
	public String projectName = "";
	public String projectID = "";
	public String path = "";
	public String commitID = "";
	public ArrayList<HashSet<String>> methodVectorSets;
	public ArrayList<HashMap<String, Integer>> changeSet ;
	
	public FileVector() {
		methodVectorSets = new ArrayList<HashSet<String>>();
		changeSet = new ArrayList<HashMap<String,Integer>>();
	}
	
	public boolean isEmpty() {
		for(HashSet<String> vec : methodVectorSets) {
			if(vec.size() != 0)
				return false;
		}
		return true;
	}
}
