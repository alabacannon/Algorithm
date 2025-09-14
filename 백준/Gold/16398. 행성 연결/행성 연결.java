import java.io.FileInputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {
	static int n;
	static int[][] adj;
	static class Edge implements Comparable<Edge>{
		int to;
		int weight;
		
		public Edge(int to, int weight) {
			this.to = to;
			this.weight = weight;
		}
		@Override
		public int compareTo(Edge o) {
			return weight - o.weight;
		}
		
	}

	public static void main(String[] args) throws IOException {
		//System.setIn(new FileInputStream("data/input.txt"));
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		adj = new int[n][n];
		sc.nextLine();
		for (int i = 0; i < n; i++) {
			adj[i] = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		}
		prim();
	}

	private static void prim() {
		PriorityQueue<Edge> pq = new PriorityQueue<>();
		boolean[] visited = new boolean[n];
		long ans = 0;
		pq.offer(new Edge(0,0));
		while (!pq.isEmpty()) {
			Edge cur = pq.poll();
			int to = cur.to;
			if (visited[to]) continue;
			visited[to] = true;
			ans += cur.weight;
			for (int j = 0; j < n; j++) {
				if (!visited[j]) {
					pq.offer(new Edge(j,adj[to][j]));
				}
			}
		}
		System.out.println(ans);
	}
}
