import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Main {
	static ArrayList<Integer> A,B;
	public static void main(String[] args) throws IOException {
		//System.setIn(new FileInputStream("data/input.txt"));
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int crossCount = 0;
		A = new ArrayList<>();
		B = new ArrayList<>();
		A.add(0);
		B.add(0);
		int[] arrA = new int[501];
		int[] arrB = new int[501];
		for (int i = 1; i <= n; i++) {
			int a = sc.nextInt(), b = sc.nextInt();
			arrA[a] = i;
			arrB[b] = i;
		}
		for (int i = 0; i < 501; i++) {
			if (arrA[i] != 0) {
				A.add(arrA[i]);
			}
			if (arrB[i] != 0) {
				B.add(arrB[i]);
			}
		}
		int[][] dp = new int[n+1][n+1];
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= n; j++) {
				if (A.get(i) == B.get(j)) {
					dp[i][j] = dp[i-1][j-1] + 1;
				} else {
					dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
				}
			}
		}
		System.out.println(n-dp[n][n]);
		
	}
}