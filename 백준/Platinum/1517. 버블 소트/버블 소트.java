import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int n ;
	static long ans;
	static int[] arr, sorted;
	static int[][] tree;
	public static void main(String[] args) throws IOException {
//		BufferedReader br = new BufferedReader(new FileReader("data/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		n = Integer.parseInt(br.readLine());
		arr = new int[n+1];
		sorted = new int[n+1];
		st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		mergeSort(1,n);
		System.out.println(ans);
	}
	private static void mergeSort(int start, int end) {
		if (start == end) {
			return;
		}
		int mid = (start + end)/2;
		mergeSort(start, mid);
		mergeSort(mid+1,end);
		merge(start,mid,end);
	}
	private static void merge(int start, int mid, int end) {
		int left = start;
		int right = mid+1;
		int idx = start;
		while (left <= mid && right <= end) {
			if (arr[left] <= arr[right]) {
				sorted[idx++] = arr[left++];
			} else {
				sorted[idx++] = arr[right++];
				ans+=mid+1-left;
			}
		}
		if (left > mid) {
			while (right <= end) {
				sorted[idx++] = arr[right++];
			}
		}else {
			while (left <= mid) {
				sorted[idx++] = arr[left++];
			}
		}
		
		for (int i = start; i <= end; i++) {
			arr[i] = sorted[i];
		}
		
	}
	
	
}