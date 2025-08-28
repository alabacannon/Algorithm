import java.io.FileInputStream;
import java.io.IOException;
import java.util.Iterator;
import java.util.Scanner;

public class Main {
	static int n;
	static int m;
	static int[] select;
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws IOException {
		//System.setIn(new FileInputStream("data/input.txt"));
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		select = new int[m];
		combination(0,1);
		System.out.print(sb.toString());
	}

	private static void combination(int k, int idx) {
		if(k == m) {
			for (int i = 0; i < m; i++) {
				sb.append(select[i] + " ");
			}
			sb.append("\n");
			return;
		}
		for (int i = idx; i <= n; i++) {
			select[k] = i;
			combination(k+1, i);
			
		}
	}
}
