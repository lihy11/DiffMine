
public class Test7 {
	public static void main(String[] args) {
		Long t1 = System.currentTimeMillis();
		int a = 0;
		for(int i = 0; i < 10000; i ++) {
			a++;
		}
		Long t2 = System.currentTimeMillis();
		
		System.out.println(t2-t1);
	}
}
