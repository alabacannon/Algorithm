import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) throws IOException {
		//System.setIn(new FileInputStream("data/input.txt"));
		Scanner sc = new Scanner(System.in);
		int n = 5;
		long ans = 0; 
		for (int i = 0; i <n; i++) {
			ans += sc.nextLong();
		}
		System.out.println(ans);
	}	
	
}
