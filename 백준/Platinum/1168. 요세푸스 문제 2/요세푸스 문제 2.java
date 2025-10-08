import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int n, k;
	static int[] tree;
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws IOException {
//		BufferedReader br = new BufferedReader(new FileReader("data/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		tree = new int[getTreeSize(n)];
		init(1,1,n);
		int idx = 1;
		sb.append("<");
		for (int i = n; i >= 1; i--) {
			idx += k-1;
			if (idx > i) {
				idx %= i;
			}
			if (idx == 0) {
				idx += i;
			}
			delete(1, idx, 1, n);
			
			if (i != 1) {
				sb.append(", ");
			} else {
				sb.append(">");
			}
		}
		System.out.println(sb);


		br.close();
	}
	
	private static int init(int node, int start, int end) {
		if (start == end) {
			return tree[node] = 1;
		}
		int mid = (start + end)/2;
		return tree[node] = init(node<<1, start, mid) + init((node<<1)+1, mid + 1, end); 
		
	}

	private static void delete(int node, int idx, int start, int end) {
		if (start == end) {
			tree[node]--;
			sb.append(start);
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