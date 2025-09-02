import java.io.FileInputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class Solution  {
	static int[] board;
	static boolean[] visited;
	static int n;
	static int ans;
	public static void main(String[] args) throws IOException {
		//System.setIn(new FileInputStream("data/input.txt"));
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		for (int test_case = 1; test_case <= t; test_case++) {
			ans = 0;
			n = sc.nextInt();
			board = new int[n];
			visited = new boolean[n];
			backtracking(0);
			System.out.println("#" + test_case + " "+ ans);
			
		}
	}

	private static void backtracking(int x) {
		if (x == n) {
			ans ++;
			return;
		}
		for (int y = 0; y < n; y++) {
			if (visited[y] || crossCheck(x,y)) {
				continue;
			}
			visited[y] = true;
			board[x] = y;
			backtracking(x + 1);
			visited[y] = false;
		}
	}

	private static boolean crossCheck(int x, int y) {
		int compX, compY;
		for (int i = 0; i < x; i++) {
			compX = i;
			compY = board[i];
			if (cross(x-compX,y-compY)) {
				return true;
			}
		}
		return false;
	}

	private static boolean cross(int i, int j) {
		return i + j == 0 || i == j;
	}
}