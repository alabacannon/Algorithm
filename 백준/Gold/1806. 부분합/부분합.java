import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Main {
	public static void main(String[] args) throws IOException {
//		BufferedReader br = new BufferedReader(new FileReader("data/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int s = Integer.parseInt(st.nextToken());
		int[] arr = new int[n+1];
		st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= n; i++) {
			 arr[i] = Integer.parseInt(st.nextToken());
		}
		int left = 1;
		int right = 1;
		int ans = n+1;
		int sum = 0;
		
		
		while (right<=n) {
			sum += arr[right];
			while (sum >= s) {
				ans = Math.min(ans, right-left+1);
				sum-= arr[left];
				left++;
			}
			right++;
		}
		if (ans == n+1) {
			System.out.println(0);
		} else {
			System.out.println(ans);
		}
		
		br.close();
	}
}
			
