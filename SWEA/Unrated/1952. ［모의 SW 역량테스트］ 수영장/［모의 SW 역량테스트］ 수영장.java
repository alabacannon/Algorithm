import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Solution {
	static ArrayList<Integer> costPolicy, monthlyUse;
	static int ans;
	public static void main(String[] args) throws IOException {
		//System.setIn(new FileInputStream("data/input.txt"));
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		sc.nextLine();
		for (int test_case = 1; test_case <= t; test_case++) {
			costPolicy = new ArrayList<>();
			costPolicy.add(0);
			monthlyUse = new ArrayList<>();
			monthlyUse.add(0);
			costPolicy.addAll(Arrays.stream(sc.nextLine().split(" "))
					.map(Integer::parseInt)
					.collect(Collectors.toList())); 
			monthlyUse.addAll(Arrays.stream(sc.nextLine().split(" "))
					.map(Integer::parseInt)
					.collect(Collectors.toList()));
			ans = Integer.MAX_VALUE;
			dfs(0,0);
			ans = Math.min(ans, costPolicy.get(4));
			System.out.println("#" + test_case + " " + ans);
		}
	}
	private static void dfs(int month, int cost) {
		if (month >= 12) {
			if (month == 12) {
				ans = Math.min(ans, cost);
			}
			return;
		}
		dfs(month + 1, cost + monthlyUse.get(month+1) * costPolicy.get(1));
		dfs(month + 1, cost + costPolicy.get(2));
		dfs(month + 3, cost + costPolicy.get(3));
	}
	
}