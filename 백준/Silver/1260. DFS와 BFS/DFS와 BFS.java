import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Deque;
import java.util.Scanner;

public class Main {
	static ArrayList<Integer>[] graph;
	static int n;
	static boolean[] visited;
	public static void main(String[] args) throws IOException {
		//System.setIn(new FileInputStream("data/input.txt"));
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		int m = sc.nextInt();
		int v = sc.nextInt();
		graph = new ArrayList[n+1];
		for (int i = 1; i <= n; i++) {
			graph[i] = new ArrayList<>();
		}
		for (int i = 0; i < m; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			graph[a].add(b);
			graph[b].add(a);
		}
		for (int i = 1; i <= n; i++) {
			Collections.sort(graph[i]);
		}

		visited = new boolean[n+1];
		visited[v] = true;
		System.out.print(v + " ");
		dfs(v);
		System.out.println();
		visited = new boolean[n+1];
		visited[v] = true;
		System.out.print(v + " ");
		
		bfs(v);
	}
	private static void dfs(int v) {
		for (int next : graph[v]) {
			if (visited[next]) continue;
			visited[next] = true;
			System.out.print(next + " ");
			dfs(next);
		}
	}
	private static void bfs(int v) {
		Deque<Integer> queue = new ArrayDeque<>();
		queue.offer(v);
		while (!queue.isEmpty()) {
			int cur = queue.poll();
			for (int next : graph[cur]) {
				if (visited[next]) continue;
				visited[next] = true;
				System.out.print(next + " ");
				queue.offer(next);
			}
		}
		
	}
}