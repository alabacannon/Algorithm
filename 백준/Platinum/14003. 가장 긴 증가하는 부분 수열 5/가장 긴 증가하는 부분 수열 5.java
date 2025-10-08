import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
//		BufferedReader br = new BufferedReader(new FileReader("data/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int n = Integer.parseInt(br.readLine());

		st = new StringTokenizer(br.readLine());
		
		int[][] arr = new int[n][2];
		ArrayList<Integer> tail = new ArrayList<>();
		int num = Integer.parseInt(st.nextToken());
		tail.add(num);
		arr[0][0] = num;
		for (int i = 0; i < arr.length; i++) {
			arr[i][1] = 1;
		}
		for (int i = 1; i < n; i++) {
			num = Integer.parseInt(st.nextToken());
			arr[i][0] = num; 
			
			if (num > tail.get(tail.size()-1)) {
				tail.add(num);
				arr[i][1] = tail.size();
				continue;
			}
			int idx = Collections.binarySearch(tail,num);
			int position;
			if (idx < 0) {
				position = -idx-1;
				tail.set(position, num);
			} else {
				position = idx;
			}
			arr[i][1] = position+1;
		}
		System.out.println(tail.size());
		StringBuilder sb = new StringBuilder();
		ArrayList<Integer> result = new ArrayList<>();
		int curIdx = tail.size();
		for (int i = n-1; i >= 0; i--) {
			if (arr[i][1] == curIdx) {
				result.add(arr[i][0]);
				curIdx--;
			}
		}
		Collections.reverse(result);
		for (int i : result) {
			sb.append(i).append(" ");
		}
		System.out.println(sb);
		
		br.close();
	}
	
}