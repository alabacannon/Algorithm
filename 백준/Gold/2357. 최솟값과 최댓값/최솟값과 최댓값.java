import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int n,m;
	static int[] arr;
	static int[][] tree;
    public static void main(String[] args) throws IOException {
//		BufferedReader br = new BufferedReader(new FileReader("data/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		tree = new int[getTreeSize(n)][2];
		arr = new int[n+1];
		for (int i = 0; i < n; i++) {
			arr[i+1] = Integer.parseInt(br.readLine()); 
		}
		
		init(1,1,n);
		
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			System.out.print(findMin(1,a,b,1,n) + " ");
			System.out.println(findMax(1,a,b,1,n));
		}

		br.close();
	}
    
    private static int[] init(int node, int start, int end) {
		if (start == end) {
			return tree[node] = new int[] {arr[start],arr[start]};
		}
		int mid = (start + end)/2;
		int[] left = init(node<<1,start,mid);
		int[] right = init((node<<1)+1,mid+1,end);
		return tree[node] = new int[] {Math.max(left[0],right[0]),Math.min(left[1],right[1])};
		
	}
    
	private static int findMin(int node,int left, int right, int start, int end) {
		if (left > end || right < start) {
			return Integer.MAX_VALUE>>1;
		}
		if (left <= start && end<=right) {
			return tree[node][1];
		}
		int mid = (start + end)/2;
		return Math.min(findMin(node<<1, left, right, start, mid),findMin((node<<1) + 1, left, right, mid+1, end));
	}
	private static int findMax(int node, int left, int right, int start, int end) {
		if (left > end || right < start) {
			return 0;
		}
		if (left <= start && end<=right) {
			return tree[node][0];
		}
		int mid = (start + end)/2;
		return Math.max(findMax(node<<1, left, right, start, mid),findMax((node<<1) + 1, left, right, mid+1, end));
	}
	
	
	private static int getTreeSize(int n) {
		int height = (int) Math.ceil(Math.log(n)/Math.log(2));
		return (int) Math.pow(2, height+1) + 1;
	}
}