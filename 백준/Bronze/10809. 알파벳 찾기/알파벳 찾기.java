import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) throws IOException {
//		System.setIn(new FileInputStream("data/input.txt"));
		Scanner sc = new Scanner(System.in);
		char[] word = sc.next().toCharArray();
		outer : for (char c = 'a'; c <= 'z'; c++) {
			for (int i = 0; i < word.length; i++) {
				if (word[i] == c) {
					System.out.print(i + " ");
					continue outer;
				}
			}
			System.out.print(-1 + " ");
		}
	}
}