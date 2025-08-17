import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		int b = sc.nextInt();
		int count = 1;
		while (b > a) {
			if (b%10 == 1) {
				b = (b-1)/10;
				count ++;
			} else if (b%2 == 0) {
				b /= 2;
				count ++;
			} else {
				System.out.println(-1);
				return;
			}
			if (b == a) {
				System.out.println(count);
				return;
			}
		}
		System.out.println(-1);
		
	}
}