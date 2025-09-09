import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	static int n,m;
	static int[] parent, rank;
	static StringBuilder sb;
	public static void main(String[] args) throws IOException {
//		BufferedReader br = new BufferedReader(new FileReader("data/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();
		StringTokenizer st;
		int t = Integer.parseInt(br.readLine());
		for (int test_case = 1; test_case <= t; test_case++) {
			sb.append("#").append(test_case).append(" ");
			st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			m = Integer.parseInt(st.nextToken());
			parent = new int[n+1];
			rank = new int[n+1];
			for (int i = 1; i <= n; i++) {
				parent[i] = i;
				rank[i] = 1;
			}
			for (int k = 0; k < m; k++) {
				st = new StringTokenizer(br.readLine());
				int flag = Integer.parseInt(st.nextToken());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				if (flag == 0) {
					if (find(a) != find(b)) {
						union(a,b);
					}
				} else {
					isSame(a,b);
				}
			}
			sb.append("\n");
		}
		System.out.println(sb.toString());
		br.close();
	}
	private static void isSame(int a, int b) {
		int p1 = find(a);
		int p2 = find(b);
		if (p1 == p2) {
			sb.append(1);
		}else {
			sb.append(0);
		}
	}
	private static void union(int a, int b) {
		int p1 = find(a);
		int p2 = find(b);
		if (rank[p1] > rank[p2]) {
			parent[p2] = p1;
			rank[p1] +=  rank[p2];
		} else {
			parent[p1] = p2;
			rank[p2] +=  rank[p1];
		}
	}
	private static int find(int a) {
		if (a == parent[a]) return a; 			
		return parent[a] = find(parent[a]);
	}
}