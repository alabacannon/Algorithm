import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.Scanner;

public class Main {
	static char[][] map;
	static int n;
	static boolean[][] visited1; 
	static boolean[][] visited2; 
	static int[] dx = {-1,1, 0,0};
	static int[] dy = {0,0,-1,1};
	static Deque<int[]> queue1 = new ArrayDeque<>();
	static Deque<int[]> queue2 = new ArrayDeque<>();
	static Deque<int[]> queueBlue = new ArrayDeque<>();
	static int countNormalRG = 0;
	static int countConfuseRG = 0;
	static int countBlue = 0;
	
	public static void main(String[] args) throws IOException {
//		System.setIn(new FileInputStream("data/input.txt"));
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		sc.nextLine();
		map = new char[n][n];
		visited1 = new boolean[n][n]; 
		visited2 = new boolean[n][n];
		
		for (int i = 0; i < n; i++) {
			map[i] = sc.nextLine().toCharArray();
		}
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				bfs1(i,j);
				bfs2(i,j);
			}
		}
		System.out.print(countNormalRG + countBlue);
		System.out.print(" ");
		System.out.print(countConfuseRG + countBlue);
	}
	private static void bfs2(int i, int j) {
		char color = map[i][j];
		if (visited2[i][j]) {
			return;
		}
		
		if (color == 'B') {
			countBlue ++;
			queueBlue.offer(new int[] {i,j});
		} else {
			countConfuseRG++;
			queue2.offer(new int[] {i,j});
		}
		while (!queueBlue.isEmpty()) {
			int[] node = queueBlue.poll();
			for (int d = 0; d < 4; d++) {
				int nx = node[0] + dx[d];
				int ny = node[1] + dy[d];
				if (isOutOfMap(nx,ny)) {
					continue;
				}
				if (visited2[nx][ny] || color != map[nx][ny]) {
					continue;
				}
				
				queueBlue.offer(new int[] {nx,ny});
				visited2[nx][ny] = true;
			}
		}
		while (!queue2.isEmpty()) {
			int[] node = queue2.poll();
			for (int d = 0; d < 4; d++) {
				int nx = node[0] + dx[d];
				int ny = node[1] + dy[d];
				if (isOutOfMap(nx,ny)) {
					continue;
				}
				if (visited2[nx][ny] || map[nx][ny] == 'B') {
					continue;
				}
				queue2.offer(new int[] {nx,ny});
				visited2[nx][ny] = true;
			}
		}
	}
	
	private static void bfs1(int i, int j) {
		char color = map[i][j];
		if (visited1[i][j] || color == 'B') {
			return;
		}
		countNormalRG++;
		
		queue1.offer(new int[] {i,j});
		while (!queue1.isEmpty()) {
			int[] node = queue1.poll();
			for (int d = 0; d < 4; d++) {
				int nx = node[0] + dx[d];
				int ny = node[1] + dy[d];
				if (isOutOfMap(nx,ny)) {
					continue;
				}
				if (visited1[nx][ny] || color != map[nx][ny]) {
					continue;
				}
				queue1.offer(new int[] {nx,ny});
				visited1[nx][ny] = true;
			}
		}
	}
	private static boolean isOutOfMap(int nx, int ny) {
		return nx >= n || nx <0 || ny >= n || ny <0;
	}
	
	

}