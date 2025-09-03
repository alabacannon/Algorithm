import java.io.FileInputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) throws IOException {
		//System.setIn(new FileInputStream("data/input.txt"));
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		for (int test_case = 1; test_case <= t; test_case++) {
			int n = sc.nextInt();
			int[] trees = new int[n];
			for (int i = 0; i < n; i++) {
				trees[i] = sc.nextInt();
			}
			int maxHeight = Arrays.stream(trees)
									.max().orElse(-1);
			int residual = 0;
			int oddDayCount = 0;
			for (int i = 0; i < n; i++) {
				trees[i] = maxHeight - trees[i];
				if (trees[i]%2 == 1) {
					trees[i]--;
					oddDayCount++;
				}
				residual+= trees[i];
			}

			int evenDayCount = residual/2;
			while(evenDayCount > oddDayCount+1) {
				evenDayCount --;
				oddDayCount += 2;
			}
			if (evenDayCount<oddDayCount-1) {
				evenDayCount = oddDayCount-1;
			}
			if (oddDayCount < evenDayCount) {
				oddDayCount = evenDayCount;
			}
			System.out.println("#" + test_case + " " + (oddDayCount + evenDayCount));
		}
		
	}
}
