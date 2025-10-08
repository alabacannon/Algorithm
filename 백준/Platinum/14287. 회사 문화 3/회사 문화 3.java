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
	static int[] tree, arr,in,out;
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
				int idx = Integer.parseInt(st.nextToken());
				int w = Integer.parseInt(st.nextToken());
				update(1,1,n,in[idx],w);
			} else {
				int i = Integer.parseInt(st.nextToken());
				System.out.println(sum(1,1,n,in[i],out[i]));
			}
		}
//		System.out.println(Arrays.toString(tree));
		

		br.close();
	}
	
	private static void update(int node, int start, int end, int idx,int diff) {
		tree[node] += diff;
		if (start == end) {
			return;
		}
		int mid = (start + end)/2;
		if (idx <= mid) {
			update(node<<1, start, mid, idx, diff);
		} else {
			update((node<<1) + 1, mid + 1, end, idx, diff);
			
		}
	}

	private static int sum(int node, int start, int end, int left, int right) {
		if (end<left || start > right) {
			return 0;
		}
		if (start == end) {
			return tree[node];
		}
		int mid = (start + end)/2;
		return sum(node<<1, start, mid, left, right) + sum((node<<1)+1, mid+1, end, left, right);
		
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