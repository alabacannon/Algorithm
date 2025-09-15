import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;
 
public class Solution {
	static final int[] coins = {50000,10000,5000,1000,500,100,50,10};
	public static void main(String[] args) throws IOException {
		//System.setIn(new FileInputStream("data/input.txt"));
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		for (int test_case = 1; test_case <= t; test_case++) {
			int n = sc.nextInt();
			int[] count = new int[8];
			for (int i = 0; i < 8; i++) {
				int coin = coins[i];
				count[i] = n / coin;
				n = n%coin; 
			}
			System.out.println("#" + test_case);
			for (int i = 0; i < 8; i++) {
				System.out.print(count[i] + " ");
			}
			System.out.println();
		}
	}
}