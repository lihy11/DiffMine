package cn.net.cobot.mining.test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import cn.net.cobot.cobot_checker_common.general.JavaCobotVisitor;
import cn.net.cobot.parsers.javaparser.core.dom.ASTNode;
import cn.net.cobot.parsers.javaparser.core.dom.Expression;
import cn.net.cobot.parsers.javaparser.core.dom.IBinding;
import cn.net.cobot.parsers.javaparser.core.dom.ITypeBinding;
import cn.net.cobot.parsers.javaparser.core.dom.MarkerAnnotation;
import cn.net.cobot.parsers.javaparser.core.dom.MethodBinding;
import cn.net.cobot.parsers.javaparser.core.dom.MethodInvocation;
import cn.net.cobot.parsers.javaparser.core.dom.Name;
import cn.net.cobot.parsers.javaparser.core.dom.NormalAnnotation;
import cn.net.cobot.parsers.javaparser.core.dom.SimpleName;
import cn.net.cobot.parsers.javaparser.core.dom.SingleMemberAnnotation;
import cn.net.cobot.parsers.javaparser.core.dom.TypeBinding;
import cn.net.cobot.parsers.javaparser.internal.compiler.lookup.BaseTypeBinding;
import cn.net.cobot.parsers.javaparser.internal.compiler.lookup.MissingTypeBinding;

public class DiffVisitor extends JavaCobotVisitor{
	private FileVector fileVector;
	private boolean isRemove;//true
	private Map<Info,Integer> infoNumMap= new HashMap<Info,Integer>();

	private static final boolean DEBUG=false;	 
	private static Logger logger = Logger.getLogger(DiffVisitor.class);

	public DiffVisitor() {
		super();
	}
	
	@Override
	public boolean visit(MarkerAnnotation node) {
		int pos = -1;
		if((pos = checkLineNum(node)) == -1)
			return true;
		Name typeName = node.getTypeName();
		AnnotationInfo annotationInfo = new AnnotationInfo(typeName.toString(),null);
		annotationInfo.setAnnotation(node);
		if(DEBUG)
			System.out.println("Annotation::"+annotationInfo);
		addVector(annotationInfo,pos);
		return true;
	}
	public FileVector getFileVector() {
		return this.fileVector;
	}
	
	@Override
	public boolean visit(SingleMemberAnnotation node) {
		int pos = -1;
		if((pos = checkLineNum(node)) == -1)
			return true;
		Name typeName = node.getTypeName();
		Expression value = node.getValue();
		ArrayList<String> argsList= new ArrayList<String>();
		argsList.add(value.toString());
		AnnotationInfo annotationInfo = new AnnotationInfo(typeName.toString(),argsList);
		annotationInfo.setAnnotation(node);
		if(DEBUG)
			System.out.println("Annotation::"+annotationInfo);
		addVector(annotationInfo,pos);
		return true;
	}
	
	@Override
	public boolean visit(NormalAnnotation node) {
		int pos = -1;
		if((pos = checkLineNum(node)) == -1)
			return true;
		Name typeName = node.getTypeName();
		@SuppressWarnings("unchecked")
		List<Object> values = node.values();
		ArrayList<String> argsList= new ArrayList<String>();
		for(Object value:values)
			argsList.add(value.toString());
		AnnotationInfo annotationInfo = new AnnotationInfo(typeName.toString(),argsList);
		annotationInfo.setAnnotation(node);
		if(DEBUG)
			System.out.println("Annotation::"+annotationInfo);
		addVector(annotationInfo,pos);
		return true;
	}
	
	@Override
	public boolean visit(MethodInvocation node) {
		int pos = -1;
//		if((pos = checkLineNum(node)) == -1)
//			return true;
		List<MethodInvocation> methodList = splitMethod(node);
		for(MethodInvocation method:methodList){
			String methodName=method.getName().toString();	
			if(methodName.equals("run"))
				methodName.toCharArray();
			
			String packageName=getPackageName(method);
//			if(packageName==null)
//				continue;
			ArrayList<String> args = getArgs(method);
			MethodInfo methodInfo = new MethodInfo(methodName,packageName,args);
			methodInfo.setMethodInvoke(method);
			@SuppressWarnings("unused")
			String s = methodInfo.toString();
			if(DEBUG)
				System.out.println(methodInfo);
			addVector(methodInfo,pos);
		}
		return true;
	}
	
