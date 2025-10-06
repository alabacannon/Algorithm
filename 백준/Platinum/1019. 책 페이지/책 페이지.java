import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String N_str = br.readLine();
        int n = Integer.parseInt(N_str);
        long[] result = new long[10];

        // i: 현재 처리 중인 자릿수 (0: 일의 자리, 1: 십의 자리, ...)
        for (int i = 0; i < N_str.length(); i++) {
            int point = (int) Math.pow(10, i); // 현재 자릿값 (1, 10, 100...)
            int currentDigit = (n / point) % 10; // 현재 자릿수의 숫자
            
            // 1. 현재 자릿수보다 "앞"에 있는 부분 (예: 54359에서 543)
            int prefix = n / (point * 10);
            
            // 2. 현재 자릿수보다 "뒤"에 있는 부분 (예: 54359에서 일의 자리를 볼 때 suffix는 없음, 십의 자리를 볼 때 suffix는 9)
            int suffix = n % point;

            // [로직] 1부터 (prefix-1)까지의 블록 계산 (예: 54359 -> 0xxxx ~ 4xxxx 블록)
            // 0~9까지 모든 숫자가 prefix번, point만큼 등장
            for (int j = 0; j < 10; j++) {
                result[j] += (long)prefix * point;
            }

            // [로직] prefix와 동일한 블록에서 currentDigit보다 작은 숫자들 계산 (예: 5xxxx 블록 -> 50xxx, 51xxx, 52xxx, 53xxx)
            for (int j = 0; j < currentDigit; j++) {
                result[j] += point;
            }

            // [로직] prefix와 동일한 블록에서 currentDigit과 같은 숫자 계산 (예: 54xxx 블록 -> 54000 ~ 54359)
            result[currentDigit] += suffix + 1;
        }

        // 맨 앞자리가 0인 경우는 없으므로, 과하게 계산된 0의 개수를 빼줌
        int point = 1;
        for (int i = 0; i < N_str.length(); i++) {
            result[0] -= point;
            point *= 10;
        }

        // 결과 출력
        StringBuilder sb = new StringBuilder();
        for (long val : result) {
            sb.append(val).append(" ");
        }
        System.out.println(sb.toString().trim());
    }
}