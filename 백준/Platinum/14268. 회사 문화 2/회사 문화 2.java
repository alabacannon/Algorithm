import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static class Person{
		int w;
		int cumul;
		ArrayList<Integer> child;
		
		public Person(int w, ArrayList<Integer> child) {
			this.w = w;
			this.child = child;
		}
		
	}
	static ArrayList<Person> company;
	static int result,count;
	static int[] tree, lazy,in,out;
	public static void main(String[] args) throws IOException {
//		BufferedReader br = new BufferedReader(new FileReader("data/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		company = new ArrayList<>();
		tree=new int[n*4];
		lazy = new int[n*4];
		in = new int[n+1];
		out = new int[n+1];
		count = 0;
		for (int i = 0; i <= n; i++) {
			company.add(new Person(0,new ArrayList<>()));
		}
		st.nextToken();
		for (int i = 2; i <= n; i++) {
			company.get(Integer.parseInt(st.nextToken())).child.add(i); 
		}
		dfs(1);
		for (int k = 0; k < m; k++) {
			st = new StringTokenizer(br.readLine());
			int q = Integer.parseInt(st.nextToken());
			if (q == 1) {
				int i = Integer.parseInt(st.nextToken());
				int w = Integer.parseInt(st.nextToken());
				update(1,1,n,in[i],out[i],w);
			} else {
				int i = Integer.parseInt(st.nextToken());
				System.out.println(search(1,1,n,in[i]));
			}
		}
		

		br.close();
	}
	
	private static int search(int node, int start, int end, int idx) {
		propagation(node, start, end);
		if (start == end) {
			return tree[node];
		}
		int mid = (start + end)/2;
		if (idx <= mid) {
			return search(node<<1, start, mid, idx);
		} else {
			return search((node<<1)+1, mid + 1, end, idx);
		}
		
	}

	private static void update(int node, int start, int end, int left, int right, int w) {
		propagation(node,start,end);
		if (left > end || right < start) {
			return;
		}
		if (left <= start && end <= right) {
			lazy[node] += w; 
			
			return;
		}
		int mid = (start + end)/2;
		update(node<<1, start, mid, left, right, w);
		update((node<<1)+1, mid+1, end, left, right, w);
		
	}

	private static void propagation(int node, int start, int end) {
		if (lazy[node] == 0) {
			return;
		}
		tree[node] += (end - start + 1) * lazy[node];
		if (start == end) {
			lazy[node] = 0;
			return;
		}
		lazy[node<<1] += lazy[node];
		lazy[(node<<1)+1] += lazy[node];
		lazy[node] = 0;
		
	}

	private static void dfs(int cur) {
		count++;
		in[cur] = count;
		Person p = company.get(cur);
		for (int next : p.child) {
			dfs(next);
		}
		out[cur] = count;
	}
}