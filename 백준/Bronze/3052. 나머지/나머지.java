import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
//        System.setIn(new FileInputStream("data/input.txt"));
        Scanner sc = new Scanner(System.in);
        int n = 10;
        ArrayList<Integer> arr = new ArrayList<>();
        
        for (int i = 0; i < n; i++) {
            int temp = sc.nextInt() % 42;
            
            // ArrayList에 포함되어 있지 않은 경우에만 추가
            if (!arr.contains(temp)) {
                arr.add(temp);
            }
        }
        
        // 최종적으로 리스트에 담긴 요소의 개수(고유한 값의 개수)를 출력
        System.out.println(arr.size());
    }
}