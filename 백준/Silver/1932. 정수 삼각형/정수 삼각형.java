import java.io.FileInputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) throws IOException {
		
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[][] triangle = new int[n][];
		triangle[0] = new int[] {sc.nextInt()};
		for (int i = 1; i < n; i++) {
			triangle[i] = new int[i+1];
			triangle[i][0] = triangle[i-1][0] + sc.nextInt();
			
			for (int j = 1; j < i; j++) {
				int num = sc.nextInt();
				triangle[i][j] = Math.max(triangle[i-1][j] + num, triangle[i-1][j-1] + num);
			}
			triangle[i][i] = triangle[i-1][i-1] + sc.nextInt();
		}
		int max = Arrays.stream(triangle[n-1]).max().orElse(-1);
		System.out.println(max);
		
	}
}