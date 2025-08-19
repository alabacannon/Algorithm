import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) throws IOException {
//		System.setIn(new FileInputStream("data/input.txt"));
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[][] dp = new int[n][3];
		dp[0][0] = sc.nextInt();
		dp[0][1] = sc.nextInt();
		dp[0][2] = sc.nextInt();
		for (int i = 1; i < n; i++) {
			int r = sc.nextInt();
			int g = sc.nextInt();
			int b = sc.nextInt();
			dp[i][0] = Math.min(dp[i-1][1], dp[i-1][2]) + r;
			dp[i][1] = Math.min(dp[i-1][0], dp[i-1][2]) + g;
			dp[i][2] = Math.min(dp[i-1][0], dp[i-1][1]) + b;
		}
		System.out.println(Arrays.stream(dp[n-1]).min().orElse(-1));
	}
}