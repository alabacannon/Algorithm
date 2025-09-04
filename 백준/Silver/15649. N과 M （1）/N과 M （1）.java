import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

public class Main {
	static int n;
	static int m;
	static int[] sel;
	public static void main(String[] args) throws IOException {
		//System.setIn(new FileInputStream("data/input.txt"));
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		sel = new int[m];
		permutation(0,0);
		
	}
	private static void permutation(int cnt, int visited) {
		if (cnt == m) {
			for (int num : sel) {
				System.out.print(num + " ");
			}
			System.out.println();
            return;
		}
		for (int i = 1; i <= n; i++) {
			if ((visited & (1<<i)) != 0) continue; 	
			sel[cnt] = i;
			permutation(cnt+1,visited|(1<<i));
		}
	}
}
