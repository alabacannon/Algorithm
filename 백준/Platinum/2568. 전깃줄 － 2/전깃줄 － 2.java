import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());

        // line[i][2] : i번째 전봇대를 마지막으로 하는 LIS의 길이를 저장
        int[][] line = new int[n][3];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            line[i][0] = Integer.parseInt(st.nextToken());
            line[i][1] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(line, (o1, o2) -> o1[0] - o2[0]);

        List<int[]> tails = new ArrayList<>();
        tails.add(line[0]);
        line[0][2] = 1; // 첫 번째 원소로 끝나는 LIS 길이는 1

        for (int i = 1; i < n; i++) {
            int num = line[i][1];
            
            // 1. tails의 마지막 값보다 크면 LIS가 길어지므로 추가
            if (num > tails.get(tails.size() - 1)[1]) {
                line[i][2] = tails.size() + 1; // LIS 길이 갱신
                tails.add(line[i]);
            } 
            // 2. 그렇지 않으면 tails 내 적절한 위치를 찾아 교체
            else {
                int idx = Collections.binarySearch(tails, line[i], (o1, o2) -> o1[1] - o2[1]);
                if (idx < 0) {
                    int insertionPoint = -idx - 1;
                    line[i][2] = insertionPoint + 1; // LIS 길이 갱신
                    tails.set(insertionPoint, line[i]);
                }
            }
        }

        int maxLen = tails.size();
        System.out.println(n - maxLen);

        // 역추적: 뒤에서부터 LIS에 포함되는 전봇대를 제외하고 나머지를 출력
        int currentLen = maxLen;
        StringBuilder sb = new StringBuilder();
        for (int i = n - 1; i >= 0; i--) {
            if (line[i][2] == currentLen) {
                currentLen--;
            } else {
                sb.insert(0, line[i][0] + "\n");
            }
        }
        System.out.print(sb);

        br.close();
    }
}