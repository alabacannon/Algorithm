import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.PriorityQueue;
import java.util.Scanner;


public class Main {
	
	static class Edge implements Comparable<Edge>{
		int to;
		int weight;
		public Edge(int to, int weight) {
			this.to = to;
			this.weight = weight;
		}
		@Override
		public int compareTo(Edge o) {
			return this.weight - o.weight;
		}
	}
	static int n,m, num;
	static final int INF = Integer.MAX_VALUE>>1;
	static int[] dx = {-1,1,0,0};
	static int[] dy = {0,0,-1,1};
	static int[][] map, adj;
	static boolean[][] visitedBfs;
	static ArrayList<ArrayList<int[]>> island;
	public static void main(String[] args) throws IOException {
		//System.setIn(new FileInputStream("data/input.txt"));
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		sc.nextLine();
		map = new int[n][m];
		visitedBfs = new boolean[n][m];
		island = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			map[i] = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		}
		// BFS로 섬 개수, 위치 확인 -> 문제 없음
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (!visitedBfs[i][j] && map[i][j] == 1) bfs(i,j);
			}
		}
		// 각 섬들간 최소 거리 인접행렬로 처리
		num = island.size();
		adj = new int[num][num];
		for (int i = 0; i < num; i++) {
			for (int j = i+1; j < num; j++) {
				int tmp = findMinDist(i,j);
				adj[i][j] = tmp;
				adj[j][i] = tmp;
			}
		}
		// 최소 스패닝 트리 찾기
		int ans = prim();
		System.out.println(ans);
//		for (int i = 0; i < num; i++) {
//			System.out.println(Arrays.toString(adj[i]));
//		}
		
	}
	
	private static int prim() {
		int result = 0;
		boolean[] visitedPrim = new boolean[num];
		PriorityQueue<Edge> pq = new PriorityQueue<>();
		
		pq.offer(new Edge(0,0));
		while (!pq.isEmpty()) {
			Edge edge = pq.poll();
			int cur = edge.to;
			if (visitedPrim[cur]) continue; 
			visitedPrim[cur] = true;
			result += edge.weight;
			for (int i = 0; i < num; i++) {
				if (adj[cur][i] != INF && !visitedPrim[i]) {
					pq.offer(new Edge(i, adj[cur][i]));
				}
			}
		}
		for (int i = 0; i < num; i++) {
			if(!visitedPrim[i]) result = -1; 
		}
		
		return result;
	}

	private static int findMinDist(int a, int b) {
		int result = INF;
		for (int[] nodeA : island.get(a)) {
			for (int[] nodeB : island.get(b)) {
				if (nodeA[0] == nodeB[0]) {
					int dist = 0;
					for (int i = Math.min(nodeA[1], nodeB[1])+1; i < Math.max(nodeA[1], nodeB[1]); i++) {
						if (map[nodeA[0]][i] == 1) {
							dist = Integer.MAX_VALUE;
							break;
						} else {
							dist++;
						}
					}
					if (dist > 1) {
						result = Math.min(result, dist);
					}
				}
				if (nodeA[1] == nodeB[1]) {
					int dist = 0;
					for (int i = Math.min(nodeA[0], nodeB[0])+1; i < Math.max(nodeA[0], nodeB[0]); i++) {
						if (map[i][nodeA[1]] == 1) {
							dist = Integer.MAX_VALUE;
							break;
						} else {
							dist++;
						}
					}
					if (dist > 1) {
						result = Math.min(result, dist);
					}
				}
			}
		}
		
		return result;
	}
	private static void bfs(int x, int y) {
		Deque<int[]> queue = new ArrayDeque<>();
		ArrayList<int[]> is = new ArrayList<>();
		visitedBfs[x][y] = true;
		is.add(new int[] {x,y});
		queue.offer(new int[] {x,y});
		while (!queue.isEmpty()) {
			int[] cur = queue.poll();
			int curX = cur[0];
			int curY = cur[1];
			for (int d = 0; d < 4; d++) {
				int nx = curX + dx[d];
				int ny = curY + dy[d];
				if (outOfMap(nx,ny)) continue;
				if (visitedBfs[nx][ny] || map[nx][ny] == 0) continue; 
				visitedBfs[nx][ny] = true;
				is.add(new int[] {nx,ny});
				queue.offer(new int[] {nx,ny});
			}
		}
		island.add(is);
		
	}
	private static boolean outOfMap(int nx, int ny) {
		return nx >= n || nx <0 || ny >= m || ny <0;
	}
		
	
}
			
