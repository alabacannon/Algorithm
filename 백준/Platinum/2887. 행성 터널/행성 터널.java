import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	static class Edge implements Comparable<Edge> {
		int v1;
		int v2;
		int weight;
		
		public Edge(int v1, int v2, int weight) {
			this.v1 = v1;
			this.v2 = v2;
			this.weight = weight;
		}

		@Override
		public int compareTo(Edge o) {
			return weight - o.weight;
		}
	}
	static class Planet {
		int no;
		int x;
		int y;
		int z;
		public Planet(int no, int x, int y, int z) {
			this.no = no;
			this.x = x;
			this.y = y;
			this.z = z;
		}
	}
	static ArrayList<Planet> universe;
	static int[] parent, size;
	static int n;
	public static void main(String[] args) throws IOException {
//		BufferedReader br = new BufferedReader(new FileReader("data/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		n = Integer.parseInt(br.readLine());
		universe = new ArrayList<>();
		parent = new int[n];
		size = new int[n];
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			universe.add(new Planet(i,Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken())));
		}
		PriorityQueue<Edge> pq = new PriorityQueue<>();
		Collections.sort(universe,(o1,o2)->o1.x - o2.x);
		for (int i = 1; i < n; i++) {
			Planet p1 = universe.get(i);
			Planet p2 = universe.get(i-1);
			pq.add(new Edge(p1.no,p2.no,p1.x-p2.x));
		}
		Collections.sort(universe,(o1,o2)->o1.y - o2.y);
		for (int i = 1; i < n; i++) {
			Planet p1 = universe.get(i);
			Planet p2 = universe.get(i-1);
			pq.add(new Edge(p1.no,p2.no,p1.y-p2.y));
		}
		Collections.sort(universe,(o1,o2)->o1.z - o2.z);
		for (int i = 1; i < n; i++) {
			Planet p1 = universe.get(i);
			Planet p2 = universe.get(i-1);
			pq.add(new Edge(p1.no,p2.no,p1.z-p2.z));
		}
		for (int i = 0; i < n; i++) {
			parent[i] = i;
			size[i] = 1;
		}
		long ans = 0;
		while (!pq.isEmpty()) {
			Edge edge = pq.poll();
			int v1 = edge.v1;
			int v2 = edge.v2;
			if (find(v1) != find(v2)) {
				union(v1,v2);
				ans += edge.weight;
			}
		}
		System.out.println(ans);
		br.close();
	}
	private static void union(int v1, int v2) {
		int p1 = find(v1);
		int p2 = find(v2);
		if (size[p1] > size[p2]) {
			parent[p2] = p1;
			size[p1] += size[p2];
		} else {
			parent[p1] = p2;
			size[p2] += size[p1];
		}
	}
	private static int find(int v) {
		if(parent[v] == v) return v;
		return parent[v] = find(parent[v]);
	}
}