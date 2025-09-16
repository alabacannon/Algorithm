import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;


public class Main {
	static int n;
	static int[][] map;
	public static void main(String[] args) throws IOException {
		//System.setIn(new FileInputStream("data/input.txt"));
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		map = new int[n][n];
		int[][][] dp = new int[n+1][3][3];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < 3; j++) {
				for (int k = 0; k < 3; k++) {
					dp[i][j][k] = Integer.MAX_VALUE>>1;
				}
			}
		}
		for (int i = 0; i < 3; i++) {
			dp[0][i][i] = sc.nextInt();
		}
		for (int i = 1; i < n; i++) {
			for (int j = 0; j < 3; j++) {
				int tmp = sc.nextInt();
				for (int k = 0; k < 3; k++) {
					dp[i][j][k] = Math.min(dp[i-1][(j+1)%3][k] + tmp, dp[i-1][(j+2)%3][k] + tmp);
				}
			}
		}
		for (int j = 0; j < 3; j++) {
			for (int k = 0; k < 3; k++) {
				dp[n][j][k] = Math.min(dp[n-1][(j+1)%3][k], dp[n-1][(j+2)%3][k]);
			}
		}
		int min = Integer.MAX_VALUE;
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				if (i==j) min = Math.min(min, dp[n][i][j]); 
			}
		}
		System.out.println(min); 
	}
}
			

