import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int x1 = sc.nextInt(), y1 = sc.nextInt(), r1 = sc.nextInt();
		int x2 = sc.nextInt(), y2 = sc.nextInt(), r2 = sc.nextInt();
		
		if (Math.hypot(x2-x1, y2-y1) < (r1+r2)) {
			System.out.println("YES");
		}else {
			System.out.println("NO");
		}
		
	}
}