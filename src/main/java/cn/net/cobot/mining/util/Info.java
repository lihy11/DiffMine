package cn.net.cobot.mining.util;

import java.io.Serializable;
import java.util.ArrayList;

public class Info implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected String infoName;
	protected ArrayList<String> parameterList = new ArrayList<String>();
	
	public String getInfoName() {
		return infoName;
	}

}