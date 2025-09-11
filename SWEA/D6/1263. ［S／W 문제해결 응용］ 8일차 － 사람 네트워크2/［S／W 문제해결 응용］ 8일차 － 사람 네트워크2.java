import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
 
public class Solution {
	static int[][] dist;
	static int n;
    public static void main(String[] args) throws IOException {
//		BufferedReader br = new BufferedReader(new FileReader("data/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		StringTokenizer st;
		for (int test_case = 1; test_case <= t; test_case++) {
			st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			dist = new int[n][n];
			for (int i = 0; i < n; i++) {
				Arrays.fill(dist[i], Integer.MAX_VALUE>>1);
				dist[i][i] = 0;
				for (int j = 0; j < n; j++) {
					int tmp = Integer.parseInt(st.nextToken());
					if (tmp !=0) {
						dist[i][j] = tmp;
					}
				}
			}
			
			for (int k = 0; k < n; k++) {
				for (int i = 0; i < n; i++) {
					for (int j = 0; j < n; j++) {
						dist[i][j] = Math.min(dist[i][j], dist[i][k] + dist[k][j]);
					}
				}
			}
			int ans = Integer.MAX_VALUE;
			for (int i = 0; i < n; i++) {
				int tmp = 0;
				for (int j = 0; j < n; j++) {
					tmp += dist[i][j];
				}
				ans = Math.min(tmp, ans);
			}
			System.out.println("#" + test_case + " " +ans);
			
		}
		

		br.close();
	}
}