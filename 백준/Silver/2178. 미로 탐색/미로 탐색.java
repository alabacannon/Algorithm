import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.Scanner;

public class Main {
	static int n;
	static int m;
	static int ans;
	static int[][] map;
	static int[][] dist;
	public static void main(String[] args) throws IOException {
		//System.setIn(new FileInputStream("data/input.txt"));
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		sc.nextLine();
		map = new int[n][m];
		dist = new int[n][m];
		for (int i = 0; i < n; i++) {
			char[] temp = sc.nextLine().toCharArray();
			for (int j = 0; j < temp.length; j++) {
				map[i][j] = temp[j]-'0';
			}
		}
		for (int i = 0; i < args.length; i++) {
			Arrays.fill(dist[i], Integer.MAX_VALUE); 
		}
		ans = 0;
		dist[0][0] = 1;
		bfs(0,0);
		System.out.println(dist[n-1][m-1]);
		
	}
	private static void bfs(int x, int y) {
		Deque<int[]> queue = new ArrayDeque<>();
		int[] dx = {-1,1,0,0};
		int[] dy = {0,0,1,-1};
		queue.offer(new int[] {0,0});
		while (!queue.isEmpty()) {
			int[] node = queue.poll();
			for (int d = 0; d < 4; d++) {
				int nx = node[0] + dx[d];
				int ny = node[1] + dy[d];
				if (isOutOfMap(nx,ny)) continue;
				if (dist[nx][ny] != 0 || map[nx][ny] == 0) continue;
				dist[nx][ny] = dist[node[0]][node[1]] + 1;
				queue.offer(new int[] {nx,ny});
				if (nx == n-1 && ny == m-1) return;
			}

		}
	}
	private static boolean isOutOfMap(int nx, int ny) {
		return nx>= n || nx<0 || ny >= m || ny<0;
	}
}
