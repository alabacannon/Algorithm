import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main {

    // 간선 정보를 담을 클래스
    static class Edge {
        int start;
        int end;
        int weight;

        Edge(int start, int end, int weight) {
            this.start = start;
            this.end = end;
            this.weight = weight;
        }
    }

    // **수정**: INF를 long 타입으로 변경하여 오버플로우 방지
    static final long INF = 500L * 60000L + 1L; 

    public static void main(String[] args) throws IOException {
        // System.setIn(new FileInputStream("data/input.txt")); // 파일 입력 주석 처리
        Scanner sc = new Scanner(System.in);

        int tc = sc.nextInt();
        for (int test_case = 0; test_case < tc; test_case++) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            int w = sc.nextInt();

            ArrayList<Edge> edges = new ArrayList<>();

            // M개의 도로 (양방향)
            for (int i = 0; i < m; i++) {
                int s = sc.nextInt();
                int e = sc.nextInt();
                int t = sc.nextInt();
                edges.add(new Edge(s, e, t));
                edges.add(new Edge(e, s, t));
            }

            // W개의 웜홀 (단방향, 음수 가중치)
            for (int i = 0; i < w; i++) {
                int s = sc.nextInt();
                int e = sc.nextInt();
                int t = sc.nextInt();
                edges.add(new Edge(s, e, -t));
            }

            if (bellmanFord(n, edges)) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }
        sc.close();
    }

    public static boolean bellmanFord(int n, ArrayList<Edge> edges) {
        // **수정**: dist 배열을 long 타입으로 변경
        long[] dist = new long[n + 1]; 
        
        // **수정**: 모든 정점에서 사이클을 찾기 위해 모든 거리를 0으로 초기화 (가상의 시작점 효과)
        // dist[1] = 0; 대신 모든 정점을 0으로 초기화
        Arrays.fill(dist, 0); 

        // N번의 릴랙제이션 수행 (N-1번은 최단 거리 확정, N번째는 사이클 확인)
        for (int i = 1; i <= n; i++) {
            boolean updated = false;
            for (Edge edge : edges) {
                int u = edge.start;
                int v = edge.end;
                int weight = edge.weight;
                
                // dist[u]가 INF가 아니면 (즉, 도달 가능하면. 이 문제에서는 0으로 시작했으므로 INF 체크는 불필요하지만,
                // 안전을 위해 INF를 long MAX_VALUE에 가깝게 설정했다면 체크가 필요함)
                // dist[u] + weight 연산이 오버플로우 나지 않도록 long 타입으로 처리
                if (dist[v] > dist[u] + weight) {
                    dist[v] = dist[u] + weight;
                    updated = true;
                    
                    // N번째 릴랙제이션에서 갱신이 발생하면 음의 사이클 존재
                    if (i == n) {
                        return true;
                    }
                }
            }
            // N-1번 릴랙제이션 중에 갱신이 없으면 최적화로 종료
            if (i < n && !updated) {
                break;
            }
        }

        // 음의 사이클 없음
        return false;
    }
}