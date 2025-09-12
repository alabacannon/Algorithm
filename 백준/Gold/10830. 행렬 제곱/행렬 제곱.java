import java.io.FileInputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;


public class Main {
	static int n;
	static long b;
	static int[][] matrix;
	public static void main(String[] args) throws IOException {
		//System.setIn(new FileInputStream("data/input.txt"));
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		b = sc.nextLong();
		matrix = new int[n][n];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				matrix[i][j] = sc.nextInt();
			}
		}
		int[][] result = divideConquer(b);
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				System.out.print(result[i][j]%1000 + " ");
			}
			System.out.println();
		}
	}
	private static int[][] divideConquer(long m) {
		if (m == 1) {
			return matrix;
		}
		
		int[][] temp = divideConquer(m/2);
		int[][] result = multiple(temp, temp);
		
		if (m % 2 == 1) {
			result = multiple(result, matrix);
		}
		
		return result;
			
		
	}
	private static int[][] multiple(int[][] mat1, int[][] mat2) {
		int[][] result = new int[n][n];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				for(int k = 0; k < n; k++) {
					result[i][j] += mat1[i][k] * mat2[k][j]; 
				}
				result[i][j] %= 1000;
			}
		}
		
		return result;
	}
}
			
