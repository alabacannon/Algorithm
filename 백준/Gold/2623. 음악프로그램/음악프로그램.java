import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.StringTokenizer;


public class Main {
	public static void main(String[] args) throws IOException {
		//BufferedReader br = new BufferedReader(new FileReader("data/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int[] inDegree = new int[n+1];
		ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
		for (int i = 0; i <= n; i++) {
			graph.add(new ArrayList<>());
		}
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int k = Integer.parseInt(st.nextToken());
			int after = Integer.parseInt(st.nextToken());
			for (int j = 1; j < k; j++) {
				int before = after;
				after = Integer.parseInt(st.nextToken());
				inDegree[after]++;
				graph.get(before).add(after);
			}
		}
		Deque<Integer> queue = new ArrayDeque<>();
		for (int i = 1; i <= n; i++) {
			if (inDegree[i] == 0) {
				queue.offer(i);
			}
		}
		if (queue.isEmpty()) {
			System.out.println(0);
			return;
		}
		int count = 0;
		while (!queue.isEmpty()) {
			int cur = queue.poll();
			count++;
			sb.append(cur).append("\n");
			for (int next : graph.get(cur)) {
				if (--inDegree[next] == 0 ) {
					queue.offer(next);
				}
			}
		}
		if (count == n) {
			System.out.println(sb);
		} else {
			System.out.println(0);
		}
		

		br.close();
	}
}
			
