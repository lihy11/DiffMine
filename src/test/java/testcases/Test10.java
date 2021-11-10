import java.util.Objects;

public class Test10 {
public static void main(String[] args) {
	String s1 = "";
	String s2 = null;
	System.out.println(s2.equals(s1));
	System.out.println(Objects.equals(s1, s2));
}
}
