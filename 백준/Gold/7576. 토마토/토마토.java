import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.stream.IntStream;

public class Main {
	static int[][] boxes;
	static int n;
	static int m;
	static Deque<int[]> queue = new ArrayDeque<>();

	public static void main(String[] args) throws IOException {
//		BufferedReader br = new BufferedReader(new FileReader("data/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int[] nm = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		m = nm[0];
		n = nm[1];
		boxes = new int[n][m];
		for (int i = 0; i < n; i++) {
			boxes[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		}
		
		IntStream.range(0, n).forEach(i -> IntStream.range(0, m)
                             .filter(j -> boxes[i][j] == 1)
                             .forEach(j -> queue.offerLast(new int[]{i, j})));

		bfs();

		int maxDay = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (boxes[i][j] == 0) {
                    System.out.println(-1); // 익지 않은 토마토가 남아있는 경우
                    return;
                }
                maxDay = Math.max(maxDay, boxes[i][j]);
            }
        }
		
		
		System.out.println(maxDay-1);
		br.close();
		bw.close();
	}

	public static void bfs() {
		int[] dx = { -1, 1, 0, 0 };
		int[] dy = { 0, 0, -1, 1 };
		while (!queue.isEmpty()) {
			int[] node = queue.pollFirst();
			int currentX = node[0];
			int currentY = node[1];
			
			for (int d = 0; d < 4; d++) {
				int nx = currentX + dx[d];
				int ny = currentY + dy[d];
				if (isOutOfMap(nx, ny)) {
					continue;
				}
				if (boxes[nx][ny] == 0) {
					boxes[nx][ny] = boxes[currentX][currentY] + 1;
					queue.offerLast(new int[] { nx, ny });
				}
			}

		}
	}

	private static boolean isOutOfMap(int nx, int ny) {
		return nx < 0 || nx >= n || ny < 0 || ny >= m;
	}
}