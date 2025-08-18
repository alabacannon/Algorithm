import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		long a = sc.nextLong();
		long b = sc.nextLong();
		long c = sc.nextLong();
		
		long ans = divideConquer(a,b,c);
		System.out.println(ans);
	}

	private static long divideConquer(long a, long b, long c) {
		if (b==1) {
			return a%c;
		}
		long temp = divideConquer(a, b/2, c);
		long result = (temp * temp)%c;
		if (b%2 == 1) {
			result = (result *a)%c;
		}
		
		return result;
		
	}
	
}