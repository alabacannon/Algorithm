import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	public static void main(String[] args) throws IOException {
//		BufferedReader br = new BufferedReader(new FileReader("data/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		int left = 0;
		int right = n-1;
		int sum = arr[left] + arr[right];
		int valueLeft = arr[left];
		int valueRight = arr[right];
		int ans = sum; 
		while (left < right) {
			sum = arr[left] + arr[right];
			if (Math.abs(ans) > Math.abs(sum)) {
				valueLeft = arr[left];
				valueRight = arr[right];
				ans = sum; 
			}
			
			if (sum == 0) break;
			if (sum < 0) left++;
			else right --;
		}
		System.out.println(valueLeft + " "+ valueRight);
		br.close();
	}
}
