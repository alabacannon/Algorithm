import java.io.FileInputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
	static int k;
	static int[] arr;
	static Scanner sc;
	public static void main(String[] args) throws IOException {
		//System.setIn(new FileInputStream("data/input.txt"));
		sc = new Scanner(System.in);
		k = sc.nextInt();
		arr = new int[1<<k];
		inOrder(1);
		int index = 1;
		for (int i = 0; i < k; i++) {
			for (int j = 0; j < 1<<i; j++) {
				System.out.print(arr[index] + " ");
				index++;
			}
			System.out.println();
		}
	}

	private static void inOrder(int idx) {
		if (idx >= 1<<(k-1)) {
			arr[idx] = sc.nextInt();
			return;
		}
		inOrder(idx<<1);
		arr[idx] = sc.nextInt();
		inOrder((idx<<1)+1);
	}
	
}