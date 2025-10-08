import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int n,k;
	static int[] arr;
	static int[][] tree;
	static boolean isYes;
	public static void main(String[] args) throws IOException {
//		BufferedReader br = new BufferedReader(new FileReader("data/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int t = Integer.parseInt(br.readLine());
		for (int tc = 0; tc < t; tc++) {
			st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			k = Integer.parseInt(st.nextToken());
			tree = new int[getTreeSize(n)][2];
			arr = new int[n];
			for (int i = 1; i < n; i++) {
				arr[i] = i;
			}
			init(1,0,n-1);
			for (int i = 0; i < k; i++) {
				st = new StringTokenizer(br.readLine());
				int q = Integer.parseInt(st.nextToken());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				if (q == 0) { // 바꾸기
					int tmp = arr[a];
					arr[a] = arr[b];
					arr[b] = tmp;
					update(1,0,n-1,a,arr[a]);
					update(1,0,n-1,b,arr[b]);
				} else { // 조회하기
					int[] query = search(1,0,n-1,a,b);
					if (query[0] == b && query[1] == a) {
						System.out.println("YES");
					} else {
						System.out.println("NO");
					}
				}
				
			}
			
		}
		
		

		br.close();
	}
	
	private static int[] search(int node, int start, int end, int a, int b) {
		if (a > end || b < start) {
			return new int[] {Integer.MIN_VALUE,Integer.MAX_VALUE};
		}
		if (start >= a && end <= b) {
			return tree[node];
		}
		int mid = (start + end)/2;
		int[] tmp1 = search(node<<1, start, mid, a, b);
		int[] tmp2 = search((node<<1)+1, mid+1, end, a, b);
		return new int[] {Math.max(tmp1[0], tmp2[0]),Math.min(tmp1[1], tmp2[1])};
	}

	private static void update(int node, int start, int end, int idx, int value) {
		if (start == end) {
			tree[node][0] = arr[idx];
			tree[node][1] = arr[idx];
			return;
		}
		int mid = (start + end)/2;
		
		if (idx <= mid) {
			update(node<<1, start, mid,idx, value);
		} else {
			update((node<<1)+1, mid+1, end,idx,value);
		}
		tree[node][0] = Math.max(tree[node<<1][0],tree[(node<<1)+1][0]);
		tree[node][1] = Math.min(tree[node<<1][1],tree[(node<<1)+1][1]);
		return;
	}
	
	private static int[] init(int node, int start, int end) {
		if (start == end) {
			return tree[node] = new int[] {arr[start],arr[start]};
		}
		int mid = (start + end)/2;
		int[] tmp1 = init(node<<1, start, mid);
		int[] tmp2 = init((node<<1)+1, mid+1, end);
		
		return tree[node] = new int[] {Math.max(tmp1[0], tmp2[0]),Math.min(tmp1[1], tmp2[1])};
	}
	
	private static int getTreeSize(int n) {
		int h = (int) Math.ceil(Math.log(n)/Math.log(2));
		return (int) Math.pow(2, h+1)+1;
	}
}