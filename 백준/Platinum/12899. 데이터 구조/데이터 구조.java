import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
	static int n, result;
	static int[] tree;
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws IOException {
//		BufferedReader br = new BufferedReader(new FileReader("data/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		n = Integer.parseInt(br.readLine());
		tree = new int[getTreeSize(2000000)];
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			int t = Integer.parseInt(st.nextToken());
			if (t == 1) {
				int x = Integer.parseInt(st.nextToken());
				insert(1,x,1,2000000);
			} else {
				int idx = Integer.parseInt(st.nextToken());
				delete(1,idx,1,2000000);
			}
		}
		System.out.println(sb);



		br.close();
	}
	private static void insert(int node, int x, int start, int end) {
		if (start == end) {
			tree[node]++;
//			System.out.println(start);
			return;
		}
		tree[node]++;
		int mid = (start + end)/2;
		if (x <= mid) {
			insert(node<<1, x, start, mid);
		} else {
			insert((node<<1)+1, x, mid+1, end);
		}
		
		
	}
	private static void delete(int node, int idx, int start, int end) {
		if (start == end) {
			tree[node]--;
			sb.append(start).append("\n");
			return;
		}
		
		tree[node]--;
		int mid = (start + end)/2;
		if (idx <= tree[node<<1]) {
			delete(node<<1, idx, start, mid);
		} else {
			delete((node<<1)+1, idx-tree[node<<1], mid+1, end);
		}
		
	}
	private static int getTreeSize(int n) {
		int h = (int) Math.ceil(Math.log(n)/Math.log(2));
		return (int) Math.pow(2, h+1) + 1;
	}
}