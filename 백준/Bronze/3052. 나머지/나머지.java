import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) throws IOException {
//		System.setIn(new FileInputStream("data/input.txt"));
		Scanner sc = new Scanner(System.in);
		int n = 10;
		int count = 0;
		ArrayList<Integer> arr = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			int temp = sc.nextInt()%42;
			if (arr.stream()
					.filter(a -> a == temp)
					.findAny()
					.orElse(-1)
					== -1) {
				arr.add(temp);
				count++;
			}
		}
		System.out.println(count);
	}
}
