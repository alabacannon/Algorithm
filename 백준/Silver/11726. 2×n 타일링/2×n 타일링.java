import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static long[] dp = new long[1001];
	public static int n;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		n = Integer.parseInt(br.readLine());
		
		
		dp[1] = 1;
		dp[2] = 2;
		dp[3] = 3;
		
		if(n <= 3) {
			System.out.println(dp[n]);
		} else {
			int idx = 4;
			while(idx <= n) {
				dp[idx] = (dp[idx-2]*2 + dp[idx-3]) % 10007;
				idx++;
			}
			System.out.println(dp[n]);
		}	
	}
}
