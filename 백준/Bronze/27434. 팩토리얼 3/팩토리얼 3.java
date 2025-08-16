import java.math.BigInteger;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.close();

        // 0! = 1 예외 처리
        if (n == 0) {
            System.out.println(1);
            return;
        }
        
        // divideAndConquer 메소드를 호출하여 1부터 n까지의 곱을 계산
        System.out.println(multiplyRange(1, n));
    }
    
    // 분할 정복을 수행하는 재귀 함수
    public static BigInteger multiplyRange(long start, long end) {
        // 기본 케이스 1: 시작과 끝이 같은 경우 (범위가 1개인 경우)
        if (start == end) {
            return BigInteger.valueOf(start);
        }
        
        // 기본 케이스 2: 시작이 끝보다 1 작은 경우 (범위가 2개인 경우)
        if (end - start == 1) {
            return BigInteger.valueOf(start).multiply(BigInteger.valueOf(end));
        }
        
        // 분할 정복: 범위를 두 부분으로 나눔
        long mid = (start + end) / 2;
        
        // 왼쪽 범위와 오른쪽 범위의 곱을 재귀적으로 계산
        return multiplyRange(start, mid).multiply(multiplyRange(mid + 1, end));
    }
}