import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
 
public class Solution {
	static int h,w, tankX, tankY, tankDirection;
	static char[][] map;
	static char[] action;
	static int[] dx = {0,1,0,-1}; // 우 하 좌 상
	static int[] dy = {1,0,-1,0};
	static char[] dir = {'>','v','<','^'};
	static char[] movement = {'R','D','L','U'};
	public static void main(String[] args) throws IOException {
//		BufferedReader br = new BufferedReader(new FileReader("data/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		int t = Integer.parseInt(br.readLine());
		for (int test_case = 1; test_case <= t; test_case++) {
			st = new StringTokenizer(br.readLine());
			h = Integer.parseInt(st.nextToken());
			w = Integer.parseInt(st.nextToken());
			map = new char[h][w];
			for (int i = 0; i < h; i++) {
				map[i] = br.readLine().toCharArray();
				for (int j = 0; j < w; j++) {
					if (isTank(map[i][j])) {
						tankX = i;
						tankY = j;
						tankDirection = 0;
						for (int d = 0; d < 4; d++) {
							if (dir[d] == map[i][j]) {
								tankDirection = d; 
							}
						}
					}
				}
			}
			int n = Integer.parseInt(br.readLine());
			action = br.readLine().toCharArray();
			for (char act : action) {
				if (act == 'S') {
					shoot();
				} else {
					move(act);
				}
			}
			sb.append("#").append(test_case).append(" ");
			for (int i = 0; i < h; i++) {
				for (int j = 0; j < w; j++) {
					sb.append(map[i][j]);
				}
				sb.append("\n");
			}
		}
		System.out.println(sb);
		
		br.close();
	}
	private static void shoot() {
		int booletX = tankX + dx[tankDirection];
		int booletY = tankY + dy[tankDirection];
		while (!outOfMap(booletX, booletY)) {
			switch (map[booletX][booletY]) {
			case '*':
				map[booletX][booletY] = '.';
				return;
			case '#':
				return;
			default:
				break;
			}
			booletX += dx[tankDirection];
			booletY += dy[tankDirection];
		}
	}
	
	private static void move(char act) {
		int d = 0;
		for (int i = 0; i < 4; i++) {
			if (act == movement[i]) {
				d = i;
			}
		}
		tankDirection = d;
		map[tankX][tankY] = dir[d]; 
		
		int nx = tankX  + dx[d];
		int ny = tankY  + dy[d];
		if (!outOfMap(nx,ny) && map[nx][ny] == '.') {
			map[nx][ny] = map[tankX][tankY];
			map[tankX][tankY] = '.';
			tankX = nx;
			tankY = ny;
		}
	}
	private static boolean isTank(char c) {
		return c == '<' || c == '>' || c == 'v' || c == '^';
	}
	private static boolean outOfMap(int nx, int ny) {
		return nx >= h || nx<0 || ny >= w || ny<0;
	}
}