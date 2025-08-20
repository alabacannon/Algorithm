import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {
	static char[][] map;
	static boolean[][] visited;
	static int m;
	static int n;
	public static void main(String[] args) throws IOException {
//		System.setIn(new FileInputStream("data/input.txt"));
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		map = new char[n][m];
		visited = new boolean[n][m];
		int startI = 0;
		int startJ = 0; 
		sc.nextLine();
		for (int i = 0; i < n; i++) {
			map[i] = sc.nextLine().toCharArray();
			for (int j = 0; j < m; j++) {
				if(map[i][j] == 'I') {
					 startI = i;
					 startJ = j;
				}
			}
		}
		
		bfs(startI,startJ);
		
	}
	private static void bfs(int startI, int startJ) {
		Deque<int[]> queue = new ArrayDeque<>();
		int ans = 0;
		queue.offer(new int[] {startI,startJ});
		visited[startI][startJ] = true;
		int[] dx = {-1,1,0,0};
		int[] dy = {0,0,-1,1};
		while (!queue.isEmpty()) {
			int[] node = queue.poll();
			int currentx = node[0], currenty = node[1];
			for (int d = 0; d < 4; d++) {
				int nx = currentx + dx[d];
				int ny = currenty + dy[d];
				if (isOutOfMap(nx,ny)) {
					continue;
				}
				if (visited[nx][ny] || map[nx][ny] == 'X') {
					continue;
				}
				if (map[nx][ny] == 'P') {
					ans++;
				}
				queue.offer(new int[] {nx,ny});
				visited[nx][ny] = true;
			}
		}
		if (ans == 0) {
			System.out.println("TT");
		}else {
			System.out.println(ans);
		}
		
		
	}
	private static boolean isOutOfMap(int nx, int ny) {
		return nx >=n || nx<0 || ny >=m || ny<0;
	}
}