import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

public class Main {
	static int n;
	static int m;
	static int[] nums;
	static boolean[] visited;
	static ArrayList<Integer> select;
	static LinkedHashSet<ArrayList<Integer>> set = new LinkedHashSet<>();
	public static void main(String[] args) throws IOException {
//		System.setIn(new FileInputStream("data/input.txt"));
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		n = sc.nextInt();
		m = sc.nextInt();
		nums = new int[n];
		visited = new boolean[n];
		select = new ArrayList<>(m);
		for (int i = 0; i < n; i++) {
			nums[i] = sc.nextInt();
		}
		Arrays.sort(nums);
		
		
		combination(0);
		for (ArrayList<Integer> e: set) {
			for (int num : e) {
				sb.append(num + " ");
			}
			sb.append("\n");
		}
		System.out.print(sb.toString());
	}
	private static void combination(int count) {
		if (count == m) {
			set.add(new ArrayList<>(select));
			return;
		}
		for (int i = 0; i < n; i++) {
			if (visited[i]) {
				continue;
			}
			select.add(nums[i]);
			visited[i] = true;
			combination(count+1);
			select.remove(count);
			visited[i] = false;
		}
	}
}
