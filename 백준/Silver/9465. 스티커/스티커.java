import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Iterator;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		//BufferedReader br = new BufferedReader(new FileReader("data/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		int t = Integer.parseInt(br.readLine());
		
		for (int test = 0; test < t; test++) {
			int n = Integer.parseInt(br.readLine());
			int[][] sticker = new int[2][n];
			for (int i = 0; i < 2; i++) {
				sticker[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();				
			}
			
			int[][] dp = new int[3][n];
			dp[0][0] = sticker[0][0];
			dp[1][0] = sticker[1][0];  
			dp[2][0] = 0;
			
			for (int i = 1; i < n; i++) {
				dp[0][i] = Math.max(dp[1][i-1], dp[2][i-1]) + sticker[0][i];
				dp[1][i] = Math.max(dp[0][i-1], dp[2][i-1]) + sticker[1][i];
				dp[2][i] = Math.max(dp[0][i-1], dp[1][i-1]);
			}
			System.out.println(Math.max(dp[0][n-1], dp[1][n-1]));
			
		}
	}
}
