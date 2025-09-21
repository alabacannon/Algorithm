import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;
import java.util.function.ToIntFunction;

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
	static PriorityQueue<Edge> pq;
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
		pq = new PriorityQueue<>();
		addEdgesByCoordinate(p -> p.x);
		addEdgesByCoordinate(p -> p.y);
		addEdgesByCoordinate(p -> p.z);
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
	private static void addEdgesByCoordinate(ToIntFunction<Planet> coordExtractor) {
	    // 1. 받은 함수를 기준으로 행성 리스트를 정렬
	    universe.sort(Comparator.comparingInt(coordExtractor));

	    // 2. 인접한 행성 간의 간선을 생성합니다.
	    for (int i = 1; i < universe.size(); i++) {
	        Planet p1 = universe.get(i);
	        Planet p2 = universe.get(i - 1);
	        
	        // 3. 받은 함수로 각 행성의 좌표 값을 직접 계산하여 가중치 계산
	        int weight = coordExtractor.applyAsInt(p1) - coordExtractor.applyAsInt(p2);
	        pq.add(new Edge(p1.no, p2.no, Math.abs(weight)));
	    }
	}
}


