import java.io.FileInputStream;
import java.io.IOException;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {
	static class Node implements Comparable<Node>{
		int v1;
		int v2;
		double dist;
		public Node(int v1, int v2, double dist) {
			this.v1 = v1;
			this.v2 = v2;
			this.dist = dist;
		}

		@Override
		public int compareTo(Node o) {
			return Double.compare(this.dist, o.dist);
		}
	}
	static double[][] stars;
	static int n;
	static PriorityQueue<Node> heap;
	static int[] parent, rank;
	public static void main(String[] args) throws IOException {
		//System.setIn(new FileInputStream("data/input.txt"));
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		stars = new double[n][2];
		for (int i = 0; i < n; i++) {
			stars[i][0] = sc.nextDouble();
			stars[i][1] = sc.nextDouble();
		}
		parent = new int[n];
		rank = new int[n];
		for (int i = 0; i < n; i++) {
			parent[i] = i;
			rank[i] = 1;
		}
		heap = new PriorityQueue<>();
		for (int i = 0; i < n; i++) {
			for (int j = i+1; j < n; j++) {
				heap.add(new Node(i,j,getDistance(i,j)));
			}
		}
		double ans = 0;
		while (!heap.isEmpty()) {
			Node cur = heap.poll();
			if (find(cur.v1) != find(cur.v2)) {
				union(cur.v1,cur.v2);
				ans += cur.dist;
			}
		}
		System.out.println(String.format("%.2f", ans));
	}
	private static int find(int v) {
		if (v == parent[v]) return v; 
			
		return parent[v] = find(parent[v]);
	}
	private static void union(int v1, int v2) {
		int p1 = find(v1);
		int p2 = find(v2);
		if (rank[p1] < rank[p2]) {
			parent[p1] = p2;
			rank[p2] += rank[p1];
		}else {
			parent[p2] = p1;
			rank[p1] += rank[p2];
		}
		
	}
	private static double getDistance(int i, int j) {
		double x1 = stars[i][0] , y1 = stars[i][1] , x2 = stars[j][0] , y2 = stars[j][1];
		return Math.hypot(x1-x2, y1-y2);
	}
}
