import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
	static int k;
	static ArrayList<ArrayList<Integer>> tree;
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws IOException {
//		BufferedReader br = new BufferedReader(new FileReader("data/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		k = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		tree = new ArrayList<>();
		for (int i = 0; i < k; i++) { 
			tree.add(new ArrayList<>());
		}
		inOrder(0);
		printTree();
		br.close();
	}
	private static void inOrder(int depth) {
		if (depth == k-1) {
			tree.get(depth).add(Integer.parseInt(st.nextToken()));
			return;
		}
		
		inOrder(depth+1);
		tree.get(depth).add(Integer.parseInt(st.nextToken()));
		inOrder(depth+1);
	}
	private static void printTree() {
		for (ArrayList<Integer> level : tree) {
			for (Integer node : level) {
				sb.append(node).append(" ");
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}
}
