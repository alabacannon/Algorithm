import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static final int MOD = 1000000007;
	static int n,m,k;
	static long[] arr, tree;
	public static void main(String[] args) throws IOException {
//		BufferedReader br = new BufferedReader(new FileReader("data/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		arr = new long[n+1];
		tree = new long[getTreeSize(n)];
		for (int i = 1; i <= n; i++) {
			arr[i] =Integer.parseInt(br.readLine()); 
		}
		init(1,1,n);
//		System.out.println(Arrays.toString(arr));
//		System.out.println(Arrays.toString(tree));
//		System.out.println("=======");
		for (int i = 0; i < m+k; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			if (a ==1) {
				arr[b] = c;
				update(1,1,n,b,c);
			} else { //a == 2
				long result = multiple(1,1,n,b,c);
				System.out.println(result);
			}
//			System.out.println(Arrays.toString(arr));
//			System.out.println(Arrays.toString(tree));
		}
		br.close();
	}
	
	
	private static long update(int node, int start, int end, int idx, int updateNum) {
		if (idx > end || idx < start) {
			return tree[node];
		}
		if (start == end) return tree[node] = updateNum;
		int mid = (start + end)/2;
		
		return tree[node]= (update(node<<1,start,mid,idx,updateNum)% MOD) * (update((node<<1) + 1,mid+1,end,idx,updateNum) % MOD)% MOD;
		
	}


	private static long multiple(int node, int start, int end, int left, int right) {
		if (left > end || right < start) {
			return 1;
		}
		if (left <= start && right >= end) {
			return tree[node];
		}
		int mid = (start + end)/2;

		return (multiple(node<<1, start, mid, left, right)%MOD) * (multiple((node<<1) + 1, mid+1,end, left, right)%MOD)%MOD;
	}


	private static long init(int node, int start, int end) {
		if (start == end) return tree[node] = arr[start];
		
		int mid = (start + end)/2;
		
		return tree[node]= (init(node<<1,start,mid)% MOD) * (init((node<<1) + 1,mid+1,end) % MOD)% MOD;
	}


	private static int getTreeSize(int n) {
		int h = (int) Math.ceil(Math.log(n)/Math.log(2));
		return (int)(Math.pow(2, h+1) + 1);
	}
}