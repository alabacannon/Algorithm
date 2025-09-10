import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;


public class Main {
	static class Node implements Comparable<Node>{
		int to;
		int weight;
		public Node(int to, int weight) {
			this.to = to;
			this.weight = weight;
		}
		@Override
		public int compareTo(Main.Node o) {
			return this.weight - o.weight;
		}
		
	}
	static int n,m,k, ans;
	static int[] generator;
	static ArrayList<ArrayList<Node>> graph;
	static PriorityQueue<Node> heap;
	static boolean[] visited;
	public static void main(String[] args) throws IOException {
//		BufferedReader br = new BufferedReader(new FileReader("data/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		generator = new int [k];
		visited = new boolean[n+1];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < k; i++) {
			generator[i] = Integer.parseInt(st.nextToken());
		}
		graph = new ArrayList<>();
		for (int i = 0; i <= n; i++) {
			graph.add(new ArrayList<>());
		}
		for (int i = 1; i <= m; i++) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			graph.get(u).add(new Node(v,w));
			graph.get(v).add(new Node(u,w));
		}
		heap = new PriorityQueue<>();
		for (int i = 0; i < k; i++) {
			heap.offer(new Node(generator[i],0));
		}
		ans = 0;
		while (!heap.isEmpty()) {
			Node node = heap.poll();
			int cur = node.to;
			int cost = node.weight;
			if (visited[cur]) continue; 
			visited[cur] = true;
			ans += cost;
			for (Node next : graph.get(cur)) {
				if (!visited[next.to]) {
					heap.offer(next);
				}
			}
		}
		System.out.println(ans);
		br.close();
	}
};