import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	static int[][] line;
	static List<int[]> tails;
    public static void main(String[] args) throws IOException {
//	   	BufferedReader br = new BufferedReader(new FileReader("data/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
   		StringTokenizer st;
   		int n = Integer.parseInt(br.readLine());
   		line = new int[n][3];
   		tails = new LinkedList<>();
   		for (int i = 0; i < n; i++) {
   			st = new StringTokenizer(br.readLine());
   			line[i][0] = Integer.parseInt(st.nextToken());
   			line[i][1] = Integer.parseInt(st.nextToken());
   			line[i][2] = 1;
		}
   		Arrays.sort(line, (o1,o2) -> o1[0] - o2[0]);
   		tails.add(line[0]);
   		for (int i = 1; i < n; i++) {
   			int num = line[i][1];
			if (num > tails.get(tails.size()-1)[1]) {
				line[i][2] = tails.get(tails.size()-1)[2]+1;
				tails.add(line[i]);
				continue;
			}
			int idx = Collections.binarySearch(tails, line[i], (o1,o2) -> o1[1]-o2[1]);
			if (idx < 0) {
				if (idx!=-1) {
					line[i][2] = tails.get(-idx-2)[2]+1;
				}
				tails.set(-idx-1, line[i]);
			} 
		}
//   		for (int i = 0; i < tails.size(); i++) {
//   			System.out.println(Arrays.toString(tails.get(i)) );
//		}
//   		System.out.println();
//   		for (int i = 0; i < n; i++) {
//   			System.out.println(Arrays.toString(line[i]) );
//   		}
   		int curIdx = tails.size();
   		StringBuilder sb = new StringBuilder();
   		System.out.println(n-curIdx);
   		for (int i = n-1; i >= 0; i--) {
   			if (line[i][2] == curIdx) {
				curIdx--;
			} else {
				sb.insert(0, "\n").insert(0,line[i][0]);
			}
		}
   		System.out.println(sb);
   		br.close();
    }
}
