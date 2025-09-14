import java.io.FileInputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {
	static class Edge implements Comparable<Edge> {
		int[] to;
		int weight;

		public Edge(int[] to, int weight) {
			this.to = to;
			this.weight = weight;
		}

		@Override
		public int compareTo(Edge o) {
			return this.weight - o.weight;
		}

	}

	static int n;
	static int[][] map;
	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };
	static StringBuilder sb;

	public static void main(String[] args) throws IOException {
		//System.setIn(new FileInputStream("data/input.txt"));
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		int t = 1;
		while (n != 0) {
			sb = new StringBuilder();
			sb.append("Problem ").append(t).append(": ");
			map = new int[n][n];
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					map[i][j] = sc.nextInt();
				}
			}
			djikstra();

			System.out.println(sb);
			n = sc.nextInt();
			t++;
		}
	}

	private static void djikstra() {
		int ans = 0;
		int[][] dist = new int[n][n];
		for (int i = 0; i < n; i++) {
			Arrays.fill(dist[i], Integer.MAX_VALUE);
		}
		PriorityQueue<Edge> pq = new PriorityQueue<>();
		pq.offer(new Edge(new int[] { 0, 0 }, map[0][0]));
		dist[0][0] = map[0][0];
		while (!pq.isEmpty()) {
			Edge cur = pq.poll();
			int x = cur.to[0], y = cur.to[1];
			if (dist[x][y] < cur.weight) continue;

			for (int d = 0; d < 4; d++) {
				int nx = x + dx[d];
				int ny = y + dy[d];
				if (outOfMap(nx, ny) || dist[nx][ny] <= cur.weight + map[nx][ny]) continue;
				
				dist[nx][ny] = cur.weight + map[nx][ny];
				pq.offer(new Edge(new int[] {nx,ny},dist[nx][ny]));
			}
		}
		sb.append(dist[n-1][n-1]);
	}

	private static boolean outOfMap(int nx, int ny) {
		return nx >= n || nx < 0 || ny >=n || ny < 0;
	}
}
