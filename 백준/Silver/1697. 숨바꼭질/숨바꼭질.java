import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) throws IOException {
		//System.setIn(new FileInputStream("data/input.txt"));
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int k = sc.nextInt();
		int[] arr = new int[100001];
		Deque<Integer> queue = new ArrayDeque<>();
		queue.offer(n);
		arr[n] = 0;
		while (!queue.isEmpty()) {
			int cur = queue.poll();
			if (cur == k) {
				System.out.println(arr[cur]);
				return;
			}
			if (cur < 100000 && arr[cur+1] ==0 ) {
				queue.offer(cur+1);
				arr[cur+1] = arr[cur] + 1;
				
			}
			if (cur>0 && arr[cur-1] ==0) {
				queue.offer(cur-1);
				arr[cur-1] = arr[cur] + 1;
			}
			if (cur * 2 <= 100000 && arr[cur*2] ==0) {
				queue.offer(cur*2);
				arr[cur*2] = arr[cur] + 1;
			}
		}
	}
}
