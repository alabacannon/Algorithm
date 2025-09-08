import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.Scanner;

public class Main {
	static ArrayList<Integer>[] graph;
	static int n;
	public static void main(String[] args) throws IOException {
		//System.setIn(new FileInputStream("data/input.txt"));
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		int m = sc.nextInt();
		graph = new ArrayList[n+1];
		for (int i = 1; i <=n ; i++) {
			graph[i] = new ArrayList<>();
		}
		for (int i = 0; i < m; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			graph[a].add(b);
			graph[b].add(a);
		}
		System.out.println(bfs());
	}
	private static int bfs() {
		int ans = 0;
		boolean[] visited = new boolean[n+1];
		Deque<Integer> queue = new ArrayDeque<>();
		queue.offer(1);
		visited[1] = true;
		while (!queue.isEmpty()) {
			int node = queue.poll();
			for (int next : graph[node]) {
				if (visited[next]) continue;
				visited[next] = true;
				ans++;
				queue.offer(next);
			}
		}
		
		return ans;
	}
}
