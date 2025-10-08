import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
	static int n,m;
	static long[] arr, tree;
	static long result;
	public static void main(String[] args) throws IOException {
//		BufferedReader br = new BufferedReader(new FileReader("data/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		n = Integer.parseInt(br.readLine());
		arr = new long[n+1];
		tree = new long[getTreeSize(n)];
		st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		init(1,1,n);
		m = Integer.parseInt(br.readLine());
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int q = Integer.parseInt(st.nextToken());
			if (q == 1) {
				int left = Integer.parseInt(st.nextToken());
				int right = Integer.parseInt(st.nextToken());
				int value = Integer.parseInt(st.nextToken());
				set(1,1,n,left,right,value);
			} else {
				int idx = Integer.parseInt(st.nextToken());
				get(1,1,n,idx);
				System.out.println(result);
			}
		}
		br.close();
	}
	
	

	private static void set(int node, int start, int end, int left, int right, int value) {
		if (left > end || right < start ) {
			return;
		}
//		if (start == end) {
//			tree[node] += value;
//			return;
//		}
		if (left <= start && right >= end) {
			tree[node] += value;
			return;
		}
		int mid = (start + end)/2;
		set(node<<1, start, mid, left, right, value);
		set((node<<1)+1, mid + 1, end, left, right, value);
	}
	private static void get(int node, int start, int end, int idx) {
		if (idx < start || idx > end) {
			return;
		}
		
		if (start == end) {
			result = tree[node];
			return;
		}
		int mid = (start + end)/2;
		if (tree[node] != 0) {
			update(node<<1, start, mid, tree[node]);
			update((node<<1)+1, mid+1, end, tree[node]);
			tree[node] = 0;
		}
		if (idx<=mid) {
			get(node<<1, start, mid, idx);
		} else {
			get((node<<1)+1, mid+1, end, idx);
			
		}
	}
	
	private static void update(int node, int start, int end, long updateValue) {
		if (start == end) {
			tree[node] += updateValue;
			return;
		}
		updateValue += tree[node];
		tree[node] = 0;
		int mid = (start + end)/2;
		update(node<<1, start, mid, updateValue);
		update((node<<1)+1, mid+1, end, updateValue);
	}



	private static void init(int node, int start, int end) {
		if (start == end) {
			tree[node] = arr[start];
			return;
		}
		int mid = (start + end)/2;
		init(node<<1, start, mid);
		init((node<<1)+1, mid+1, end);
	}
	
	private static int getTreeSize(int n) {
		int h = (int) Math.ceil(Math.log(n)/Math.log(2));
		return (int)Math.pow(2, h+1)+1;
	}
}