import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayDeque;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) throws IOException {
//		System.setIn(new FileInputStream("data/input.txt"));
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		permutation(1,n,m, new ArrayDeque<>());
	}

	private static void permutation(int start , int n, int m, ArrayDeque<Integer> stack) {
		if(m == 0) {
			Object[] arr = stack.clone().toArray();
			for (int i = arr.length-1; i >= 0; i--) {
				System.out.print(arr[i] + " ");
			}
			stack.pop();
			System.out.println();
			return;
		}
		for (int i = start; i <= n-m+1; i++) {
			stack.push(i);
			permutation(i+1, n, m-1, stack);
		}
		if(!stack.isEmpty()) {
			stack.pop();
		}
	}
	
	
}