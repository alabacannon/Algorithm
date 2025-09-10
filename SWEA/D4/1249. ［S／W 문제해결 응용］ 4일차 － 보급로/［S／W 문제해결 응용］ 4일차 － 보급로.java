import java.io.FileInputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Solution {
	static class Node implements Comparable<Node>{
		int x;
		int y;
		int cost;
		
		public Node(int x, int y, int cost) {
			this.x = x;
			this.y = y;
			this.cost = cost;
		}

		@Override
		public int compareTo(Node o) {
			return this.cost - o.cost;
		}
	}
	static int n;
	static int[][] map, dist;
	static int[] dx = {-1,1,0,0};
	static int[] dy = {0,0,-1,1};
	static PriorityQueue<Node> heap;
	public static void main(String[] args) throws IOException {
		//System.setIn(new FileInputStream("data/input.txt"));
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		for (int test_case = 1; test_case <= t; test_case++) {
			n = sc.nextInt();
			map = new int[n][n];
			dist = new int[n][n];
			heap = new PriorityQueue<>();
			for (int i = 0; i < n; i++) {
				Arrays.fill(dist[i], Integer.MAX_VALUE>>1);
			}
			sc.nextLine();
			for (int i = 0; i < n; i++) {
				map[i] = sc.nextLine().chars().map(c-> c -'0').toArray();
			}
			dist[0][0] = 0;
			heap.offer(new Node(0,0,0));
			while (!heap.isEmpty()) {
				Node cur = heap.poll();
				int x  = cur.x;
				int y = cur.y;
				if (dist[x][y] < cur.cost) continue; 
				for (int d = 0; d < 4; d++) {
					int nx = x +dx[d];
					int ny = y  +dy[d];
					if (nx >= n || nx < 0 || ny >= n || ny < 0) continue; 
					if (dist[nx][ny] > cur.cost + map[nx][ny]) {
						dist[nx][ny] = cur.cost + map[nx][ny];
						heap.offer(new Node(nx,ny,dist[nx][ny]));
					}
					
				}
			}
			System.out.println("#" + test_case + " " + dist[n-1][n-1]);
			
		}
	}
}