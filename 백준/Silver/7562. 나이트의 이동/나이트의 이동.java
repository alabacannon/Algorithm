import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class Main {
	static int[] knight, destination;
	static int l;
	public static void main(String[] args) throws IOException {
//		BufferedReader br = new BufferedReader(new FileReader("data/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		for (int test_case = 1; test_case <=t ; test_case++) {
			l = Integer.parseInt(br.readLine());
			knight = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
			destination = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
			System.out.println(bfs());
			
		}
	
		br.close();
	}

	private static int bfs() {
		int[][] dist = new int[l][l];
		for (int i = 0; i < l; i++) {
			Arrays.fill(dist[i], Integer.MAX_VALUE);
		}
		int[] dx = {-1,-1,-2,-2,1,1,2,2};
		int[] dy = {-2,2,-1,1,2,-2,1,-1};
		Deque<int[]> queue = new ArrayDeque<>();
		dist[knight[0]][knight[1]] = 0;
		queue.offer(new int[] {knight[0], knight[1]});
		while (!queue.isEmpty()) {
			int[] node = queue.poll();
			if (node[0] == destination[0] && node[1] == destination[1]) {
				return dist[node[0]][node[1]];
			}
			for (int d = 0; d < 8; d++) {
				int nx = node[0] + dx[d];
				int ny = node[1] + dy[d];
				if(outOfMap(nx,ny)) continue;
				if(dist[nx][ny] != Integer.MAX_VALUE) continue;
				dist[nx][ny] = dist[node[0]][node[1]] + 1;
				queue.offer(new int[] {nx,ny});
			}
		}
		return -1;
	}

	private static boolean outOfMap(int nx, int ny) {
		return nx >= l || nx < 0 || ny >= l || ny < 0;
	}
}
