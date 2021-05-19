package cn.net.cobot.mining.action;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.SequenceFile;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.util.ToolRunner;
import org.apache.mahout.common.AbstractJob;
import org.apache.mahout.common.Pair;
import org.apache.mahout.common.Parameters;
import org.apache.mahout.fpm.pfpgrowth.convertors.ContextStatusUpdater;
import org.apache.mahout.fpm.pfpgrowth.convertors.SequenceFileOutputCollector;
import org.apache.mahout.fpm.pfpgrowth.convertors.string.StringOutputConverter;
import org.apache.mahout.fpm.pfpgrowth.convertors.string.TopKStringPatterns;
import org.apache.mahout.fpm.pfpgrowth.fpgrowth.FPGrowth;

import com.google.common.collect.Sets;
import com.google.common.io.Closeables;

public class FPGrowthRunner extends AbstractJob {

	public static List<Pair<List<String>, Long>> dataset = null;
	public static List<Pair<String, TopKStringPatterns>> frequentPatterns; 
	
	
	@SuppressWarnings("static-access")
	public static void main(String[] args) throws Exception {
		FPGrowthRunner runner = new FPGrowthRunner();
		List<Pair<List<String>, Long>> data = new ArrayList<Pair<List<String>,Long>>();
		for(int i = 0; i < 10; i ++) {
			List<String> strings= new ArrayList<String>();
			strings.add(String.valueOf(i));
			strings.add(String.valueOf(i+1));
			strings.add(String.valueOf(i+2));
			System.out.println(strings);
			data.add(new Pair<List<String>, Long>(strings, new Long(1)));
		}
		runner.dataset = data;
		ToolRunner.run(new Configuration(), runner, args);
	}

	/**
	 * Run TopK FPGrowth given the input file,
	 */
	@Override
	public int run(String[] args) throws Exception {
		addOutputOption();

		addOption("minSupport", "s",
				"(Optional) The minimum number of times a co-occurrence must be present." + " Default Value: 3", "3");
		addOption("maxHeapSize", "k",
				"(Optional) Maximum Heap Size k, to denote the requirement to mine top K items." + " Default value: 50",
				"50");
		if (parseArguments(args) == null) {
			return -1;
		}

		Parameters params = new Parameters();

		if (hasOption("minSupport")) {
			String minSupportString = getOption("minSupport");
			params.set("minSupport", minSupportString);
		}
		if (hasOption("maxHeapSize")) {
			String maxHeapSizeString = getOption("maxHeapSize");
			params.set("maxHeapSize", maxHeapSizeString);
		}
		Path outputDir = getOutputPath();
		params.set("output", outputDir.toString());
		runFPGrowth(params);
		return 0;
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	private static void runFPGrowth(Parameters params) throws IOException {
		int maxHeapSize = Integer.valueOf(params.get("maxHeapSize", "50"));
		int minSupport = Integer.valueOf(params.get("minSupport", "3"));

		Path output = new Path(params.get("output", "output.txt"));

		Configuration conf = new Configuration();
		FileSystem fs = FileSystem.get(output.toUri(), conf);

		SequenceFile.Writer writer = new SequenceFile.Writer(fs, conf, output, Text.class, TopKStringPatterns.class);

		Collection<String> features = Sets.newHashSet();

		FPGrowth<String> fp = new FPGrowth<String>();

		try {
			fp.generateTopKFrequentPatterns(dataset.iterator(),
					fp.generateFList(dataset.iterator(), minSupport), minSupport, maxHeapSize,
					features,
					new StringOutputConverter(new SequenceFileOutputCollector<Text, TopKStringPatterns>(writer)),
					new ContextStatusUpdater(null));
		} finally {
			Closeables.close(writer, false);
		}

		frequentPatterns = FPGrowth.readFrequentPattern(conf, output);
	}
}
