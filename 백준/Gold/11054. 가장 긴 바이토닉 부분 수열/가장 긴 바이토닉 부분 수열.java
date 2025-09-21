import java.io.FileInputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Scanner;

public class Main {
	static int n;
	static int[] arr;
	public static void main(String[] args) throws IOException {
		//System.setIn(new FileInputStream("data/input.txt"));
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		sc.nextLine();
		arr = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		int[][] dp = new int[n][2];
		for (int i = 0; i < dp.length; i++) {
			Arrays.fill(dp[i], 1);
			
		}
		int ans = 1;
		for (int i = 1; i < n; i++) {
			for (int j = 0; j < i; j++) {
				if (arr[i] > arr[j]) {
					dp[i][0] = Math.max(dp[j][0]+1, dp[i][0]);
					ans = Math.max(ans, dp[i][0]);
				}
				if (arr[i] < arr[j]) {
					dp[i][1] = Math.max(dp[j][0]+1, dp[i][1]); 
					dp[i][1] = Math.max(dp[j][1]+1, dp[i][1]);
					ans = Math.max(ans, dp[i][1]);
				}
			}
		}
		System.out.println(ans);
	}
}