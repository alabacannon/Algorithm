import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main  {
	static ArrayList<ArrayList<Node>> graph;
	static int[] dist;
	public static void main(String[] args) throws IOException {
//		BufferedReader br = new BufferedReader(new FileReader("data/input.txt"));
				BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		int v = Integer.parseInt(st.nextToken());
		int e = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(br.readLine());
		graph = new ArrayList<>();
		for (int i = 0; i <= v; i++) {
			graph.add(new ArrayList<>());
		}
		dist = new int[v+1];
		Arrays.fill(dist, Integer.MAX_VALUE);
		for (int i = 0; i < e; i++) {
			st = new StringTokenizer(br.readLine());
			graph.get(Integer.parseInt(st.nextToken()))
					.add(new Node(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken())));
		}
		PriorityQueue<Node> heap = new PriorityQueue<>((o1,o2) -> Integer.compare(o1.cost, o2.cost));
		heap.offer(new Node(k,0));
		dist[k] = 0;
		while (!heap.isEmpty()) {
			Node node = heap.poll();
			if (dist[node.idx] < node.cost) {
				continue;
			}
			for (Node nextNode : graph.get(node.idx)) {
				if (dist[nextNode.idx] > node.cost + nextNode.cost) {
					dist[nextNode.idx] = node.cost + nextNode.cost;
					heap.offer(new Node(nextNode.idx, dist[nextNode.idx]));				
				}
			}
		}
		for (int i = 1; i <= v; i++) {
			if (dist[i] == Integer.MAX_VALUE) {
				sb.append("INF" + "\n");
			} else {
				sb.append(dist[i] + "\n");
			}
		}
		System.out.println(sb.toString());
		
		br.close();
		bw.close();
	}
	

	
	static class Node{
		int idx;
		int cost;
		public Node(int idx, int cost) {
			this.idx = idx;
			this.cost = cost;
		}
		
	}
	
}