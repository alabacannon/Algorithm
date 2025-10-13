import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main {
	static ArrayList<Integer> tail;
	static int[][] arr;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		arr = new int[n][2];
		tail = new ArrayList<>();
		int num = sc.nextInt();
		tail.add(num);
		arr[0][0] = num;
		arr[0][1] = 1;
		for (int i = 1; i < n; i++) {
			num = sc.nextInt();
			arr[i][0] = num;
			if (tail.get(tail.size()-1) < num) {
				tail.add(num);
				arr[i][1] = tail.size();
			} else {
				int idx = Collections.binarySearch(tail, num);
				if (idx < 0) {
					idx = -idx-1;
					tail.set(idx, num);
				}
				arr[i][1] = idx+1;
			}
		}
		int curIdx = tail.size();
		int[] result = new int[curIdx];
		for (int i = n-1; i >= 0; i--) {
			if (curIdx == arr[i][1]) {
				result[curIdx-1] = arr[i][0];
				curIdx--;
			}
		}
		
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < result.length; i++) {
			sb.append(result[i]).append(" ");
		}
		System.out.println(result.length);
		System.out.println(sb);
		
	}
}