import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int n,m,x;
	static int[][] dist;
	public static void main(String[] args) throws IOException {
//		BufferedReader br = new BufferedReader(new FileReader("data/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken()); // 마을의 수 & 학생 수
		m = Integer.parseInt(st.nextToken()); // 간선
		x = Integer.parseInt(st.nextToken())-1; // 축제 마을
		dist = new int[n][n];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (i != j) {
					dist[i][j] = Integer.MAX_VALUE>>1;
				}
			}
		}
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken())-1;
			int end = Integer.parseInt(st.nextToken())-1;
			int t = Integer.parseInt(st.nextToken());
			dist[start][end] = t;
		}
		for (int k = 0; k < n; k++) {
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					dist[i][j] = Math.min(dist[i][j], dist[i][k] + dist[k][j]);
				}
			}
		}
		int ans = -1;
		for (int i = 0; i < n; i++) {
			if (dist[i][x] == Integer.MAX_VALUE>>1 || dist[x][i] == Integer.MAX_VALUE>>1) {
				
			}
			ans = Math.max(ans, dist[i][x] + dist[x][i]);
		}
		System.out.println(ans);

		br.close();
	}
}
