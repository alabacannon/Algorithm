import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

public class Main {
	static int n;
	static int m;
	static int[] sel;
	static StringBuilder sb;
	public static void main(String[] args) throws IOException {
		//System.setIn(new FileInputStream("data/input.txt"));
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		sb = new StringBuilder();
		sel = new int[m];
		permRepitition(0);
		System.out.print(sb.toString());
		
	}
	private static void permRepitition(int cnt) {
		if (cnt == m) {
			for (int num : sel) {
				sb.append(num + " ");
			}
			sb.append("\n");
			return;
		}
		for (int i = 1; i <= n; i++) {
			sel[cnt] = i;
			permRepitition(cnt+1);
		}
	}
}
