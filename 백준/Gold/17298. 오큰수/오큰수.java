import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class Main {
	static int n;
	static int[] arr, result;
	static Deque<Integer> stack ;
	public static void main(String[] args) throws IOException {
//		BufferedReader br = new BufferedReader(new FileReader("data/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		n = Integer.parseInt(br.readLine());
		arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		result = new int[n];
		stack = new ArrayDeque<>();

		updateResult();
		
		printResult();
		br.close();
	}

	private static void printResult() {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < n; i++) {
			sb.append(result[i]).append(" ");
		}
		System.out.println(sb);
	}

	private static void updateResult() {
		for (int i = n-1; i >=0 ; i--) {
			while (!stack.isEmpty() && stack.peek()<=arr[i]) {
				stack.pop();
			}
			result[i] = stack.isEmpty() ? -1 : stack.peek();
			stack.push(arr[i]);

		}
	}
}
