import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;


public class Main {
	public static void main(String[] args) throws IOException {
		//System.setIn(new FileInputStream("data/input.txt"));
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		if (n <= 9) {
			System.out.println(0);
			return;
		}
		int flag = (1<<10)-1;
		// 1~n 각각에 대해 비트상태 별로, 현재 숫자에 따라, 가능한 경우의 가짓 수 저장
		long[][][] dp = new long[n+1][10][1<<10];
		for (int i = 1; i <= 9; i++) {
			dp[1][i][1<<i] = 1;
		}
		for (int i = 1; i < n; i++) {
			for (int num = 0; num <= 9; num++) {
				for (int j = 0; j < 1<<10; j++) {
					int[] nexts = findNext(num);
					for (int next : nexts) {
						dp[i+1][next][j|1<<next] = ((dp[i + 1][next][j | (1 << next)] + dp[i][num][j]))%1000000000;
					}
					
				}
			}
		}
		long ans = 0;
		for (int i = 0; i < 10; i++) {
			ans = (ans + dp[n][i][flag])%1000000000;
			
		}
		System.out.println(ans);
			
	}

	private static int[] findNext(int cur) {
		if (cur == 0) {
			return new int[] {1};
		}
		if (cur == 9) {
			return new int[] {8};
		}
		return new int[] {cur-1,cur+1};
	}
}
			
