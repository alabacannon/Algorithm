import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.Iterator;
import java.util.Scanner;

public class Main {
	
	static int[] dx = {-1,1,0,0};
	static int[] dy = {0,0,-1,1};
	static int ans;
	static int n;
	static int m;
	static int[][] graph;
	static int[][] copyedGraph;
	static ArrayList<int[]> virus = new ArrayList<>();
	static ArrayList<int[]> safeArea = new ArrayList<>();
	static Deque<int[]> queue;
	
	public static void main(String[] args) throws IOException {
//		System.setIn(new FileInputStream("data/input.txt"));
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		graph = new int[n][m];
		copyedGraph = new int[n][m];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				int temp = sc.nextInt();
				graph[i][j] = temp;
				if (temp == 2) {
					virus.add(new int[] {i,j});
				}
				if (temp == 0) {
					safeArea.add(new int[] {i,j});
				}
			}
		}
		findMaxSafeArea();
		System.out.println(ans);
	}
	private static void findMaxSafeArea() {
		for (int i = 0; i < n; i++) {
			copyedGraph[i] = Arrays.copyOf(graph[i], m);
			
		}
		for (int i = 0; i < safeArea.size(); i++) {
			for (int j = i+1; j < safeArea.size(); j++) {
				for (int k = j+1; k < safeArea.size(); k++) {
					int[] firstWall = safeArea.get(i), secondWall = safeArea.get(j), thirdWall = safeArea.get(k);
					copyedGraph[firstWall[0]][firstWall[1]] = 1;
					copyedGraph[secondWall[0]][secondWall[1]] = 1;
					copyedGraph[thirdWall[0]][thirdWall[1]] = 1;
					bfs();
					updateAns();
					for (int a = 0; a < n; a++) {
						copyedGraph[a] = Arrays.copyOf(graph[a], m);
						
					}
				}
			}
		}
	}
	private static void updateAns() {
		int count = 0;
		
		for (int k = 0; k < n; k++) {
			count += Arrays.stream(copyedGraph[k])
						.filter(item -> item == 0)
						.count();
		}
		ans = Math.max(ans, count);
	}
	private static void bfs() {
		queue = new ArrayDeque<>();
		queue.addAll(virus);
		while (!queue.isEmpty()) {
			int[] node = queue.pollFirst();
			int currentx = node[0], currenty = node[1]; 
			int nx = node[0], ny = node[1];
			for (int d = 0; d < 4; d++) {
				nx = currentx + dx[d]; ny = currenty + dy[d];
				if (isOutOfGraph(nx,ny) || copyedGraph[nx][ny] != 0) {
					continue;
				}
				copyedGraph[nx][ny] = 2;
				queue.offerLast(new int[] {nx,ny});
			}
		}
	}
	
	private static boolean isOutOfGraph(int nx, int ny) {
		return nx >=n || nx<0 || ny>=m || ny<0;
	}
}