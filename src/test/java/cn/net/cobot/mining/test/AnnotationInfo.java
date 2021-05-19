package cn.net.cobot.mining.test;

import java.util.ArrayList;

import cn.net.cobot.parsers.javaparser.core.dom.Annotation;

public class AnnotationInfo extends Info{

	private static final long serialVersionUID = 1L;
	//type + "." + name
	Annotation annotation;
	
	public AnnotationInfo(String infoName, ArrayList<String> parameterList){
		this.infoName=infoName;
		this.parameterList=parameterList;
	}
	

	public void setAnnotation(Annotation annotation) {
		this.annotation = annotation;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((infoName == null) ? 0 : infoName.hashCode());
		return result;
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
		return true;
	}

	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return 	"Annotation::"+annotation+"\n"+
				"AnnotationName::"+infoName+"\n"+
				"Parameter::"+parameterList+"\n";
	}
}