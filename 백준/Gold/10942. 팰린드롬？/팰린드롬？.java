import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main  {
	static int[] arr;
	static int n;
	static int m;
	static int[][] dp;
	public static void main(String[] args) throws IOException {
		//BufferedReader br = new BufferedReader(new FileReader("data/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		n = Integer.parseInt(br.readLine());
		arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		m = Integer.parseInt(br.readLine());
		dp = new int[n][n];
		dp[0][0] = 1;
		for (int i = 0; i < n-1; i++) {
			dp[i][i] = 1;
			updateDp(i,i);
			if (arr[i] == arr[i+1]) {
				dp[i][i+1] = 1;
				updateDp(i,i+1);
			}else {
				dp[i][i+1] = 0;
			}
		}
		dp[n-1][n-1] = 1;
		
		for (int i = 0; i < m; i++) {
			st =new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken())-1;
			int b = Integer.parseInt(st.nextToken())-1;
			sb.append(dp[a][b] + "\n");
		}
		System.out.println(sb.toString());
		br.close();
	}
	private static void updateDp(int i, int j) {
		while(--i >=0 && ++j < n) {
			if (arr[i] == arr[j]) {
				dp[i][j] = 1;
				continue;
			}
			return;
		}
	}
}