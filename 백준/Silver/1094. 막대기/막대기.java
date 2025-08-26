import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) throws IOException {
//		System.setIn(new FileInputStream("data/input.txt"));
		Scanner sc = new Scanner(System.in);
		int x = sc.nextInt();
		int count = 0;
		while (x != 0) {
			if ((x&1)==1)count++;
			x>>=1;
		}
		System.out.println(count);
		
	}
}
