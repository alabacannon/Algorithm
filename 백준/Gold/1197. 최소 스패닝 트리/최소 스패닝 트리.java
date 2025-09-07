import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	static int v;
	static int e;
	static int[] parent;
	static int[] size; // 변경 사항: size 배열 추가
	static PriorityQueue<Edge> heap;
	public static void main(String[] args) throws IOException {
//		BufferedReader br = new BufferedReader(new FileReader("data/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st =  new StringTokenizer(br.readLine());
		v = Integer.parseInt(st.nextToken()); // 정점 수
		e = Integer.parseInt(st.nextToken()); // 간선 수 
		parent = new int[v+1];
		size = new int[v+1]; // 변경 사항: size 배열 초기화
		heap = new PriorityQueue<>();
		
		for (int i = 0; i < e; i++) {
			st = new StringTokenizer(br.readLine());
			int v1 = Integer.parseInt(st.nextToken());
			int v2 = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());
			heap.offer(new Edge(v1,v2,weight));
		}
		
		for (int i = 1; i <= v; i++) {
			parent[i] = i;
			size[i] = 1; // 변경 사항: 각 집합의 크기를 1로 초기화
		}
		int ans = 0;
		while (!heap.isEmpty()) {
			Edge edge = heap.poll();
			if (find(edge.v1) != find(edge.v2)) {
				union(edge.v1, edge.v2);
				ans += edge.weight;
			}
		}
		System.out.println(ans);
		br.close();
	}
	
	private static void union(int v1, int v2) {
		int p1 = find(v1);
		int p2 = find(v2);
		
		if (p1 != p2) {
			if (size[p1] < size[p2]) {
				parent[p1] = p2;
				size[p2] += size[p1];
			} else {
				parent[p2] = p1;
				size[p1] += size[p2];
			}
		}
	}

	private static int find(int v) {
		if (parent[v] == v) return v;
		return parent[v] = find(parent[v]);
	}

	static class Edge implements Comparable<Edge>{
		int v1;
		int v2;
		int weight;
		
		public Edge(int v1, int v2, int weight) {
			this.v1 = v1;
			this.v2 = v2;
			this.weight = weight;
		}

		@Override
		public int compareTo(Main.Edge o) {
			return this.weight - o.weight;
		}
	}
}