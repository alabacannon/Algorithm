import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	static int direction = 0;
	static int headX = 0;
	static int headY = 0;
	static HashMap<Integer, Integer> directionChangeMap = new HashMap<>();
	// R,D,L,U
	static int[] dx = {0,1,0,-1};
	static int[] dy = {1,0,-1,0};
	static int[][] applePosition;
	static boolean gameover = false; 
	static int n;
	static Queue<int[]> snakePosition = new ArrayDeque<>();	
	static boolean snakeSizeOver1 = false;
	
	public static void main(String[] args) throws IOException {
		
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		int k = sc.nextInt();
		applePosition = new int[n][n];
		for (int i = 0; i < k; i++) {
			applePosition[sc.nextInt()-1][sc.nextInt()-1] = 1;
		}
		
		int l = sc.nextInt();
		for (int i = 0; i < l; i++) {
			int key = sc.nextInt();
			String d = sc.next();
			switch(d) {
			case "D":
				directionChangeMap.put(key, 1); break;
			case "L":
				directionChangeMap.put(key, -1); break;
			default :
				continue;
			}
			
		}
		// 프로그램 시작
		int time = 0;
		snakePosition.offer(new int[] {headX,headY});
		while(true) {
			time ++;
			move();
			directionControl(time);
			if (gameover) {
				break;
			}
		}
		System.out.println(time);
	}
	
	
	private static void move() {
		headX += dx[direction];
		headY += dy[direction];
		if (!(headX<n && headX>=0 && headY<n && headY>=0)) {
			gameover = true;
			return;
			
		}
		if (snakeSizeOver1 && isSnakeMeetSnake()) {
			gameover = true;
			return;
		}
		
		
		if(!(isSnakeMeetApple())) {
			snakePosition.offer(new int[] {headX,headY});
			snakePosition.poll();
		} else {
			snakeSizeOver1 = true;
			snakePosition.offer(new int[] {headX,headY});
		}
		
		
	}


	public static boolean isSnakeMeetApple() {

		if (applePosition[headX][headY]== 0) {
			return false;
		}
		applePosition[headX][headY] = 0;
		return true;
	}
	
	
	public static void directionControl(int time) {
		if(directionChangeMap.containsKey(time)){
			direction += directionChangeMap.get(time);
			if (direction == -1) {
				direction = 3;
			}
			if (direction == 4) {
				direction = 0;
			} 
		}
		
	}
	
	public static boolean isSnakeMeetSnake() {

		for (int[] body : snakePosition) {
			if(headX == body[0] && headY == body[1]) {
				return true;
			}
		}
		return false;
	}
	
	
}
