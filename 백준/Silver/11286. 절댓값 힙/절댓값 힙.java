import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Main {
	public static void main(String[] args) throws IOException {
//		BufferedReader br = new BufferedReader(new FileReader("data/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int n = Integer.parseInt(br.readLine());
		PriorityQueue<Integer> heap = new PriorityQueue<>((o1,o2) -> {
			if (Math.abs(o1) != Math.abs(o2)) {
				return Math.abs(o1)- Math.abs(o2); 
			} else {
				return o1- o2;
			}
			
		});
		for (int i = 0; i < n; i++) {
			int num = Integer.parseInt(br.readLine());
			if (num == 0) {
				if (heap.isEmpty()) {
					System.out.println(0);
				} else {
					System.out.println(heap.poll());
				}
			} else {
				heap.offer(num);
			}
		}
		br.close();
	}
}
