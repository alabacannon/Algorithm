import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	static ArrayList<ArrayList<Integer>> graph;
	static int[] inDegree;
    public static void main(String[] args) throws IOException {
//		BufferedReader br = new BufferedReader(new FileReader("data/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		graph = new ArrayList<>();
		inDegree = new int[n+1];
		for (int i = 0; i <=n; i++) {
			graph.add(new ArrayList<>());
		}
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			graph.get(a).add(b);
			inDegree[b]++;
		}
		for (int i = 1; i <=n; i++) {
			Collections.sort(graph.get(i));
		}
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		for (int i = 1; i <= n; i++) {
			if (inDegree[i] == 0) {
				pq.offer(i);
			}
		}
		while (!pq.isEmpty()) {
			int cur = pq.poll();
			sb.append(cur).append(" ");
			for (int next : graph.get(cur)) {
				if (--inDegree[next] == 0) {
					pq.offer(next);
				}
			}
		}
		System.out.println(sb);
		
		br.close();
    }
}