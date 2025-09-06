import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) throws IOException {
		//System.setIn(new FileInputStream("data/input.txt"));
		Scanner sc = new Scanner(System.in);
		long x1 = sc.nextLong();
		long y1 = sc.nextLong();
		long x2 = sc.nextLong();
		long y2 = sc.nextLong();
		long x3 = sc.nextLong();
		long y3 = sc.nextLong();
		long x4 = sc.nextLong();
		long y4 = sc.nextLong();
		
		int result1 = outerProd(x1,y1,x2,y2,x3,y3);
		int result2 = outerProd(x1,y1,x2,y2,x4,y4);
		int result3 = outerProd(x3,y3,x4,y4,x1,y1);
		int result4 = outerProd(x3,y3,x4,y4,x2,y2);
		
		if (result1 == 0 && result2 == 0 && result3 == 0 && result4 == 0) {
			long minX1 = Math.min(x1, x2);
		    long maxX1 = Math.max(x1, x2);
		    long minY1 = Math.min(y1, y2);
		    long maxY1 = Math.max(y1, y2);

		    long minX2 = Math.min(x3, x4);
		    long maxX2 = Math.max(x3, x4);
		    long minY2 = Math.min(y3, y4);
		    long maxY2 = Math.max(y3, y4);

		    if (maxX1 < minX2 || maxX2 < minX1 || maxY1 < minY2 || maxY2 < minY1) {
		        System.out.println(0); 
		    } else {
		        System.out.println(1);
		    }
		    return;
		}
		
		if (result1 * result2 <= 0 && result3 * result4 <= 0) {
			System.out.println(1);
		} else {
			System.out.println(0);
		}
	}

	private static int outerProd(long x1, long y1, long x2, long y2, long alpha, long beta) {
		long temp = (x2 - x1) * (beta - y1) - (y2 - y1) * (alpha - x1);
        if (temp > 0) return 1;
        else if (temp < 0) return -1;
        else return 0;
	}
}
