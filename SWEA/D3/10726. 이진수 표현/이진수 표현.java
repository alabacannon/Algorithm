import java.io.FileInputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) throws IOException {
		//System.setIn(new FileInputStream("data/input.txt"));
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		outer : for (int test_case = 1; test_case <= t; test_case++) {
			int n = sc.nextInt();
			int m = sc.nextInt();
			for (int i = 0; i < n; i++) {
				if (((m>>i)& 1) == 0) {
					System.out.println("#" + test_case+ " OFF");
					continue outer;
				}
			}
			System.out.println("#" + test_case+ " ON");
			
		}
		
	}
}
