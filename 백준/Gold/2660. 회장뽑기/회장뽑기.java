import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
 
public class Main {
	static ArrayList<ArrayList<Integer>> graph;
	public static void main(String[] args) throws IOException {
		//System.setIn(new FileInputStream("data/input.txt"));
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[][] dist = new int[n+1][n+1];
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <=n; j++) {
				dist[i][j] = Integer.MAX_VALUE>>1;
			}
			dist[i][i] = 0;
		}
		while (true) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			if (a == -1 && b == -1) break;
			dist[a][b] = 1;
			dist[b][a] = 1;
		}
		for (int k = 1; k <= n; k++) {
			for (int i = 1; i <=n; i++) {
				for (int j = 1; j <= n; j++) {
					dist[i][j] = Math.min(dist[i][k] + dist[k][j], dist[i][j]);
				}
			}
		}
		int minScore = 50;
		int[] scores = new int[n+1];
		for (int i = 1; i <= n; i++) {
			int tmp = Arrays.stream(dist[i]).max().orElse(-1);
			scores[i] = tmp;
			minScore = Math.min(minScore, tmp);
		}
		StringBuilder sb = new StringBuilder();
		int count = 0;
		for (int i = 1; i <= n; i++) {
			if (scores[i] == minScore) {
				count++;
				sb.append(i).append(" ");
			}
		}
		System.out.println(minScore + " " + count);
		System.out.println(sb);
	}
}