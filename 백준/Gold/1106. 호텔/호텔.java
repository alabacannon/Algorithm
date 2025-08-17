import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) throws IOException {
//		System.setIn(new FileInputStream("data/input.txt"));
		Scanner sc = new Scanner(System.in);
		int c = sc.nextInt(); // 인원 수
		int n = sc.nextInt(); // 도시의 수
		int[][] arr = new int[n][2];		
		for (int i = 0; i < n; i++) {
			arr[i][0] = sc.nextInt(); // 비용
			arr[i][1] = sc.nextInt(); // 사람 수
		}
		int[] dp = new int[c + 101];
		Arrays.fill(dp,10000000);
		dp[0] = 0;
		for (int i = 1; i < dp.length; i++) {

			for (int j = 0; j < n; j++) {
				if (i - arr[j][1] < 0) {
					continue;
				}
				dp[i] = Math.min(dp[i - arr[j][1]] + arr[j][0], dp[i]);
			}
		}
		int result = Integer.MAX_VALUE;
		for (int i = c; i < dp.length; i++) {
			result = Math.min(result, dp[i]);
		}
		System.out.println(result);
		
		
	}
}