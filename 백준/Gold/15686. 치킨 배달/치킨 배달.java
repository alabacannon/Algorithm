import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
	static int n;
	static int m;
	static int ans;
	static int[][] map;
	static ArrayList<int[]> chicken = new ArrayList<>();
	static ArrayList<int[]> home = new ArrayList<>();
	static int[][] sel; 
	public static void main(String[] args) throws IOException {
		//System.setIn(new FileInputStream("data/input.txt"));
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		map = new int[n][n];
		sel = new int[m][2];
		ans = Integer.MAX_VALUE;

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				map[i][j] = sc.nextInt();
				if (map[i][j] == 2) {
					chicken.add(new int[] {i,j});
				} else if(map[i][j] == 1) {
					home.add(new int[] {i,j});
				}
			}
		}
		combination(0,0);
		System.out.println(ans);
	}
	private static void combination(int start, int cnt) {
		if (cnt == m) {
			findDistance();
			return;
		}
		for (int i = start; i < chicken.size(); i++) {
			sel[cnt] = chicken.get(i);
			combination(i+1, cnt+1);
		}
	}
	private static void findDistance() {
		int result = 0; 
		for (int[] e : home) {
			result += getDistance(e);
		}
		ans = Math.min(result, ans);
	}
	private static int getDistance(int[] e) {
		int dist = 5000;
		for (int[] i : sel) {
			int tmp = Math.abs(i[0] - e[0]) + Math.abs(i[1] - e[1]); 
			dist = Math.min(tmp, dist);
		}
		return dist;
	}
}
