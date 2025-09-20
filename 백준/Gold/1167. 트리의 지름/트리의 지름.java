import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static ArrayList<ArrayList<int[]>> tree;
	static int v;
	static int[] dist;
	public static void main(String[] args) throws IOException {
		//BufferedReader br = new BufferedReader(new FileReader("data/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		v = Integer.parseInt(br.readLine());
		tree = new ArrayList<>();
		dist = new int[v+1];
		Arrays.fill(dist, Integer.MAX_VALUE);
		for (int i = 0; i <= v; i++) {
			tree.add(new ArrayList<>());
		}
		for (int i = 0; i < v; i++) {
			st = new StringTokenizer(br.readLine());
			int p = Integer.parseInt(st.nextToken());
			int node = 0;
			int weight = 0;
			while ((node = Integer.parseInt(st.nextToken()))!=-1) {
				weight = Integer.parseInt(st.nextToken());
				tree.get(p).add(new int[] {node,weight});
				tree.get(node).add(new int[] {p,weight});
			}
			
			
		}
		dist[1] = 0;
		dfs(1);
		int curNode = 0;
		int tempDist = 0;
		for (int i = 1; i <= v; i++) {
			if (dist[i] > tempDist) {
				curNode = i;
				tempDist = dist[i]; 
			}
		}
		Arrays.fill(dist, Integer.MAX_VALUE);
		dist[curNode] = 0;
		dfs(curNode);
		dist[0] = 0;
		System.out.println(Arrays.stream(dist).max().orElse(-1));
		br.close();
	}
	private static void dfs(int cur) {
		for (int[] edge : tree.get(cur)) {
			int next = edge[0];
			int weight = edge[1];
			if (dist[next] != Integer.MAX_VALUE) continue;
			dist[next] = dist[cur] + weight;
			dfs(next);
		}
	}
}