import java.io.FileInputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;


public class Main {
	public static void main(String[] args) throws IOException {
		//System.setIn(new FileInputStream("data/input.txt"));
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		for (int test_case = 1; test_case <= t; test_case++) {
			int n = sc.nextInt();
			sc.nextLine();
			int[] coins = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
			int m = sc.nextInt();
			int[] dp = new int[m+1];
			dp[0] = 0;
			for (int coin : coins) {
				if(coin > m) {
					break;
				}
				dp[coin]++;
				for (int i = coin; i <= m; i++) {
					dp[i] += dp[i-coin];
				}
			}
			System.out.println(dp[m]);
		}
	}
}
			
