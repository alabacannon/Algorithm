import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	static PriorityQueue<Edge> heap;
	static int[] parent, rank;
	public static void main(String[] args) throws IOException {
//		BufferedReader br = new BufferedReader(new FileReader("data/input.txt"));
				BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int n = Integer.parseInt(br.readLine());
		int m = Integer.parseInt(br.readLine());
		heap = new PriorityQueue<>();
		parent = new int[n+1];
		rank = new int[n+1];
		
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int v1 = Integer.parseInt(st.nextToken());
			int v2 = Integer.parseInt(st.nextToken());
			int cost = Integer.parseInt(st.nextToken());
			heap.offer(new Edge(v1,v2,cost));
		}
		for (int i = 0; i <= n; i++) {
			parent[i] = i;
			rank[i] = 1;
		}
		int ans = 0;
		while (!heap.isEmpty()) {
			Edge edge = heap.poll();
			if (find(edge.v1) != find(edge.v2)) {
				union(edge.v1,edge.v2);
				ans += edge.cost; 
			}
		}
		System.out.println(ans);
		
		
		br.close();
	}
	
	
	
	private static void union(int v1, int v2) {
		int p1 = find(v1);
		int p2 = find(v2);
		if (rank[p1] > rank[p2]) {
			parent[p2] = p1;
			rank[p2] += rank[p1];
		} else {
			parent[p1] = p2;
			rank[p1] += rank[p2];
		}
	}



	private static int find(int v) {
		if (v == parent[v]) return v; 
		return parent[v] = find(parent[v]);
	}


	static class Edge implements Comparable<Edge>{
		int v1;
		int v2;
		int cost;
		public Edge(int v1, int v2, int cost) {
			this.v1 = v1;
			this.v2 = v2;
			this.cost = cost;
		}
		@Override
		public int compareTo(Main.Edge o) {
			return this.cost - o.cost;
		}
	}
}
