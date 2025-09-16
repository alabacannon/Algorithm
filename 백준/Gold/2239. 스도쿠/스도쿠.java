import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;


public class Main {
	static ArrayList<int[]> zero; 
	static int[][] map;
	static int zeroCount;
	static boolean flag;
	public static void main(String[] args) throws IOException {
		//System.setIn(new FileInputStream("data/input.txt"));
		Scanner sc = new Scanner(System.in);
		map = new int[9][9];
		zero = new ArrayList<>();
		for (int i = 0; i < 9; i++) {
			map[i] = sc.nextLine().chars().map(c ->c - '0').toArray();
			for (int j = 0; j < 9; j++) {
				if(map[i][j] == 0) {
					zero.add(new int[] {i,j}); 
				}
			}
		}
		zeroCount = zero.size();
		backTrack(0);
		
	}
	private static void backTrack(int cnt) {
		if (flag) {
			return;
		}
		if (cnt == zeroCount) {
			flag = true;
			for (int i = 0; i < 9; i++) {
				for (int j = 0; j < 9; j++) {
					System.out.print(map[i][j]);
				}
				System.out.println();
			}
			return;
		}
		for (int i = 1; i <= 9; i++) {
			if (isValid(cnt,i)) {
				backTrack(cnt+1);
				if (flag) {
					return;
				}
				map[zero.get(cnt)[0]][zero.get(cnt)[1]] = 0;
			}
			
		}
	}
	private static boolean isValid(int cnt, int num) {
		int x = zero.get(cnt)[0], y = zero.get(cnt)[1];
		map[x][y] = num;
		if (gridCheck(x,y) && rcCheck(x, y)) {
			return true;
		}
		map[x][y] = 0;
		return false;
	}
	private static boolean gridCheck(int x, int y) {
		int startX = (x / 3) * 3;
        int startY = (y / 3) * 3;
        int numToTest = map[x][y];
        for (int i = startX; i < startX + 3; i++) {
            for (int j = startY; j < startY + 3; j++) {
                if (i == x && j == y) continue;
                if (map[i][j] == numToTest) return false;
            }
        }
        
        return true;
	}
	private static boolean rcCheck(int x, int y) {
		for (int i = 0; i < 9; i++) {
			if (x != i && map[i][y] == map[x][y]) return false;
		}
		for (int i = 0; i < 9; i++) {
			if (y != i && map[x][i] == map[x][y]) return false; 
		}
		return true;
	}
	
}
			