	public void beforeVisitor(FileVector fileVector,boolean flag,Map<Info,Integer> infoNumMap){
		this.fileVector = fileVector;
		this.isRemove = flag;
		this.infoNumMap=infoNumMap;
	}

	public void setChangeFlag(boolean flag) {
		this.isRemove = flag;
	}
	
	public void setMethodNumMap(Map<Info,Integer> infoNumMap){
		this.infoNumMap=infoNumMap;
	}
	
	private List<MethodInvocation> splitMethod(MethodInvocation node){
		List<MethodInvocation> methodList = new ArrayList<MethodInvocation>();
		methodList.add(node);
		Expression tmp = node.getExpression();
		while(tmp instanceof MethodInvocation){
			methodList.add((MethodInvocation)tmp);
			tmp = ((MethodInvocation)tmp).getExpression();
		}
		return methodList;
	}
	
	private String getPackageName(MethodInvocation node){
		Expression option = node.getExpression();

		if(option==null){
//			logger.info("Option is null leadin g to Package is null");
			return null;
		}
		if(option instanceof MethodInvocation){
			option = ((MethodInvocation)option).getName();
		}
		ITypeBinding bind = option.resolveTypeBinding();
		
		if(bind instanceof TypeBinding){
			cn.net.cobot.parsers.javaparser.internal.compiler.lookup.TypeBinding bindTmp = ((TypeBinding)bind).binding;
			if(bindTmp instanceof MissingTypeBinding){
				return bind.getBinaryName();
			}
		}
		if(bind==null)
			return null;
		return bind.getBinaryName();
	}
	
	private ArrayList<String> getArgs(MethodInvocation node){
		ArrayList<String> parameterList = new ArrayList<String>();
		SimpleName name = node.getName();			
		IBinding bind = name.resolveBinding();
		if(bind instanceof MethodBinding){
			((MethodBinding)bind).getDeclaredReceiverType();
			ITypeBinding[] parameterType = ((MethodBinding)bind).getParameterTypes();
			for(ITypeBinding parameter:parameterType){
				String binaryName = parameter.getBinaryName();
				if(parameter instanceof TypeBinding){
					cn.net.cobot.parsers.javaparser.internal.compiler.lookup.TypeBinding bindTmp = ((TypeBinding)parameter).getBinding();
					if(bindTmp instanceof BaseTypeBinding)
						binaryName=bindTmp.toString();
				}
				if(binaryName==null)
					binaryName=parameter.toString();
				parameterList.add(binaryName);

			}
		}
		return parameterList;
	}
	
	private void addVector(Info info, int pos){
		Integer number = infoNumMap.get(info);
		if(number==null)
			return;
		if(isRemove){
			fileVector.secVectors.get(pos).add("-"+String.valueOf(number));
		}else {
			fileVector.secVectors.get(pos).add("+"+String.valueOf(number));
		}
	}
	
	private int checkLineNum(ASTNode node){
		int start=node.getStartingLineNumber();
		int end = node.getEndingLineNumber();
		for(int i = 0; i < fileVector.changeSet.size(); i ++){
			HashMap<String, Integer> change = fileVector.changeSet.get(i);
			int changeStart = 0,changeEnd = 0;
			if(isRemove) {
				changeStart=change.get(DiffMsgInfCollect.DEL_POSSION);
				changeEnd = changeStart + change.get(DiffMsgInfCollect.DEL_WIDTH);
			}else {
				changeStart=change.get(DiffMsgInfCollect.ADD_POSSION);
				changeEnd = changeStart + change.get(DiffMsgInfCollect.ADD_WIDTH);
			}
			if((end>=changeStart&&end<changeEnd)||(start>=changeStart&&start<changeEnd)){
				return i;
			}
		}
		return -1;
	}
}