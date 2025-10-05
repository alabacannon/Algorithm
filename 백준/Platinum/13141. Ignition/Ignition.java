import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.Iterator;
import java.util.Scanner;



public class Main {
	
	static class Edge {
		int v1;
		int v2;
		int l;
		public Edge() {}
		
		public Edge(int v1, int v2, int l) {
			this.v1 = v1;
			this.v2 = v2;
			this.l = l;
		}
		
	}
	static int n,m;
	static int[][] dist;
	static ArrayList<Edge> edges;
	static final int INF = Integer.MAX_VALUE>>2;
	public static void main(String[] args) throws IOException {
		//System.setIn(new FileInputStream("data/input.txt"));
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		dist = new int[n][n];
		edges = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			Arrays.fill(dist[i], INF);
			dist[i][i] = 0;
		}
		for (int i = 0; i < m; i++) {
			int s = sc.nextInt()-1;
			int e = sc.nextInt()-1;
			int l = sc.nextInt();
			dist[s][e] = Math.min(l, dist[s][e]);
			dist[e][s] = Math.min(l, dist[e][s]);
			edges.add(new Edge(s,e,l));
		}
		for (int k = 0; k < n; k++) {
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					dist[i][j] = Math.min(dist[i][j], dist[i][k] + dist[k][j]);
				}
			}
		}
//		for (int i = 0; i < n; i++) {
//			System.out.println(Arrays.toString(dist[i]));
//		}
		
		// 시작 노드 = k
		double mintime = INF;
		for (int k = 0; k < n; k++) {
			double localMax = 0;
			for (Edge edge : edges) {
				int timeV1 = dist[k][edge.v1];
				int timeV2 = dist[k][edge.v2];
				int min = Math.min(timeV2, timeV1);
				int max = Math.max(timeV2, timeV1);
				double temp = max + (edge.l - (max-min))/2.0; 
				localMax = Math.max(temp, localMax);
			}
			mintime = Math.min(mintime, localMax);
		}
		System.out.println(mintime);
		
	}
}