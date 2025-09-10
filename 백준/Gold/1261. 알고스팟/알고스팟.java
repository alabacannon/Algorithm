import java.io.FileInputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;


public class Main {
	static class Node implements Comparable<Node>{
		int x;
		int y;
		int count;
		public Node(int x, int y, int count) {
			this.x = x;
			this.y = y;
			this.count = count;
		}
		@Override
		public int compareTo(Node o) {
			return this.count -o.count;
		}
		
		
	}
	static int n,m;
	static int[] dx = {-1,1,0,0};
	static int[] dy = {0,0,1,-1};
	static int[][] map, breakCount;
	static PriorityQueue<Node> heap;  
	public static void main(String[] args) throws IOException {
		//System.setIn(new FileInputStream("data/input.txt"));
		Scanner sc = new Scanner(System.in);
		m = sc.nextInt();
		n = sc.nextInt();
		map = new int[n][m];
		breakCount = new int[n][m];
		sc.nextLine();
		for (int i = 0; i < n; i++) {
			map[i] = sc.nextLine().chars().map(c -> c - '0').toArray();
			Arrays.fill(breakCount[i], Integer.MAX_VALUE>>1);
		}
		heap = new PriorityQueue<>();
		breakCount[0][0] = 0;
		heap.offer(new Node(0,0,0));
		
		while (!heap.isEmpty()) {
			Node cur = heap.poll();
			int x = cur.x;
			int y = cur.y;
			if (cur.count > breakCount[x][y]) {
				continue;
			}
			for (int d = 0; d < 4; d++) {
				int nx = x + dx[d];
				int ny = y + dy[d];
				if (nx >= n || nx < 0 || ny >= m || ny < 0) continue; 
				if (breakCount[nx][ny] > cur.count + map[nx][ny]) {
					breakCount[nx][ny] = cur.count + map[nx][ny];
					heap.offer(new Node(nx,ny,breakCount[nx][ny]));
				}
			}
		}
		System.out.println(breakCount[n-1][m-1]);
		
		
	}
}