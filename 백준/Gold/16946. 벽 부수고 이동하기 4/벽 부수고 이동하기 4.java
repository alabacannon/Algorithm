import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
	static int n,m, idx;
	static final int[] dx = {-1,1,0,0};
	static final int[] dy = {0,0,-1,1};
	static int[][] originalMap, islandMap;
	static ArrayList<Integer> islandCount;
	public static void main(String[] args) throws IOException {
//		BufferedReader br = new BufferedReader(new FileReader("data/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		originalMap = new int[n][m];
		islandMap = new int[n][m];
		islandCount = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			originalMap[i] = br.readLine().chars().map(c -> c-'0').toArray();
			islandMap[i] = Arrays.stream(Arrays.copyOf(originalMap[i], m)).map(n -> -n).toArray() ;
		}
		idx = 1;
		islandCount.add(0);
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (islandMap[i][j] == 0) {
					bfs(i,j);
					idx++;
				}
			}
		}
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (islandMap[i][j] == -1  ) {
					sb.append(breakWall(i,j)%10);
				} else {
					sb.append(0);
				}
			}
			sb.append("\n");
			
		}
		System.out.println(sb);
		br.close();
	}
	private static int breakWall(int x, int y) {
		Set<Integer> islandSet = new HashSet<>();
		int result = 1;
		for (int d = 0; d < 4; d++) {
			int nx = x + dx[d], ny = y + dy[d];
			if (outOfMap(nx, ny) || islandMap[nx][ny] == -1) continue; 
			islandSet.add(islandMap[nx][ny]);
		}
		for (int i : islandSet) {
			result += islandCount.get(i);
		}
		
		return result;
	}
	private static void bfs(int startX, int startY) {
		Deque<int[]> queue = new ArrayDeque<>();
		queue.offer(new int[] {startX,startY});
		islandMap[startX][startY] = idx;
		int count = 1;
		while (!queue.isEmpty()) {
			int[] cur = queue.poll();
			int x = cur[0], y = cur[1];
			for (int d = 0; d < 4; d++) {
				int nx = x + dx[d], ny = y + dy[d];
				if (outOfMap(nx,ny) || islandMap[nx][ny] !=0) continue; 
				queue.offer(new int[] {nx,ny});
				islandMap[nx][ny] = idx;
				count++;
			}
		}
		islandCount.add(count);
		
	}
	private static boolean outOfMap(int nx, int ny) {
		
		return nx >= n || nx < 0 || ny >= m || ny < 0;
	}
}
