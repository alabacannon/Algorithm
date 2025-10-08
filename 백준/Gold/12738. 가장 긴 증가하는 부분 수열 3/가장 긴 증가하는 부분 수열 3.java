import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		//System.setIn(new FileInputStream("data/input.txt"));
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		sc.nextLine();
		StringTokenizer st = new StringTokenizer(sc.nextLine());
		ArrayList<Integer> tail = new ArrayList<>();
		tail.add(Integer.parseInt(st.nextToken()));
		for (int i = 1; i < n; i++) {
			int num = Integer.parseInt(st.nextToken());
			if (num > tail.get(tail.size()-1)) {
				tail.add(num);
				continue;
			}
			int idx = Collections.binarySearch(tail, num);
			if (idx < 0) {
				tail.set(-idx-1, num);
			}
		}
		
		System.out.println(tail.size());
	}
}