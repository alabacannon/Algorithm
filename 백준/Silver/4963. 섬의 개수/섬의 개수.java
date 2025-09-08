import java.io.FileInputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
	static int[][] map;
	static int h,w;
	static boolean[][] visited;
	static int[] dx = {-1,0,1,1,1,0,-1,-1};
	static int[] dy = {1,1,1,0,-1,-1,-1,0};
	public static void main(String[] args) throws IOException {
		//System.setIn(new FileInputStream("data/input.txt"));
		Scanner sc = new Scanner(System.in);
		while (true) {
			w = sc.nextInt();
			h = sc.nextInt();
			if (w ==0 && h == 0) {
				return;
			}
			map = new int[h][w];
			visited = new boolean[h][w];
			sc.nextLine();
			for (int i = 0; i < h; i++) {
				map[i] = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
			}
			int ans = 0;
			for (int i = 0; i < h; i++) {
				for (int j = 0; j < w; j++) {
					if (map[i][j] == 1 && !visited[i][j]) {
						ans++;
						dfs(i,j);
					}
				}
			}
			
			System.out.println(ans);
		}
	}
	private static void dfs(int x, int y) {
		visited[x][y] = true;
		for (int d = 0; d < 8; d++) {
			int nx = x + dx[d];
			int ny = y + dy[d];
			if (outOfMap(nx,ny)) continue;
			if(visited[nx][ny] || map[nx][ny] == 0) continue;
			visited[nx][ny] = true;
			dfs(nx,ny);
		}
	}
	private static boolean outOfMap(int nx, int ny) {
		return nx >= h || nx<0 || ny >= w || ny<0;
	}
}
