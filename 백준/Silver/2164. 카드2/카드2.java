import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        
        Queue<Integer> queue = new LinkedList<>();

        // 1. 큐에 카드 넣기 (1부터 N까지)
        for (int i = 1; i <= n; i++) {
            queue.add(i);
        }

        while (queue.size() > 1) {
            queue.poll(); 
            if (queue.size() == 1) { // 버린 후에 한 장 남으면 바로 종료
                break;
            }
            queue.add(queue.poll()); // 그 다음 맨 앞의 카드를 맨 뒤로 옮김
        }
        
        // 3. 마지막 남은 카드 출력
        System.out.println(queue.poll());
    }
}