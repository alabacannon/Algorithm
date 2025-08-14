import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Solution {
	public static void main(String[] args) throws IOException {
//		BufferedReader br = new BufferedReader(new FileReader("data/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int t = Integer.parseInt(br.readLine());

		for (int test_case = 1; test_case <= t; test_case++) {
			int n = Integer.parseInt(br.readLine());
			char[][] ground = new char[n][n];
			for (int i = 0; i < n; i++) {
				ground[i] = br.readLine().toCharArray();
			}
			int ans = 0;
			for (int i = 0; i < n; i++) {
				int startIdx = Math.abs(n/2-i);
				int length = n - startIdx*2;
				for (int j = startIdx; j < startIdx + length; j++) {
					ans += ground[i][j] - '0';
				}
			}
			
			System.out.println("#" + test_case + " " + ans);
		}

		br.close();
		bw.close();
	}
}
