import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.Scanner;

public class Main {
	static int n,l,r;
	static int[] dx = {-1,1,0,0};
	static int[] dy = {0,0,-1,1};
	static int[][] map;
	static boolean[][] visited;
	static ArrayList<ArrayList<int[]>> allaiance;
	static boolean flag;
	public static void main(String[] args) throws IOException {
		//System.setIn(new FileInputStream("data/input.txt"));
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		l = sc.nextInt();
		r = sc.nextInt();
		map = new int[n][n];
		
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				map[i][j] = sc.nextInt();
			}
		}
		flag = true;
		int dayCount = 0;
		while (true) {
			openLine();
			if (!flag) {
				break;
			}
			dayCount++;
		}
		System.out.println(dayCount);
	}
	private static void openLine() {
		flag = false;
		allaiance = new ArrayList<>();
		visited = new boolean[n][n];
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map.length; j++) {
				if (!visited[i][j]) {
					bfs(i,j);
				}
			}
		}
		for (ArrayList<int[]> list : allaiance) {
			flatten(list);
		}
	}
	private static void flatten(ArrayList<int[]> list) {
		int sum = 0;
		int size = list.size();
		for (int[] node : list) {
			int x = node[0];
			int y = node[1];
			sum += map[x][y];
		}
		int avg = sum/size;
		for (int[] node : list) {
			int x = node[0];
			int y = node[1];
			map[x][y] = avg;
		}
		
	}
	private static void bfs(int i, int j) {
		Deque<int[]> queue = new ArrayDeque<>();
		ArrayList<int[]> arr = new ArrayList<>();
		queue.offer(new int[] {i,j});
		arr.add(new int[] {i,j});
		visited[i][j] = true;
		while (!queue.isEmpty()) {
			int[] cur = queue.poll();
			for (int d = 0; d < 4; d++) {
				int nx = cur[0] + dx[d];
				int ny = cur[1] + dy[d];
				if (outOfMap(nx,ny) || visited[nx][ny]) continue;
				int diff = Math.abs(map[cur[0]][cur[1]] - map[nx][ny]);
				if(diff > r || diff < l) continue;
				visited[nx][ny] = true;
				flag = true;
				queue.offer(new int[] {nx,ny});
				arr.add(new int[] {nx,ny});
			}
		}
		if (arr.size()>1) {
			allaiance.add(arr);
		}
	}
	private static boolean outOfMap(int nx, int ny) {
		return nx >= n || nx<0 || ny >= n || ny<0;
	}
}