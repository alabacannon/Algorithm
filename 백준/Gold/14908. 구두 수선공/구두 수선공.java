import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main {
	
	static class Task implements Comparable<Task>{
		int t;
		int s;
		int no;
		public Task(int t, int s, int no) {
			this.t = t;
			this.s = s;
			this.no = no;
		}
		@Override
		public int compareTo(Task o) {
			int myCost = o.t * s;
			int compCost = t * o.s;
			if (myCost != compCost) {
				return compCost - myCost;
			}
			return no-o.no;
		}
	}
	static ArrayList<Task> list;
	static int totalDailyCost;
	public static void main(String[] args) throws IOException {
		//System.setIn(new FileInputStream("data/input.txt"));
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		list = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			int t = sc.nextInt();
			int s = sc.nextInt();
			totalDailyCost += s;
			list.add(new Task(t,s,i+1)); 
		}
		Collections.sort(list);
		for (Task t : list) {
			System.out.print(t.no + " ");
		}
	}
	
}