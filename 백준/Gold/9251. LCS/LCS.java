import java.io.FileInputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) throws IOException {
//		System.setIn(new FileInputStream("data/input.txt"));
		Scanner sc = new Scanner(System.in);
		char[] s1 = sc.next().toCharArray();
		char[] s2 = sc.next().toCharArray();
		int n = s1.length;
		int m = s2.length;
		int[][] dp = new int[n+1][m+1];
		for (int i = 1; i <=n; i++) {
			for (int j = 1; j <= m; j++) {
				if (s1[i-1] == s2[j-1]) {
					dp[i][j] = dp[i-1][j-1] + 1;
				} else {
					dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
				}
			}			
		}
		System.out.println(dp[n][m]);
	}
}