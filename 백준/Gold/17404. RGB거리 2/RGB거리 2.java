import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] costs = new int[n][3];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            costs[i][0] = Integer.parseInt(st.nextToken());
            costs[i][1] = Integer.parseInt(st.nextToken());
            costs[i][2] = Integer.parseInt(st.nextToken());
        }

        int minCost = Integer.MAX_VALUE;

        // 첫 번째 집의 색상을 R, G, B로 각각 고정하고 계산
        for (int firstColor = 0; firstColor < 3; firstColor++) {
            int[][] dp = new int[n][3];

            // 첫 번째 집 초기화
            for (int j = 0; j < 3; j++) {
                if (j == firstColor) {
                    dp[0][j] = costs[0][j];
                } else {
                    dp[0][j] = 1000 * 1000 + 1; // 충분히 큰 값으로 설정
                }
            }

            // 두 번째 집부터 마지막 집까지 DP 계산
            for (int i = 1; i < n; i++) {
                dp[i][0] = Math.min(dp[i - 1][1], dp[i - 1][2]) + costs[i][0];
                dp[i][1] = Math.min(dp[i - 1][0], dp[i - 1][2]) + costs[i][1];
                dp[i][2] = Math.min(dp[i - 1][0], dp[i - 1][1]) + costs[i][2];
            }

            // 마지막 집의 색상이 첫 번째 집의 색상과 다를 때만 고려
            for (int lastColor = 0; lastColor < 3; lastColor++) {
                if (lastColor != firstColor) {
                    minCost = Math.min(minCost, dp[n - 1][lastColor]);
                }
            }
        }
        System.out.println(minCost);
        br.close();
    }
}