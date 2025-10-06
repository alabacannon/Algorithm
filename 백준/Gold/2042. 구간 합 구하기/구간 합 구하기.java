import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int n,m,k;
	static long[] tree, arr;
	public static void main(String[] args) throws IOException {
		//BufferedReader br = new BufferedReader(new FileReader("data/input.txt"));
				BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		arr = new long[n+1];
		tree = new long[getTreeSize(n)];
		for (int i = 1; i <= n; i++) {
			arr[i] = Long.parseLong(br.readLine());
		}
		
		init(1,1,n);

		for (int i = 0; i < m+k; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			long c = Long.parseLong(st.nextToken());
			if (a == 1) {
				long diff = c-arr[b];
				arr[b] = c;
				update(1,1,n,b,diff);

			} else {
				sb.append(sum(1,1,n,b,(int)c)).append("\n");
			}
		}
		System.out.println(sb);

		br.close();
	}
	private static long sum(int node, int start, int end, int left, int right) {
		if (left > end || right < start) {
			return 0;
		}
		if (left <= start && end <= right) {
			return tree[node];
		}
		int mid = start + (end-start)/2;
		
		return sum(node<<1, start, mid, left, right) + sum((node<<1) + 1, mid+1, end, left, right);
	}
	private static void update(int node, int start, int end ,int idx, long diff) {
		if (idx < start || idx > end) {
			return;
		}
		tree[node] += diff;
		if (start != end) {
			int mid = start + (end-start)/2;
			update(node<<1,start,mid,idx,diff);
			update((node<<1) + 1,mid+1,end,idx,diff);
		}
		
	}
	private static int getTreeSize(int n) {
		int h = (int) Math.ceil(Math.log(n)/Math.log(2));
		return (int)Math.pow(2, h+1) + 1;
	}
	private static long init(int node, int start, int end) {
		if (start == end) {
			return tree[node] = arr[start];
		}
		int mid = start + (end - start)/2;
		return tree[node] = init(node<<1,start,mid) + init((node<<1) + 1,mid+1,end); 
	}
	
}


