import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	static class Edge implements Comparable<Edge>{
		int to;
		long weight;
		public Edge(int to, long weight) {
			this.to = to;
			this.weight = weight;
		}
		@Override
		public int compareTo(Edge o) {
			return Long.compare(this.weight, o.weight);
		}
	}
	static int n,e;
	static final long INF = Long.MAX_VALUE>>4;
	static long ans;
	static ArrayList<ArrayList<Edge>> graph;
	public static void main(String[] args) throws IOException {
//		BufferedReader br = new BufferedReader(new FileReader("data/input.txt"));
		BufferedReader br	 = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		e = Integer.parseInt(st.nextToken());
		graph = new ArrayList<>();
		for (int i = 0; i <= n; i++) {
			graph.add(new ArrayList<>());
		}
		for (int i = 0; i < e; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken()), b = Integer.parseInt(st.nextToken()),c = Integer.parseInt(st.nextToken());
			graph.get(a).add(new Edge(b,c));
			graph.get(b).add(new Edge(a,c));
		}
		st = new StringTokenizer(br.readLine());
		int v1 = Integer.parseInt(st.nextToken()), v2 = Integer.parseInt(st.nextToken());
		ans = djikstra(v1,v2);
		ans += Math.min(djikstra(1,v1) + djikstra(v2,n), djikstra(1,v2) + djikstra(v1,n));
		if (ans >= INF) {
			System.out.println(-1);
		} else {
			System.out.println(ans);
		}
		br.close();
	}
	private static long djikstra(int start, int end) {
		if (start == end) {
			return 0;
		}
		long[] distance = new long[n+1];
		Arrays.fill(distance, INF);
		PriorityQueue<Edge> pq = new PriorityQueue<>();
		pq.offer(new Edge(start,0));
		while (!pq.isEmpty()) {
			Edge cur = pq.poll();
			int to = cur.to;
			for (Edge next : graph.get(to)) {
				if (distance[next.to] > cur.weight + next.weight) {
					distance[next.to] = cur.weight + next.weight;
					pq.offer(new Edge(next.to, distance[next.to]));
				}
			}
		}
//		System.out.println("start : " + start + " end : " + end + " result : " + distance[end]);
		return distance[end];
	}
}
