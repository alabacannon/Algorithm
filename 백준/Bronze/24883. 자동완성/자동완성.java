import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) throws IOException {
//		System.setIn(new FileInputStream("data/input.txt"));
		Scanner sc = new Scanner(System.in);
		char c = sc.next().charAt(0);
		if (c == 'n' || c == 'N') {
			System.out.println("Naver D2");
		} else {
			
			System.out.println("Naver Whale");
		}
	}	
	
}
