import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.StringTokenizer;


public class Main {
	public static void main(String[] args) throws IOException {
//		BufferedReader br = new BufferedReader(new FileReader("data/input.txt"));
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
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			inDegree[b]++;
			graph.get(a).add(b);
		}
		Deque<Integer> queue = new ArrayDeque<>();
		for (int i = 1; i <= n; i++) {
			if (inDegree[i] == 0) {
				queue.offer(i);
			}
		}
		
		while (!queue.isEmpty()) {
			int cur = queue.poll();
			System.out.print(cur + " ");
			for (int next : graph.get(cur)) {
				if (--inDegree[next] == 0 ) {
					queue.offer(next);
				}
			}
		}

		br.close();
	}
}
			
