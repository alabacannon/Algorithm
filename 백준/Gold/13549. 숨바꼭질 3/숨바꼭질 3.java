import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {
	static int ans;
	public static void main(String[] args) throws IOException {
		//System.setIn(new FileInputStream("data/input.txt"));
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int k = sc.nextInt();
		if (n >=k) {
			System.out.println(n-k);
		}else {
			bfs(n,k);
			System.out.println(ans);
		}
	}

	private static void bfs(int n, int k) {
		Deque<int[]> queue = new ArrayDeque<>();
		boolean[] visited = new boolean[200001];
		visited[n] = true;
		queue.offer(new int[] {n,0});
		while (!queue.isEmpty()) {
			int[] tmp = queue.poll();
			int node = tmp[0];
			int time = tmp[1];
			if (node <= 100000 && !visited[node*2]) {
				if(node*2 == k) {
					ans = time;
					return;
				}
				visited[node*2] = true;
				queue.offerFirst(new int[] {node * 2,time});
			}
			if (node > 0 && !visited[node-1]) {
				if(node-1 == k) {
					ans = time+1;
					return;
				}
				visited[node-1] = true;
				queue.offerLast(new int[] {node-1, time+1});
			}
			if (node < k && !visited[node+1]) {
				if(node+1 == k) {
					ans = time+1;
					return;
				}
				visited[node+1] = true;
				queue.offerLast(new int[] {node+1, time+1});

			}
		}
		
		
	}
}