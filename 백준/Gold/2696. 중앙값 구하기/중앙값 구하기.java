import java.io.FileInputStream;
import java.io.IOException;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) throws IOException {
		//System.setIn(new FileInputStream("data/input.txt"));
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		for (int test_case = 0; test_case < t; test_case++) {
			int m = sc.nextInt();
			System.out.println(m/2 + 1);
			PriorityQueue<Integer> pqMin = new PriorityQueue<>();
			PriorityQueue<Integer> pqMax = new PriorityQueue<>(Collections.reverseOrder());
			int num = sc.nextInt();
			int curMid = num;
			pqMax.offer(num);
			System.out.print(num + " ");
			int count = 1;
			for (int i = 2; i <= m; i++) {
				
				num = sc.nextInt();
				if (curMid > num) {
					pqMax.offer(num);
				} else {
					pqMin.offer(num);
				}
				if (pqMax.size()<pqMin.size()) {
					pqMax.offer(pqMin.poll());
				}
				if (pqMax.size()>pqMin.size()+1) {
					pqMin.offer(pqMax.poll());
				}
//				System.out.println("MAX : " + pqMax);
//				System.out.println("MIN : " + pqMin);
				if (i%2 == 1) {
					curMid = pqMax.peek();
					System.out.print(curMid + " ");
					count ++;
				}
				
				if (count == 10) {
					System.out.println();
					count = 0;
				}
			}
			System.out.println();
		}
	}
}