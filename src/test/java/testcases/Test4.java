import java.util.Optional;

public class Test4 {

	public static void main(String[] args) {
		int a = 1;
		String bString = null;
		System.out.println(Optional.of(a));
		System.out.println(Optional.ofNullable(bString));
	}
}
