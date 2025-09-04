import java.io.FileInputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class Solution {
	static int n, m, x;
	static int maxHamzzi;
	static int[] hamzziCage;
	static int[] ans;
	static Record[] records;

	static class Record {
		int start, end, sum;
		Record(int start, int end, int sum) {
			this.start = start;
			this.end = end;
			this.sum = sum;
		}
	}

	public static void main(String[] args) throws IOException {
		//System.setIn(new FileInputStream("data/input.txt"));
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		for (int test_case = 1; test_case <= t; test_case++) {
			n = sc.nextInt();
			x = sc.nextInt();
			m = sc.nextInt();

			maxHamzzi = -1;
			hamzziCage = new int[n];
			ans = new int[n];
			records = new Record[m];

			for (int i = 0; i < m; i++) {
				int start = sc.nextInt();
				int end = sc.nextInt();
				int sum = sc.nextInt();
				records[i] = new Record(start, end, sum);
			}
			
			solve(0);

			System.out.print("#" + test_case + " ");
			if (maxHamzzi == -1) {
				System.out.println(-1);
			} else {
				for (int hamzzi : ans) {
					System.out.print(hamzzi + " ");
				}
				System.out.println();
			}
		}
	}

	public static void solve(int depth) {
		if (depth == n) {
			updateAnswer();
			return;
		}

		for (int i = 0; i <= x; i++) {
			hamzziCage[depth] = i;
			if (isValid(depth)) {
				solve(depth + 1);
			}
		}
	}

	public static boolean isValid(int currentDepth) {
		for (Record rec : records) {
			if (rec.end <= currentDepth + 1) {
				int currentSum = 0;
				for (int i = rec.start - 1; i < rec.end; i++) {
					currentSum += hamzziCage[i];
				}
				if (currentSum != rec.sum) {
					return false;
				}
			}
		}
		return true;
	}

	public static void updateAnswer() {
		int total = 0;
		for (int hamzzi : hamzziCage) {
			total += hamzzi;
		}

		if (total > maxHamzzi) {
			maxHamzzi = total;
			ans = Arrays.copyOf(hamzziCage, n);
		} 
		else if (total == maxHamzzi) {
			if (isSmaller(hamzziCage, ans)) {
				ans = Arrays.copyOf(hamzziCage, n);
			}
		}
	}
	
	public static boolean isSmaller(int[] newArr, int[] oldArr) {
		for (int i = 0; i < n; i++) {
			if (newArr[i] < oldArr[i]) {
				return true;
			} else if (newArr[i] > oldArr[i]) {
				return false;
			}
		}
		return false;
	}
}