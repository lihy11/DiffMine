package cn.net.cobot.mining.util;

import java.util.ArrayList;

import cn.net.cobot.parsers.javaparser.core.dom.MethodInvocation;

public class MethodInfo extends Info {

	private static final long serialVersionUID = 1L;
	//type + "." + name
	private String packageName;
	private MethodInvocation methodInvoke;
	
	public MethodInfo(String methodName,String packageName,ArrayList<String> parameterList){
		this.infoName=methodName;
		this.packageName=packageName;
		this.parameterList=parameterList;
	}
	
	public void setMethodInvoke(MethodInvocation methodInvoke) {
		this.methodInvoke = methodInvoke;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((infoName == null) ? 0 : infoName.hashCode());
		result = prime * result
				+ ((packageName == null) ? 0 : packageName.hashCode());
		result = prime * result
				+ ((parameterList == null) ? 0 : parameterList.hashCode());
		return result;
	}

	
	public String getPackageName() {
		return packageName;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		MethodInfo other = (MethodInfo) obj;
		if (infoName == null) {
			if (other.infoName != null)
				return false;
		} else if (!infoName.equals(other.infoName))
			return false;
		if (packageName == null) {
			if (other.packageName != null)
				return false;
		} else if (!packageName.equals(other.packageName))
			return false;
		if (parameterList == null) {
			if (other.parameterList != null)
				return false;
		} else if (!parameterList.equals(other.parameterList))
			return false;
		return true;
	}

	@Override
	public String toString() {
		String s = this.packageName + "." +  this.infoName + "(";
		for(String param : this.parameterList) {
			String[] tmp = param.split(".");
			if(tmp.length == 0)
				continue;
			s += tmp[tmp.length -1] + ",";
		}
		s += ")";
		return s;
	}
}