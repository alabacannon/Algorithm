import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		int[] arr = new int[N];
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		} // 입력완료!!
		
		Arrays.sort(arr);
		int low = 0;
		int high = arr[arr.length - 1] - 1;
		while(low <= high) {
			
			long sum = 0;
			int mid = (low + high) / 2;
			
			for(int i = 0; i < N; i++) {
				if(arr[i]-mid > 0)
					sum += arr[i] - mid;
			}
			
			if(sum >= M) low = mid+1;
			else high = mid-1;
			
			
		}
		
		System.out.println(high);
	}
}
