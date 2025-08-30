import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

public class Solution {
	static int n;
	static int[][] synergy ;
	static int min;
	static ArrayList<Integer> A = new ArrayList<>();
	static ArrayList<Integer> B = new ArrayList<>();
	static boolean[] visited;
	
	public static void main(String[] args) throws IOException {
//		BufferedReader br = new BufferedReader(new FileReader("data/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int t = Integer.parseInt(br.readLine());

		for (int test_case = 1; test_case <= t; test_case++) {
			A.clear();
			B.clear();
			min = Integer.MAX_VALUE;
			n = Integer.parseInt(br.readLine());
			synergy = new int[n][n];
			visited = new boolean[n];
			
			for (int i = 0; i < n; i++) {
				synergy[i] = Arrays.stream(br.readLine().split(" "))
								.mapToInt(Integer::parseInt).toArray();
			}
			combination(0,0);
			
			
			sb.append("#" + test_case + " " + min + "\n");
		}
		System.out.print(sb.toString());
		br.close();
	}
	private static void combination(int start, int count) {
        if (count == n/2) {
        	for (int i = 0; i < n; i++) {
        		if (visited[i]) {
        			A.add(i);
        		} else {
        			B.add(i);
        		}
			}
            updateMin();
            A.clear();
            B.clear();
            return;
        }
	    for (int i = start; i < n; i++) {
	        visited[i] = true;
	        combination(i + 1, count + 1);
	        visited[i] = false;
	        
	    }
	}
	private static void updateMin() {
		int diff =Math.abs(calculateTaste(A) - calculateTaste(B));
		min = Math.min(diff, min);
	}
	
	private static int calculateTaste(ArrayList<Integer> arr) {
		int result = 0;
		for (int i : arr) {
			for (int j : arr) {
				result += synergy[i][j];
			}
		}
		return result;
	}
}
