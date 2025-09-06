import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int n,m;
	static int[][] dist;
	public static void main(String[] args) throws IOException {
//		BufferedReader br = new BufferedReader(new FileReader("data/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		n = Integer.parseInt(br.readLine());
		m = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		dist = new int[n+1][n+1];
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= n; j++) {
				if (i!=j) {
					dist[i][j] = Integer.MAX_VALUE>>1;
				}
			}
		}
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			int cost = Integer.parseInt(st.nextToken());
			if (dist[start][end] > cost) {
				dist[start][end] = cost;
				
			}
		}
		for (int k = 1; k <= n; k++) {
			for (int i = 1;i <= n; i++) {
				for (int j = 1; j <= n; j++) {
					dist[i][j] = Math.min(dist[i][j], dist[i][k] + dist[k][j]);
				}
			
			}
		}
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= n; j++) {
				if (dist[i][j] == Integer.MAX_VALUE>>1) {
					sb.append(0).append(" ");
				} else {
					sb.append(dist[i][j]).append(" ");
				}
			}
			sb.append("\n");
		}
		System.out.println(sb.toString());
		

		br.close();

	}
}