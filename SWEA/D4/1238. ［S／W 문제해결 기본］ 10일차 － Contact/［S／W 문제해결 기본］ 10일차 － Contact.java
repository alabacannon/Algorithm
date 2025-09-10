import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.Scanner;

public class Solution {
	static ArrayList<ArrayList<Integer>> arr;
	static int[] visited;
	static int ans;
	public static void main(String[] args) throws IOException {
		//System.setIn(new FileInputStream("data/input.txt"));
		Scanner sc = new Scanner(System.in);
		int t = 10;
		for (int test_case = 1; test_case <= 10; test_case++) {
			int n = sc.nextInt();
			int start = sc.nextInt();
			arr = new ArrayList<>();
			ans = 0;
			visited = new int[101];
			for (int i = 0; i <= 100; i++) {
				arr.add(new ArrayList<>());
			}
			for (int i = 0; i < n/2; i++) {
				int a = sc.nextInt();
				int b = sc.nextInt();
				arr.get(a).add(b);
			}
			bfs(start);
			System.out.println("#" + test_case + " " +ans);
		}
	}
	private static void bfs(int start) {
		Deque<Integer> queue = new ArrayDeque<>();
		queue.offer(start);
		visited[start] = 1;
		while (!queue.isEmpty()) {
			int node = queue.poll();
			for (int next : arr.get(node)) {
				if (visited[next] != 0) continue;
				visited[next] = visited[node] + 1;
				queue.offer(next);
			}
		}
		int max = 0;
		int maxIdx = 0;
		for (int i = 1; i <= 100; i++) {
			if (visited[i] >= max) {
				maxIdx = i;
				max = visited[i];
			}
		}
		ans = maxIdx;
	}
}