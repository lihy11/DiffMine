package cn.net.cobot.mining.model;

import java.util.ArrayList;
import java.util.List;

public class FrequentSetSupportInfo {

	public List<FileVector> fileVectors;
	public List<Integer> varietyPossionInFileVectors;
	public List<String> frequentSet;

	public FrequentSetSupportInfo(List<String> frequentSet) {
		fileVectors = new ArrayList<FileVector>();
		varietyPossionInFileVectors = new ArrayList<Integer>();
		this.frequentSet = frequentSet;
	}
}
