import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
	static int[] preArr;
	static int[] inArr;
	static HashMap<Integer, Integer> inIndexMap;
	static int n;

	public static void main(String[] args) throws IOException {
//		BufferedReader br = new BufferedReader(new FileReader("data/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int t = Integer.parseInt(br.readLine());
		for (int tc = 0; tc < t; tc++) {
			n = Integer.parseInt(br.readLine());
			preArr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
			inArr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

			inIndexMap = new HashMap<>();
			for (int i = 0; i < n; i++) {
				inIndexMap.put(inArr[i], i);
			}

			find(0, n - 1, 0, n - 1);
			System.out.println();
		}
		br.close();
	}

	private static void find(int preStart, int preEnd, int inStart, int inEnd) {
		if (preStart > preEnd) {
			return;
		}
		int rootData = preArr[preStart];
		int rootInIndex = inIndexMap.get(rootData); 
		int leftSubtreeSize = rootInIndex - inStart; 
		find(preStart + 1, preStart + leftSubtreeSize, inStart, rootInIndex - 1);
		find(preStart + leftSubtreeSize + 1, preEnd, rootInIndex + 1, inEnd);
		System.out.print(rootData + " ");
	}
}