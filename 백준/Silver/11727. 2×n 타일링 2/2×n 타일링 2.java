import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;
import java.util.ArrayList;
public class Main {
	
	public static void main(String[] args) throws IOException {
//		System.setIn(new FileInputStream("data/input.txt"));
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		ArrayList<Integer> dp = new ArrayList<>(1001);
		dp.add(0);
		dp.add(1);
		dp.add(3);
		for (int i = 3; i <= n; i++) {
			dp.add((dp.get(i-1) + dp.get(i-2) * 2)%10007);
		}
		
		System.out.println(dp.get(n));
		
		
	}
	
}
