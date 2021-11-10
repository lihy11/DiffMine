import java.util.ArrayList;
import java.util.List;

public class Test6 {
	public static void main(String[] args) {
		List<String> list = new ArrayList<String>();
		List<String> list2 = new ArrayList<String>();
		for(String s : list) {
			list2.add(s);
		}
		list2.addAll(list);
	}
	
}
