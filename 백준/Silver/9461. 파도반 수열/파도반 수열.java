import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) throws IOException {
		//System.setIn(new FileInputStream("data/input.txt"));
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		long[] p = new long[101];
		p[1] = 1; 
		p[2] = 1; 
		p[3] = 1; 
		p[4] = 2;
		p[5] = 2;
		p[6] = 3;
		p[7] = 4;
		p[8] = 5;
		p[9] = 7;
		p[10] = 9;
		for (int i = 11; i <= 100; i++) {
			p[i] = p[i-1] + p[i-5];
		}
		
		for (int test = 0; test < t; test++) {
			System.out.println(p[sc.nextInt()]);
		}
	}

}
