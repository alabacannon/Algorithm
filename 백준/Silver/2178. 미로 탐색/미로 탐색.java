import java.io.FileInputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
	static int n;
	static int m;
	static int ans;
	static int[][] map;
	static int[][] distance;
	public static void main(String[] args) throws IOException {
		//System.setIn(new FileInputStream("data/input.txt"));
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		sc.nextLine();
		map = new int[n][m];
		distance = new int[n][m];
		for (int i = 0; i < n; i++) {
			char[] temp = sc.nextLine().toCharArray();
			for (int j = 0; j < temp.length; j++) {
				map[i][j] = temp[j]-'0';
			}
		}
		ans = 0;
		for (int i = 0; i < n; i++) {
			Arrays.fill(distance[i], Integer.MAX_VALUE);
		}
		distance[0][0] = 1;
		dfs(0,0);
		System.out.println(distance[n-1][m-1]);
		
	}
	private static void dfs(int x, int y) {
		if (x == n-1 && y == m-1) {
			return;
		}
		int[] dx = {-1,1,0,0};
		int[] dy = {0,0,1,-1};
		for (int d = 0; d < 4; d++) {
			int nx = x + dx[d];
			int ny = y + dy[d];
			if (isOutOfMap(nx,ny)) continue;
			if ((distance[nx][ny] != Integer.MAX_VALUE && distance[nx][ny] <= distance[x][y] + 1)|| map[nx][ny] == 0) continue;
			distance[nx][ny] = distance[x][y] + 1;
			dfs(nx,ny);
		}
	}
	private static boolean isOutOfMap(int nx, int ny) {
		return nx>= n || nx<0 || ny >= m || ny<0;
	}
}
