import java.io.FileInputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;


public class Main {
	static int n,m,r;
	static int[][] dist;
	public static void main(String[] args) throws IOException {
		//System.setIn(new FileInputStream("data/input.txt"));
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		r = sc.nextInt();
		int[] arr = new int[n+1];
		dist = new int[n+1][n+1];
		sc.nextLine();
		StringTokenizer st = new StringTokenizer(sc.nextLine());
		for (int i = 1; i <= n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		for (int i = 1; i <= n; i++) {
			Arrays.fill(dist[i], Integer.MAX_VALUE>>1);
			dist[i][i] = 0;
		}
		for (int i = 0; i < r; i++) {
			st = new StringTokenizer(sc.nextLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int l = Integer.parseInt(st.nextToken());
			dist[a][b] = l;
			dist[b][a] = l;
		}
		for (int k = 1; k <= n; k++) {
			for (int i = 1; i <= n; i++) {
				for (int j = 1; j <= n; j++) {
					dist[i][j] = Math.min(dist[i][j], dist[i][k] + dist[k][j]); 
				}
			}
		}
		int ans = 0;
		for (int i = 1; i <= n; i++) {
			int tmp = 0;
			for (int j = 1; j <= n; j++) {
				if (dist[i][j] <= m) tmp += arr[j];
			}
			ans = Math.max(ans, tmp);
		}
		System.out.println(ans);
	}
}
			