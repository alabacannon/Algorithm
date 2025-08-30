import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

public class Main {
	static int n;
	static int m;
	static int[] nums;
	static LinkedHashSet<Integer> set = new LinkedHashSet<>();
	static StringBuilder sb = new StringBuilder();
	static ArrayList<Integer> arr;
	public static void main(String[] args) throws IOException {
		//System.setIn(new FileInputStream("data/input.txt"));
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		nums = new int[m];
		for (int i = 0; i < n; i++) {
			set.add(sc.nextInt());
		}
		arr = new ArrayList<>(set);
		Collections.sort(arr);
		permutaion(0,0);
				
		System.out.print(sb.toString());
	}
	private static void permutaion(int start, int count) {
		if (count == m) {
			for (int num : nums) {
				sb.append(num + " ");
			}
			sb.append("\n");
			return;
		}
		for (int i = start; i < arr.size(); i++) {
			nums[count] = arr.get(i);
			permutaion(i, count+1);
		}
	}
}
