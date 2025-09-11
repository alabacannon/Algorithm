import java.io.IOException;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.Scanner;


public class Main {
	static int n,k,ans;
	static int[] dist, parent;
	public static void main(String[] args) throws IOException {
		//System.setIn(new FileInputStream("data/input.txt"));
		Scanner sc = new Scanner(System.in);
		StringBuilder sb =  new StringBuilder();
		n = sc.nextInt();
		k = sc.nextInt();

		dist = new int[200001];
		parent = new int[200001];
		Arrays.fill(dist, Integer.MAX_VALUE);
		ans = 0;
		bfs();
		sb.append(ans).append("\n");
		Deque<Integer> stack = new ArrayDeque<>();
		for (int i = 0; i <= ans; i++) {
			stack.push(k);
			k = parent[k];
		}
		while(!stack.isEmpty()) {
			sb.append(stack.pop()).append(" ");
		}
		System.out.println(sb.toString());
	}
	private static void bfs() {
		Deque<Integer> queue = new ArrayDeque<>();
		queue.offer(n);
		dist[n] = 0;
		while (!queue.isEmpty()) {
			int cur = queue.poll();
			if (cur == k) {
	            ans = dist[cur];
	            return;
	        }
			int[] nextMoves = {cur - 1, cur + 1, cur * 2};
	        for (int next : nextMoves) {
	            if (next >= 0 && next < 200001 && dist[next] == Integer.MAX_VALUE) {
	                dist[next] = dist[cur] + 1;
	                parent[next] = cur;
	                queue.offer(next);
	            }
	        }
		}
		
		
	}
}
			
