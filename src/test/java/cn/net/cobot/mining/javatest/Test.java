package cn.net.cobot.mining.javatest;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Test {
	public static void main(String[] args) {
		int size = 0;
		try {
			List<String> files = new ArrayList<>();
			BufferedReader reader = new BufferedReader(new FileReader("D:\\miner\\java.csv"));
			String line = "";
			
			while((line = reader.readLine()) != null) {
				String tmps = line.split(",")[1];
				int num = Integer.parseInt(tmps.split("-")[0]);
				if(num > size && num < 1000) {
					files.add(tmps);
				}
			}
			reader.close();
			
			String op = "xcopy %src%\\file\\* %dst%\\file\\ /S /E\n";
			BufferedWriter writer = new BufferedWriter(new FileWriter("D:\\miner\\cp.txt"));
			writer.write("set src=\n");
			writer.write("set dst=\n");
			for(String file : files) {
				writer.write(op.replace("file", file));
			}
			writer.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
