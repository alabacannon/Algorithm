import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Solution {
	static int[][] map;
	static char[][] tmp;
	static int n, ans;
	static int[] dx = {-1,-1,-1,1,1,1,0,0};
	static int[] dy = {-1,1,0,-1,1,0,-1,1};
	static boolean[][] visited;
	public static void main(String[] args) throws IOException {
//		BufferedReader br = new BufferedReader(new FileReader("data/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		StringTokenizer st;
		for (int test_case = 1; test_case <= t; test_case++) {
			n = Integer.parseInt(br.readLine());
			tmp = new char[n][n];
			map = new int[n][n];
			visited = new boolean[n][n];
			for (int i = 0; i < n; i++) {
				tmp[i] = br.readLine().toCharArray();
			}
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					if (tmp[i][j] == '*') {
						map[i][j] = -1;
					} else {
						updateMap(i,j);
					}
				}
			}
			
			ans = 0;
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					if (map[i][j] == 0 && !visited[i][j]) {
						bfs(i,j);
					}
				}
			}
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					if (map[i][j] > 0 && !visited[i][j]) {
						ans++;
					}
				}
			}
			
			System.out.println("#" + test_case + " " + ans);
		}
		br.close();
	}
	private static void updateMap(int x, int y) {
		int mineCount = 0;
		for (int d = 0; d < 8; d++) {
			int nx = x + dx[d];
			int ny = y + dy[d];
//			System.out.println(nx + " " + ny);
//			System.out.println(outOfMap(nx,ny));
			if (outOfMap(nx,ny)) continue;
			if (tmp[nx][ny] == '*') mineCount++;
		}
		map[x][y] = mineCount;
	}
	
	private static void bfs(int x, int y) {
		Deque<int[]> queue = new ArrayDeque<>();
		queue.offer(new int[] {x,y});
		visited[x][y] = true;
		ans++;
		while (!queue.isEmpty()) {
			int[] node = queue.poll();
			x = node[0];
			y = node[1];
			if (map[x][y] > 0 ) continue;
			
			for (int d = 0; d < 8; d++) {
				int nx = x + dx[d];
				int ny = y + dy[d];
				if (outOfMap(nx, ny)) continue;
				if (visited[nx][ny]) continue;
				visited[nx][ny] = true;
				queue.offer(new int[] {nx,ny});
			}
		}
	}
	
	private static boolean outOfMap(int nx, int ny) {
		return nx >= n || nx < 0 || ny >= n || ny < 0;
	}
}