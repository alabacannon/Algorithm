import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Scanner;


public class Main {
	
	static ArrayList<ArrayList<Integer>> list;
	public static void main(String[] args) throws IOException {
		//System.setIn(new FileInputStream("data/input.txt"));
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		list = new ArrayList<>();
		PriorityQueue<Integer> heap = new PriorityQueue<>((o1,o2) -> Integer.compare(o2, o1));
		int maxDay = 0;
		for (int i = 0; i <= 1000; i++) {
			list.add(new ArrayList<>());
		}
		for (int i = 0; i < n; i++) {
			int dueDay = sc.nextInt();
			int score = sc.nextInt();
			maxDay = Math.max(dueDay, maxDay);
			list.get(dueDay).add(score);
		}
		int curDay = maxDay;
		int ans = 0;
		while (curDay > 0) {
			for (int score : list.get(curDay)) {
				heap.offer(score);
			}
			if (!heap.isEmpty()) {
				ans += heap.poll();
			}
			curDay--;
		}
		System.out.println(ans);
	}
}
			