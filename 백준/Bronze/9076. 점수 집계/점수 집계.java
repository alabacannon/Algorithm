import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		sc.nextLine();
		for (int test = 0; test < t; test++) {
			int[] scores = Arrays.copyOfRange(
					Arrays.stream(sc.nextLine().split(" "))
					.mapToInt(Integer::parseInt)
					.sorted()
					.toArray()
					,1,4) ;
			if (scores[2] - scores[0] >= 4) {
				System.out.println("KIN");
			} else {
				System.out.println(Arrays.stream(scores).sum());
			}
		}
		
	}
}