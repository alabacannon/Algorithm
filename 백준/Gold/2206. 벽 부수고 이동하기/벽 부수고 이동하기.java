import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class Main {
	static int[][] map;
	static int[][][] visited;
	static int n;
	static int m;
	static Deque<int[]> queue;
	static int ans;
	public static void main(String[] args) throws IOException {
//		System.setIn(new FileInputStream("data/input.txt"));
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		sc.nextLine();
		map = new int[n][m];
		visited = new int[n][m][2];
		for (int i = 0; i < n; i++) {
			map[i] = sc.nextLine().chars().map(c -> c-'0').toArray();
		}
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				visited[i][j][0] = Integer.MAX_VALUE;
				visited[i][j][1] = Integer.MAX_VALUE;
			}
		}
		wallBreakBfs();
		if (Math.min(visited[n-1][m-1][1], visited[n-1][m-1][0]) == Integer.MAX_VALUE) {
			ans = -1;
		}
		System.out.println(ans);
	}
	private static void wallBreakBfs() {
		int[] dx = {-1,1,0,0};
		int[] dy = {0,0,-1,1};
		queue = new ArrayDeque<>();
		queue.offerLast(new int[] {0,0,0});
		visited[0][0][0] = 1;
		visited[0][0][1] = 1;
		while (!queue.isEmpty()) {
			int[] node = queue.pollFirst();
			int currentx = node[0], currenty = node[1], wallBreakCount = node[2];
			if (currentx == n-1 && currenty == m-1) {
				ans = Math.min(visited[n-1][m-1][0],visited[n-1][m-1][1]);
			}
			int distance = visited[currentx][currenty][wallBreakCount];
//			System.out.println("x : " + currentx + "   y : " + currenty + "  d : "+ distance);
			for (int d = 0; d < 4; d++) {
				int nx = currentx + dx[d], ny = currenty + dy[d];
				if (isOutOfMap(nx,ny)) {
					continue;
				}
				goToNextPoint(wallBreakCount, distance, nx, ny);
			}
		}
	}
	private static void goToNextPoint(int wallBreakCount, int distance, int nx, int ny) {
		if (wallBreakCount == 0) {
			if (map[nx][ny] == 1 && distance+1 < visited[nx][ny][1]) {
				queue.offerLast(new int[] {nx,ny,1});
				visited[nx][ny][1] = distance+1;
			} else if (map[nx][ny] == 0 && distance+1 < visited[nx][ny][0]) {
				queue.offerLast(new int[] {nx,ny,0});
				visited[nx][ny][0] = distance+1;
			} else {
				return;
			}
		} else { //벽 이미 부순 경우
			if (map[nx][ny] == 0 && distance+1 < visited[nx][ny][1]) {
				queue.offerLast(new int[] {nx,ny,1});
				visited[nx][ny][1] = distance+1;
			} else {
				return;
			}
		}
	}
	
	private static boolean isOutOfMap(int nx, int ny) {
		return nx < 0 || nx >= n || ny < 0 || ny >= m;
	}
}