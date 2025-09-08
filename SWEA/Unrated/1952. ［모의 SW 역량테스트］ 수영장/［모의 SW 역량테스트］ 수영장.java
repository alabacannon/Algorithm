import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Collectors;

public class Solution {
	static ArrayList<Integer> costPolicy, monthlyUse;
	static int ans;
	
	public static void main(String[] args) throws IOException {
//		BufferedReader br = new BufferedReader(new FileReader("data/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int t = Integer.parseInt(br.readLine());
		for (int test_case = 1; test_case <= t; test_case++) {
			costPolicy = new ArrayList<>();
			costPolicy.add(0);
			monthlyUse = new ArrayList<>();
			monthlyUse.add(0);
			costPolicy.addAll(Arrays.stream(br.readLine().split(" "))
					.map(Integer::parseInt)
					.collect(Collectors.toList())); 
			monthlyUse.addAll(Arrays.stream(br.readLine().split(" "))
					.map(Integer::parseInt)
					.collect(Collectors.toList()));
			ans = Integer.MAX_VALUE;
			dfs(0,0);
			ans = Math.min(ans, costPolicy.get(4));
			sb.append("#").append(test_case).append(" ").append(ans).append("\n");
		}
		System.out.println(sb.toString());
		
		br.close();

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