package cn.net.cobot.mining.test;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;

import org.eclipse.jgit.api.ResetCommand;
import org.eclipse.jgit.api.ResetCommand.ResetType;
import org.eclipse.jgit.api.errors.GitAPIException;
import org.stringtemplate.v4.compiler.STParser.template_return;

public class Test {

	public static void main(String[] args) {
		ArrayList<Integer> list1 = new ArrayList<Integer>();
		list1.add(1);
		long start_nanotime = System.nanoTime();
		for (int i = 0; i < 100000; i ++) {
			if(!(list1.size() == 0))
				list1.add(i);
		}
		long end_time = System.nanoTime() - start_nanotime;
		System.out.println(end_time);
		
		ArrayList<Integer> list2 = new ArrayList<Integer>();
		list2.add(1);
		long start = System.nanoTime();
		for (int i = 0; i < 100000; i ++) {
			if(!list2.isEmpty())
				list2.add(i);
		}
		long nano = System.nanoTime() - start;
		System.out.println(nano);
	}
	
	void filterMethod(String vecPath,String fimPath) throws Exception {
		String newVecPath = vecPath + "_filtered";
		Runtime.getRuntime().exec(fimPath + " " + vecPath + " " + "500" + " " + newVecPath).waitFor();
		BufferedReader reader = new BufferedReader(new FileReader(newVecPath));
		String line = "";
		ArrayList<ArrayList<String>> setFiltered = new ArrayList<ArrayList<String>>();
		
		while((line = reader.readLine()) != null) {
			ArrayList<String> subset = new ArrayList<String>();
			String[] tmp = line.split(" ");
			for(String t : tmp) {
				if(t.startsWith("(") )
					continue;
				else {
					subset.add(t);
				}
			}
			if(!subset.isEmpty())
				setFiltered.add(subset);
		}
		reader.close();
		ArrayList<ArrayList<String>> set = new ArrayList<ArrayList<String>>();
		reader = new BufferedReader(new FileReader(vecPath));
		while((line = reader.readLine()) != null) {
			ArrayList<String> subset = new ArrayList<String>();
			String[] tmp = line.split(" ");
			for(String t : tmp) {
				if(t.startsWith("(") )
					continue;
				else {
					subset.add(t);
				}
			}
			if(!subset.isEmpty())
				set.add(subset);
		}
		reader.close();
		for(ArrayList<String> subset : setFiltered) {
			for(ArrayList<String> s : set) {
				s.removeAll(subset);
			}
		}
		BufferedWriter writer = new BufferedWriter(new java.io.FileWriter(newVecPath));
		for(ArrayList<String> subset : set) {
			if(subset.size() == 0)
				continue;
			else {
				for(String string : subset)
					writer.write(string + " ");
				writer.write("\n");
			}
		}
		writer.close();
	}

}