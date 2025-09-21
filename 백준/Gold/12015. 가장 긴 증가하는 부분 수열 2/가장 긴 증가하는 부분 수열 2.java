import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
//		BufferedReader br = new BufferedReader(new FileReader("data/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int n = Integer.parseInt(br.readLine());
		ArrayList<Integer> tails = new ArrayList<>();
		st = new StringTokenizer(br.readLine());
		tails.add(Integer.parseInt(st.nextToken()));
		for (int i = 1; i < n; i++) {
			int num = Integer.parseInt(st.nextToken());
			if (num > tails.get(tails.size()-1)) {
				tails.add(num);
				continue;
			}
			int idx = Collections.binarySearch(tails, num);
			if (idx < 0) {
				tails.set(-idx-1, num);
			}
		}
		System.out.println(tails.size());
		br.close();
	}
}