import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) throws IOException {
//		System.setIn(new FileInputStream("data/input.txt"));
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		String ans;
		if (n >= 90) {
			ans = "A";
		} else if (n>=80) {
			ans = "B";
		} else if (n>=70) {
			ans = "C";
		} else if (n>=60) {
			ans = "D";
		} else{
			ans = "F";
		}
		System.out.println(ans);
	}
}