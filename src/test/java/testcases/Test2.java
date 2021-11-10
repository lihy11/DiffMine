import java.util.ArrayList;
import java.util.List;

public class Test2 {
	public static void main(String[] args) {
		List<String> list = new ArrayList<String>();
		list.add("0");
		String keyString = list.get(1);  //  应该判断界限
		System.out.println(keyString);
	}
}
