package cn.net.cobot.mining.util;

import java.util.ArrayList;
import java.util.List;

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
	
}