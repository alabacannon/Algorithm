import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {
	static int n,k,w;
	static int[] constructTime, accumTime, inDegree;
	static ArrayList<ArrayList<Integer>> graph;
	public static void main(String[] args) throws IOException {
//		BufferedReader br = new BufferedReader(new FileReader("data/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int t = Integer.parseInt(br.readLine());
		out : for (int test_case = 0; test_case < t; test_case++) {
			st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			k = Integer.parseInt(st.nextToken());
			constructTime = new int[n+1];
			inDegree = new int[n+1];
			graph = new ArrayList<>();
			st = new StringTokenizer(br.readLine());
			for (int i = 1; i <= n; i++) {
				constructTime[i] = Integer.parseInt(st.nextToken());
				graph.add(new ArrayList<>());
			}
			accumTime = Arrays.copyOf(constructTime, n+1);

			graph.add(new ArrayList<>());
			for (int i = 0; i < k; i++) {
				st = new StringTokenizer(br.readLine());
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				graph.get(x).add(y);
				inDegree[y]++;
			}
			w = Integer.parseInt(br.readLine());
			Deque<Integer> queue = new ArrayDeque<>();
			for (int i = 1; i <= n; i++) {
				if (inDegree[i] == 0) {
					queue.offer(i);
				}
			}
			while (!queue.isEmpty()) {
				int cur = queue.poll();
				for (int next : graph.get(cur)) {
					accumTime[next] = Math.max(accumTime[cur] + constructTime[next],
							accumTime[next]);
					if (--inDegree[next] == 0) {
						queue.offer(next);
						if (next == w) {
							System.out.println(accumTime[w]);
							continue out;
						}
					}
				}
			}
			System.out.println(accumTime[w]);
		}
		
		
		br.close();
	}
}