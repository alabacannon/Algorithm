import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
	static class Node{
		int row;
		int column;
	}
	public static void main(String[] args) throws IOException {
		//System.setIn(new FileInputStream("data/input.txt"));
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		ArrayList<Node> list = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			list.add(new Node());
		}
		for (int i = 0; i < n; i++) {
			list.get(i).row = sc.nextInt();
			list.get(i).column = sc.nextInt();
		}
		// i번 인덱스에서 j인덱스 까지 행렬들에 대해 곱연산의 최소값
		int[][] dp = new int[n][n];
		for (int i = 0; i < n; i++) {
			for (int j = i+1; j < n; j++) {
				dp[i][j] = Integer.MAX_VALUE;
			}
		}
		for (int i = 1; i < n; i++) {
			dp[i-1][i] = list.get(i-1).row * list.get(i-1).column * list.get(i).column; 
		}
		for (int i = n-3; i >= 0; i--) {
			Node left = list.get(i);
			for (int j = i+2; j < n; j++) {
				Node right = list.get(j);
				for(int pivot = i; pivot < j; pivot++) {
					Node mid = list.get(pivot);
					int tmp = dp[i][pivot] + dp[pivot+1][j] + left.row * mid.column * right.column;
 
					dp[i][j] = Math.min(tmp,dp[i][j]);
				}
			}
		}
//		for (int i = 0; i < dp.length; i++) {
//			System.out.println(Arrays.toString(dp[i]));
//		}
		System.out.println(dp[0][n-1]);
	}
}