import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;


public class Main {
	static class Edge {
		int from;
		int to;
		int weight;

		public Edge(int from, int to, int weight) {
			this.from = from;
			this.to = to;
			this.weight = weight;
		}
		
	}
	static ArrayList<Edge> graph;
	static long[] dist;
	static final int INF = Integer.MAX_VALUE;
	public static void main(String[] args) throws IOException {
//		BufferedReader br = new BufferedReader(new FileReader("data/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		dist = new long[n+1];
		Arrays.fill(dist, INF);
		dist[1] = 0;
		graph = new ArrayList<>();
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			graph.add(new Edge(a, b, c));
		}
		
		for (int i = 1; i <= n; i++) {
			for (Edge edge : graph) {
				if (dist[edge.from] != INF && dist[edge.to] > dist[edge.from] + edge.weight) {
					dist[edge.to] = dist[edge.from] + edge.weight;
				}
			}
		}
		for (Edge edge : graph) {
			if (dist[edge.from] != INF && dist[edge.to] > dist[edge.from] + edge.weight) {
				System.out.println(-1);
				return;
			}
		}
		
		for (int i = 2; i <= n; i++) {
			if (dist[i] == INF) {
				System.out.println(-1);
				continue;
			}
			System.out.println(dist[i]);
		}
		br.close();
	}
}
			
