import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
 
public class Solution {
	static int[][] dist;
	static int n,m;
	final static int INF = Integer.MAX_VALUE>>1;
    public static void main(String[] args) throws IOException {
//		BufferedReader br = new BufferedReader(new FileReader("data/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		StringTokenizer st;
		for (int test_case = 1; test_case <= t; test_case++) {
			n = Integer.parseInt(br.readLine());
			m = Integer.parseInt(br.readLine());
			dist = new int[n+1][n+1];
			for (int i = 1; i <= n; i++) {
				Arrays.fill(dist[i], INF);
				dist[i][i] = 0;
			}
			for (int i = 0; i < m; i++) {
				st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				dist[a][b] = 1;
			}
			for (int k = 1; k <= n; k++) {
				for (int i = 1; i <= n; i++) {
					for (int j = 1; j <= n; j++) {
						dist[i][j] = Math.min(dist[i][j], dist[i][k] + dist[k][j]);
					}
				}
			}
			int ans = 0;
			outer : for (int i = 1; i <= n; i++) {
				for (int j = 1; j <= n; j++) {
					if (dist[i][j] == INF && dist[j][i] == INF) {
						continue outer;
					}
				}
				ans++;
			}
			
			
			System.out.println("#" + test_case + " " +ans);
			
		}
		

		br.close();
	}
}