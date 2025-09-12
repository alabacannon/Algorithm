import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.StringTokenizer;
 
public class Solution {

	public static void main(String[] args) throws IOException {
//		BufferedReader br = new BufferedReader(new FileReader("data/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		int t = 10;
		for (int test_case = 1; test_case <= t; test_case++) {
			sb.append("#").append(test_case).append(" ");
			st = new StringTokenizer(br.readLine());
			ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
			int v = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			int[] inDegree = new int[v+1];
			for (int i = 0; i <= v; i++) {
				graph.add(new ArrayList<>());
			}
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < e; i++) {
				int before = Integer.parseInt(st.nextToken());
				int after = Integer.parseInt(st.nextToken());
				graph.get(before).add(after);
				inDegree[after]++;
			}
			Deque<Integer> queue = new ArrayDeque<>();
			for (int i = 1; i <= v; i++) {
				if (inDegree[i] == 0) {
					queue.offer(i);
				}
			}
			while (!queue.isEmpty()) {
				int cur = queue.poll();
				sb.append(cur).append(" ");
				for (int next : graph.get(cur)) {
					if (--inDegree[next] == 0) {
						queue.offer(next);
					}
				}
			}
			sb.append("\n");
		}
		System.out.print(sb);
			

		br.close();
	}
}