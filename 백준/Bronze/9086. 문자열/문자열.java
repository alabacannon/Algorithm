import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;


public class Main {
	public static void main(String[] args) throws IOException {
		//System.setIn(new FileInputStream("data/input.txt"));
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		for (int test = 1; test <= t; test++) {
			String st = sc.next();
			System.out.print(st.charAt(0) +""+ st.charAt(st.length()-1) + "\n" );
		}
	}
}