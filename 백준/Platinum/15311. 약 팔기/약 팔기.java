import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Deque;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) throws IOException {
		//System.setIn(new FileInputStream("data/input.txt"));
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		Deque<Integer> deque = new ArrayDeque<>();
		// 작은 제곱수 중 가장 큰거의 제곱근  + 1해주는게 기준수임
		int x = (int) Math.floor(Math.sqrt(n));
		int k;
		//  + 1 해줘야 하는지? -> x진법 기준으로 판단
		boolean isCenter = false;
		if (n > x*x +x) {
			k = 2 * x;
		} else if(n == x*x +x){
			k = 2 * x -1;
			isCenter = true;
		} else {
			k = 2 * x - 1;
		}
		// x진법에서 제일 큰자리수가 x-1로 바뀔떄는 x+1이 중간에 들어가게됨 -> 예외처리 필요
		System.out.println(k);
		System.out.print("1 ".repeat(x-1));
		if (isCenter) {
			System.out.print(x+1 + " ");
			for (int i = 0; i < x-1; i++) {
				System.out.print(x + " ");
			}
		} else {
			for (int i = 0; i < x; i++) {
				System.out.print(x + " ");
			}
		}
	}
}