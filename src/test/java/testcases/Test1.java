import java.util.HashMap;

/*
 * map 方法的替换策略
 * */
public class Test1 {
	public static void main(String[] args) {
		HashMap<String, String> map = new HashMap<String, String>();
		map.put("1", "2");
		map.put("3", "4");
		for(String key : map.keySet()) {
			String value = map.get(key);
			System.out.println(key + value);
		}
		/*
		 * 正确写法应该是遍历entryset，
		 * for(Map.Entry<String, String> entry : map.entrySet()){
		 * 		String key = entry.getKey();
		 * 		String value = entry.getValue();
		 * }
		 * */
	}
}
