import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.HashMap;
import java.util.Scanner;

public class Main {
	static int[][] map;
	static int n;
	static int direction; // 0,1,2,3 -> 우 하 좌 상
	static int[] head;
	static Deque<int[]> body;
	static HashMap<Integer, Character> action;
	
	public static void main(String[] args) throws IOException {
//		System.setIn(new FileInputStream("data/input.txt"));
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		map = new int[n][n];
		
		int k = sc.nextInt();
		for (int i = 0; i < k; i++) {
			int x = sc.nextInt()-1;
			int y = sc.nextInt()-1;
			map[x][y] = 1;
		}
		int l = sc.nextInt();
		action = new HashMap<>(100);
		
		for (int i = 0; i < l; i++) {
			action.put(sc.nextInt(), sc.next().charAt(0));
		}
		snakeGame();
	}
	
	static void snakeGame() {
		int time = 0;
		direction = 0;
		head = new int[] {0,0}; 
		body = new ArrayDeque<>();
		int[] dx = {0,1,0,-1};
		int[] dy = {1,0,-1,0};
		while(true) {
			time ++ ;
			body.offer(head);
			int nx = head[0] + dx[direction]; 
			int ny = head[1] + dy[direction];
			head = new int[] {nx,ny};

			// 1. 게임 종료 여부 확인
			if (gameOver(nx,ny)) {
				break;
			}
			// 2. 사과를 먹었는지 여부 확인
			if (map[nx][ny] == 0) {
				body.poll();
			} else {
				map[nx][ny] = 0;
			}
			
			// 3. 방향을 바꾸는지 여부 확인
			if (action.containsKey(time)) {
				changeDirection(action.get(time));
			}
		}
		
		System.out.println(time);
		
	}
	
	static void changeDirection(char rotation){
		if (rotation == 'L') {
			direction = direction == 0 ? 3 : direction-1 ;
		} else {
			direction = direction == 3 ? 0 : direction+1 ;
		}
	}

	static boolean gameOver(int nx, int ny) {
		for (int[] element : body) {
			if (element[0] == nx && element[1] == ny) {
				return true;
			}
		}
		
		return nx <0 || nx >=n || ny <0 || ny >=n;
	}
}