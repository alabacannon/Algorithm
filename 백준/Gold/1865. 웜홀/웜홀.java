import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.Iterator;
import java.util.Scanner;

public class Main {
	static final int INF = Integer.MAX_VALUE>>2;
	public static void main(String[] args) throws IOException {
		//System.setIn(new FileInputStream("data/input.txt"));
		Scanner sc = new Scanner(System.in);
		int tc = sc.nextInt();
		for (int test_case = 0; test_case < tc; test_case++) {
			int n = sc.nextInt(), m = sc.nextInt(), w = sc.nextInt();
			int[][] dist = new int[n][n];
			for (int i = 0; i < dist.length; i++) {
				Arrays.fill(dist[i], INF);
				dist[i][i] = 0;
			}
			for (int i = 0; i < m; i++) { // 도로 -> 양방향
				int s= sc.nextInt()-1, e = sc.nextInt()-1, t = sc.nextInt();
				dist[s][e] = Math.min(dist[s][e], t);
				dist[e][s] = Math.min(dist[e][s], t);
			}
			for (int i = 0; i < w; i++) { // 웜홀 -> 단방향
				int s= sc.nextInt()-1, e = sc.nextInt()-1, t = sc.nextInt();
				dist[s][e] = -t;
			}
			for (int k = 0; k < n; k++) {
				for (int i = 0; i < n; i++) {
					for (int j = 0; j < n; j++) {
						dist[i][j] = Math.min(dist[i][j], dist[i][k]+dist[k][j]);
					}
				}
			}
			boolean flag = true;
			for (int i = 0; i < n; i++) {
				if (dist[i][i] < 0) {
					System.out.println("YES");
					flag = false;
					break;
				}
			}
			if (flag) {
				System.out.println("NO");
			}
		}
	}
}