import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) throws IOException {
//		System.setIn(new FileInputStream("data/input.txt"));
		Scanner sc = new Scanner(System.in);
		long a = sc.nextLong();
		long b = sc.nextLong();
		System.out.println(countOne(b) - countOne(a-1));
	}

	private static long countOne(long n) {
		int countFormalOne = 0;
		long count = 0;
		for (long i = 63; i >= 0; i--) {
			if ((n & (1L << i)) != 0) {
				count += (1L<<i-1) * i + 1 + countFormalOne * (1L<<i);
				countFormalOne++;
			}
		}
		return count;
	}
}
