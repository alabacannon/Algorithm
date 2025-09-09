import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;
import java.util.StringTokenizer;

public class Solution {
	static class Node implements Comparable<Node>{
		int v1;
		int v2;
		double cost;
		public Node(int v1,int v2, double cost) {
			this.v1 = v1;
			this.v2 = v2;
			this.cost = cost;
		}
		@Override
		public int compareTo(Node o) {
			return Double.compare(this.cost, o.cost);
		}
		
	}
	static int n;
	static long ans;
	static int[] parent, rank;
	static StringBuilder sb;
	static PriorityQueue<Node> heap;
	public static void main(String[] args) throws IOException {
//		BufferedReader br = new BufferedReader(new FileReader("data/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();
		StringTokenizer st;
		int t = Integer.parseInt(br.readLine());
		for (int test_case = 1; test_case <= t; test_case++) {
			ans = 0;
			Set<Integer> set = new HashSet<>();
			sb.append("#").append(test_case).append(" ");
			n = Integer.parseInt(br.readLine());
			int[] xArr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
			int[] yArr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
			double e = Double.parseDouble(br.readLine());
			parent = new int[n+1];
			rank = new int[n+1];
			for (int i = 1; i <= n; i++) {
				parent[i] = i;
				rank[i] = 1;
			}
			heap = new PriorityQueue<>();
			for (int i = 1; i <= n; i++) {
				for (int j = i+1; j <= n; j++) {
					heap.add(new Node(i,j,getDistance(xArr[i-1],yArr[i-1],xArr[j-1],yArr[j-1]))) ;
				}
			}
			while (!heap.isEmpty()) {
				Node cur = heap.poll();
				if (find(cur.v1) != find(cur.v2)) {
					union(cur.v1,cur.v2);
					ans += cur.cost;
				}
			}
			
			sb.append(Math.round(ans * e)).append("\n");
		}
		System.out.println(sb.toString());
		br.close();
	}
	

	private static void union(int v1, int v2) {
		int p1 = find(v1);
		int p2 = find(v2);
		if (rank[p1] < rank[p2]) {
			parent[p1] = p2;
			rank[p2] += rank[p1];
		} else {
			parent[p2] = p1;
			rank[p1] += rank[p2];
		}
	}


	private static int find(int a) {
		if (a == parent[a]) return a; 			
		return parent[a] = find(parent[a]);
	}
	

	private static double getDistance(int a, int b, int c, int d) {
	    long dx = (long) (a - c);
	    long dy = (long) (b - d);
	    return (double) (dx * dx + dy * dy);
	}
}