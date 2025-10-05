import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {
		//System.setIn(new FileInputStream("data/input.txt"));
		Scanner sc = new Scanner(System.in);
		long min = sc.nextLong();
		long max = sc.nextLong();
		int maxSqrt = (int) Math.sqrt(max);
		int[] isnn = new int[(int) (max-min+1)];
		for (long i = 2; i <= Math.ceil(maxSqrt); i++) {
			long divide = i*i;
			long start = (long) Math.ceil((double)min/divide) * divide;
			for (long j = start; j <= max; j += divide) {
				isnn[(int)(j-min)] = 1;
			}
		}
		System.out.println(Arrays.stream(isnn).filter(c -> c==0).count());
		
	}
}