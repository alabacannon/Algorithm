import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
	static class Node{
		int num;
		int parent;
		int subtreeCount;
		ArrayList<Integer> neighbor;
		public Node(int num, ArrayList<Integer> neighbor) {
			super();
			this.num = num;
			this.neighbor = neighbor;
		}
		
	}
	static Node[] tree;
	static int n,r,q;
	public static void main(String[] args) throws IOException {
//		BufferedReader br = new BufferedReader(new FileReader("data/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		r = Integer.parseInt(st.nextToken());
		q = Integer.parseInt(st.nextToken());
		tree = new Node[n+1];
		for (int i = 1; i <= n; i++) {
			tree[i] = new Node(i, new ArrayList<>());
		}
		for (int i = 0; i < n-1; i++) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			tree[u].neighbor.add(v);
			tree[v].neighbor.add(u);
		}
		makeTree(r);
		setSubtreeCount(r);
		for (int i = 0; i < q; i++) {
			int query = Integer.parseInt(br.readLine());
			System.out.println(tree[query].subtreeCount);
		}
		br.close();
	}

	private static int setSubtreeCount(int cur) {
		int size = 1;
		for (int child : tree[cur].neighbor) {
			if (child == tree[cur].parent) continue; 
			size += setSubtreeCount(child);
		}
		tree[cur].subtreeCount = size;
		return size;
	}

	private static void makeTree(int cur) {
		for (int child : tree[cur].neighbor) {
			if (child == tree[cur].parent) continue; 
			tree[child].parent = cur;
			makeTree(child);
		}
		
	}
}
