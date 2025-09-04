import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
	static StringBuilder sb;
	static int count = 0;
	public static void main(String[] args) throws IOException {
//		System.setIn(new FileInputStream("data/input.txt"));
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		sb = new StringBuilder();
		honoi(n,1,2,3);
		System.out.println(count);
		System.out.println(sb);
	}

	private static void honoi(int n, int start, int mid, int end) {
		if (n == 1) {
			count ++;
			sb.append(start).append(" ").append(end).append("\n");
			return;
		}
		honoi(n-1,start,end,mid);
		honoi(1,start,mid,end);
		honoi(n-1,mid,start,end);
	}
}
