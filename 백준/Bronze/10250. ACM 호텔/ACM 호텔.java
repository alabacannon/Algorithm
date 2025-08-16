import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) throws IOException {
//		System.setIn(new FileInputStream("data/input.txt"));
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		for (int test = 0; test < t; test++) {
			int h = sc.nextInt(); // 층
			int w = sc.nextInt(); // 호수
			int n = sc.nextInt()-1; // 손님 번호
			int height = n%h + 1;
			int roomNum = n/h + 1;
			String roomNumSt;
			if (roomNum < 10) {
				roomNumSt = "0" + Integer.toString(roomNum);
			} else {
				roomNumSt = Integer.toString(roomNum);
			}
			System.out.println(height + "" + roomNumSt);
		}
	}
}