import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main  {
	static int ans;
	static int n;
	static ArrayList<Integer> subsetA;
	static ArrayList<Integer> subsetB;
	static ArrayList<ArrayList<Integer>> graph;
	static int[] polulation;
	public static void main(String[] args) throws IOException {
		//System.setIn(new FileInputStream("data/input.txt"));
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		polulation = new int[n+1];
		graph = new ArrayList<>();
		for (int i = 0; i <= n; i++) {
			graph.add(new ArrayList<>());
		}
		for (int i = 1; i <= n; i++) {
			polulation[i] = sc.nextInt();
		}
		for (int i = 1; i <= n; i++) {
			int nodeNum = sc.nextInt();
			for (int j = 0; j < nodeNum; j++) {
				graph.get(i).add(sc.nextInt());
			}
		}
		ans = Integer.MAX_VALUE;
		for (int i = 1; i < 1<<(n-1); i++) {
			subsetA = new ArrayList<>();
			subsetB = new ArrayList<>();
			for (int j = 0; j < n; j++) {
				if ((i&1<<j)!=0) {
					subsetA.add(j+1);
				}else {
					subsetB.add(j+1);
				}
			}
			findMinDiff();
		}
		
		if (ans == Integer.MAX_VALUE) {
			ans = -1;
		}
		System.out.println(ans);
	}
	private static void findMinDiff() {
		if (impossible(subsetA) || impossible(subsetB)) {
			return;
		}
		ans = Math.min(diff(), ans);
	}
	 private static int diff() {
        int scoreA = 0;
        for (int node : subsetA) {
            scoreA += polulation[node];
        }
        
        int scoreB = 0;
        for (int node : subsetB) {
            scoreB += polulation[node];
        }
        return Math.abs(scoreA - scoreB);
    }
	private static boolean impossible(ArrayList<Integer> subset) {
		// subset : [1,3,4]
		// visited : [false, false, false]
		Deque<Integer> queue = new ArrayDeque<>();
		boolean[] visited = new boolean[subset.size()];
		queue.offer(subset.get(0));
		visited[0] = true;
		while (!queue.isEmpty()) {
			int currentNode = queue.poll();
			int idx = subset.indexOf(currentNode);
			for (int nextNode : graph.get(currentNode)) {
				if (!subset.contains(nextNode)) {
					continue;
				}
				if (visited[subset.indexOf(nextNode)]) {
					continue;
				}
				queue.offer(nextNode);
				visited[subset.indexOf(nextNode)] = true;
			}
		}
		for (int i = 0; i < visited.length; i++) {
			if (!visited[i]) {
				return true;
			}
		}
		
		return false;
	}
	
}