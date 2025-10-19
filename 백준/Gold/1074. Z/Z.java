import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;


public class Main {
	
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int r = sc.nextInt();
		int c = sc.nextInt();
		int ans = 0;
		int idx1 = 1;
		int idx2 = 0;
		while(r>=1) {
			ans += r%2 * (int) Math.pow(2, idx1*2 -1);
			r/=2;
			idx1++;
		}
		
		while(c>=1) {
			ans += c%2 * (int) Math.pow(2, idx2*2);
			c/=2;
			idx2++;
		}
		System.out.println(ans);
	}
}


/*
0 01 100 101 10000 
10
1000
1010

*/
