import java.io.FileInputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;
 
public class Solution {	
	static int winGyu;
	static int scoreGyu;
	static int[] gyuYeong;
	static int[] inYeong;
	static int[] sel;
	static boolean[] visited;
	final static int halfScore = 18 * 19 /4;
	final static int totalWin = 9*8*7*6*5*4*3*2;
    public static void main(String[] args) throws IOException {
		//System.setIn(new FileInputStream("data/input.txt"));
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		for (int test_case = 1; test_case <= t; test_case++) {
			winGyu = 0;
			boolean[] isGyucards = new boolean[19];
			for (int i = 0; i < 9; i++) {
				isGyucards[sc.nextInt()] = true;
			}
			gyuYeong = new int[9];
			inYeong = new int[9];
			sel = new int[9];
			visited = new boolean[9];
			int idx1 = 0;
			int idx2 = 0;
			for (int i = 1; i <= 18; i++) {
				if (isGyucards[i]) {
					gyuYeong[idx1++] = i;
				} else {
					inYeong[idx2++] = i;
				}
			}
			scoreGyu = 0;
			perm(0);
			System.out.println("#" +test_case +" " + winGyu + " " + (totalWin - winGyu));
			
		}
	}

	private static void perm(int cnt) {
		if (cnt == 9) {
			if (scoreGyu > halfScore) {
				winGyu++;
			}
			return;
		}
		for (int i = 0; i < 9; i++) {
			if (visited[i]) continue;
			visited[i] = true;
			sel[cnt] = inYeong[i];
			if (gyuYeong[cnt] > sel[cnt]) {
				scoreGyu += gyuYeong[cnt] + sel[cnt];
			}
			perm(cnt+1);
			visited[i] = false;
			if (gyuYeong[cnt] > sel[cnt]) {
				scoreGyu -= gyuYeong[cnt] + sel[cnt];
			}
			
		}
		
	}
}