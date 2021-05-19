package cn.net.cobot.mining.test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import cn.net.cobot.parsers.javaparser.core.dom.IBinding;
import cn.net.cobot.parsers.javaparser.core.dom.ITypeBinding;
import cn.net.cobot.parsers.javaparser.core.dom.MethodDeclaration;
import cn.net.cobot.parsers.javaparser.core.dom.SimpleName;
import cn.net.cobot.parsers.javaparser.core.dom.SingleVariableDeclaration;
import cn.net.cobot.parsers.javaparser.core.dom.Type;
import cn.net.cobot.parsers.javaparser.core.dom.TypeDeclaration;

public class JavaMinerUtility {
	/**
	 * 获取完整包名
	 * @param typeDeclaration
	 * @return
	 */
	
	private static String OS=null;
	
	public static String getPackageName(TypeDeclaration typeDeclaration){
		SimpleName className = typeDeclaration.getName();
		IBinding binding = className.resolveBinding();
		if(binding == null)
			return null;
		String packageName = binding.getKey();
		packageName = packageName.replaceAll("/", ".").replaceAll(";", "").substring(1);
		return packageName;
	}
	/**
	 * 获取MethodDeclaration 参数类型名
	 * @param methodDeclaration
	 * @return
	 */
	@SuppressWarnings("rawtypes")
	public static List<String> getParameterTypeList(MethodDeclaration methodDeclaration) {
		ArrayList<String> list = new ArrayList<String>();
		List parameters = methodDeclaration.parameters();
		for(Object para: parameters){
			if(para instanceof SingleVariableDeclaration){
				Type type = ((SingleVariableDeclaration) para).getType();
				ITypeBinding typeBinding = type.resolveBinding();
				if(typeBinding == null)
					return null;
				String paraKey = typeBinding.getKey();
				paraKey = paraKey.replaceAll("/", ".").replaceAll(";", "").substring(1);
				list.add(paraKey);
			}
		}
		return list;
	} 
	
	 @SuppressWarnings("unchecked")
	public static Map<Info, Integer> readObjectMap(String path) {
		 	Map<Info, Integer> readMap = null;
		 	FileInputStream is = null;
		 	ObjectInputStream os = null;
	    	try {
				is = new FileInputStream(new File(path));
				os = new ObjectInputStream(is);
				readMap = (Map<Info, Integer>) os.readObject();
			} catch (Exception e) {
				e.printStackTrace();
			}finally{
				if(is!=null)
					try {
						is.close();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				if(os!=null)
					try {
						os.close();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
			}

	    	return readMap;
	    }
	 
	 
	 public static List<String> executeCmd(String cmd) {
	        Runtime run = Runtime.getRuntime();
	        try {
	            Process process = null;
	            if(OS==null)
	            	OS = getOSName();
	    		switch (OS) {
	    			case "linux":
	    				process = run.exec(new String[] {"/bin/sh", "-c", cmd});
	    				break;
	    			case "windows":
	    				process = run.exec(new String[] { "cmd", "/c", cmd });
	    				break;
	    			default:
	    				System.err.println("unsupport system");
	    		}
	            InputStream in = process.getInputStream();
	            BufferedReader bs = new BufferedReader(new InputStreamReader(in));
	            List<String> list = new ArrayList<String>();
	            String result = null;
	            while ((result = bs.readLine()) != null)
	                list.add(result);
	            in.close();
	            process.destroy();
	            return list;
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	        return null;
	    }
	 
	 public static String getOSName() {
		 String os = System.getProperty("os.name").toLowerCase();
		 if (os.contains("windows"))
		 	return "windows";
		 else if (os.contains("linux"))
		 	return "linux";
		 return "unsupport system";
	}
}