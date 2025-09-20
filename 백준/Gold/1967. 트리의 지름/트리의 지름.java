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
	static int currentLength;
	static int[] dist;
	public static void main(String[] args) throws IOException {
//		BufferedReader br = new BufferedReader(new FileReader("data/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		String line;
		int n = Integer.parseInt(br.readLine());
		if (n == 1) {
			System.out.println(0);
			return;
		}
		tree = new ArrayList<>();
		dist = new int[n+1];
		Arrays.fill(dist, Integer.MAX_VALUE);
		for (int i = 0; i <= n; i++) {
			tree.add(new ArrayList<>());
		}
		while((line = br.readLine())!= null) {
			st = new StringTokenizer(line);
			int p = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			tree.get(p).add(new int[] {v,w});
			tree.get(v).add(new int[] {p,w});
		}
		currentLength = 0;
		dist[1] = 0;
		dfs(1);
		int curNode = 0;
		int tempDist = 0;
		for (int i = 1; i <= n; i++) {
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
			if (dist[next] < dist[cur] + weight) continue;
			dist[next] = dist[cur] + weight;
			dfs(next);
		}
	}
}