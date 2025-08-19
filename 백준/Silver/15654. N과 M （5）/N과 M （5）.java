import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
	static ArrayList<Integer> selectedArr = new ArrayList<>();
	public static void main(String[] args) throws IOException {
//		System.setIn(new FileInputStream("data/input.txt"));
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		int[] numberArr = new int[n];
		for (int i = 0; i < n; i++) {
			numberArr[i] = sc.nextInt();
		}
		
		Arrays.sort(numberArr);
		
		combination(numberArr,m,0);
		
	}

	private static void combination(int[] numberArr, int m, int start) {
		if (m == 0) {
			for (Integer item : selectedArr) {
				System.out.print(item + " ");
			}
			System.out.println();
			return;
		}
		
		for (int i = 0; i < numberArr.length; i++) {
			if (selectedArr.contains(numberArr[i])) {
				continue;
			}
			selectedArr.add(numberArr[i]);
			combination(numberArr, m-1, i);
			selectedArr.remove(selectedArr.size()-1);
		}
		
	}
}