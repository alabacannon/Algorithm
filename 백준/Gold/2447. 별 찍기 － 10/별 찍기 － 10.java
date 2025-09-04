import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
	static int n;
	static StringBuilder sb = new StringBuilder();
	static char[][] map;
	public static void main(String[] args) throws IOException {
		//System.setIn(new FileInputStream("data/input.txt"));
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		map = new char[n][n];
		for (int i = 0; i < n; i++) {
			Arrays.fill(map[i], ' '); 
		}
		printStars(n,0,0);
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				sb.append(map[i][j]);
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}

	private static void printStars(int len, int x, int y) {
		if (len == 1) {
			map[x][y] = '*';
			return;
		}
		for (int i = x; i < x + len; i = i + len/3) {
			for (int j = y; j < y + len; j = j + len/3) {
				if(i == x + len/3 && j == y + len/3) {
					continue;
				}
				printStars(len/3, i, j);
			}
		}
	}
}
