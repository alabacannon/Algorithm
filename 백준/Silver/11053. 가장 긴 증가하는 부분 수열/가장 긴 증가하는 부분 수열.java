import java.io.FileInputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) throws IOException {
//		System.setIn(new FileInputStream("data/input.txt"));
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] dp = new int[n];
		int[] arr = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = sc.nextInt();
		}
		Arrays.fill(dp, 1);
		for (int i = 1; i < n; i++) {
			int max = 1;
			for (int j = 0; j < i; j++) {
				if (arr[i] > arr[j]) {
					max = Math.max(max, dp[j]+1);
				}
			}
			dp[i] = max;
			 
		}
		System.out.println(Arrays.stream(dp).max().orElse(-1));
	}
}