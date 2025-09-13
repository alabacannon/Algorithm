import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {
	static int n,m,curX,curY,hx,hy,ex,ey;
	static final int INF = Integer.MAX_VALUE>>1;
	static final int[] dx = {-1,1,0,0};
	static final int[] dy = {0,0,-1,1};
	static int[][] map;
	static int[][][] dist;
	static Deque<int[]> queue;
	public static void main(String[] args) throws IOException {
//		BufferedReader br = new BufferedReader(new FileReader("data/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		hx = Integer.parseInt(st.nextToken())-1;
		hy = Integer.parseInt(st.nextToken())-1;
		st = new StringTokenizer(br.readLine());
		ex = Integer.parseInt(st.nextToken())-1;
		ey = Integer.parseInt(st.nextToken())-1;
		map = new int[n][m];
		dist = new int[n][m][2];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				for (int k = 0; k < 2; k++) {
					dist[i][j][k] = INF;
				}
			}
		}
		for (int i = 0; i < n; i++) {
			map[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		}
		bfs();
		int ans0 = dist[ex][ey][0];
		int ans1 = dist[ex][ey][1];
		if (ans0 == INF&& ans1 == INF ) {
			System.out.println(-1);
		} else {
			System.out.println(Math.min(dist[ex][ey][0], dist[ex][ey][1]));
		}
		br.close();
	}
	private static void bfs() {
		queue = new ArrayDeque<>();
		queue.offer(new int[] {hx,hy,0});
		dist[hx][hy][0] = 0;
		dist[hx][hy][1] = 0;
		while (!queue.isEmpty()) {
			int[] cur = queue.poll();
			curX = cur[0];
			curY = cur[1];
			if (curX == ex && curY == ey) return; 
			int breakCount = cur[2];
			for (int d = 0; d < 4; d++) {
				int nx = curX + dx[d];
				int ny = curY + dy[d];
				if (outOfMap(nx,ny)) continue; 
				if (breakCount == 0) {
					moveWithStaff(nx,ny);
				} else {
					moveWithOutStaff(nx,ny);
				}
			}
		}
	}
	
	private static void moveWithStaff(int nx, int ny) {
		if (map[nx][ny] == 1 && dist[nx][ny][1] > dist[curX][curY][0] + 1) {
			queue.offer(new int[] {nx,ny,1});
			dist[nx][ny][1] = dist[curX][curY][0] + 1;
		} else if(map[nx][ny] == 0 && dist[nx][ny][0] > dist[curX][curY][0] + 1) {
			queue.offer(new int[] {nx,ny,0});
			dist[nx][ny][0] = dist[curX][curY][0] + 1;
		}
		
	}
	private static void moveWithOutStaff(int nx, int ny) {
		if (map[nx][ny] == 0 && dist[nx][ny][1] > dist[curX][curY][1] + 1) {
			queue.offer(new int[] {nx,ny,1});
			dist[nx][ny][1] = dist[curX][curY][1] + 1;
		}
	}
	private static boolean outOfMap(int nx, int ny) {
		return nx >= n || nx <0 || ny >= m || ny <0;
	}
}
