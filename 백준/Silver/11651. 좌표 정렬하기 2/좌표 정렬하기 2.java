import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
public class Main {
	
	public static void main(String[] args) throws IOException{
		
//		BufferedReader br = new BufferedReader(new FileReader("data/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
//		StringTokenizer st;
		int n = Integer.parseInt( br.readLine());
		ArrayList<int[]> arr = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			arr.add(Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray());
		}
		
		Collections.sort(arr,(o1,o2) -> {
			if (o1[1] > o2[1]) {
				return 1;
			} else if (o1[1] < o2[1]) {
				return -1;
			} else if (o1[0] > o2[0]) {
				return 1;
			} else if (o1[0] < o2[0]) {
				return -1;
			} else {
				return 0;
			}
		});
		for (int[] e : arr) {
			bw.write(Integer.toString(e[0]) + " ");
			
			bw.write(Integer.toString(e[1]));
			bw.write("\n");
		}
		bw.close();
	}
	
}
