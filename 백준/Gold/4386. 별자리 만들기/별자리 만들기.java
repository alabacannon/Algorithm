import java.io.FileInputStream;
import java.io.IOException;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {
    static class Node implements Comparable<Node> {
        int vertex;
        double dist;

        public Node(int vertex, double dist) {
            this.vertex = vertex;
            this.dist = dist;
        }

        @Override
        public int compareTo(Node o) {
            return Double.compare(this.dist, o.dist);
        }
    }

    static double[][] stars;
    static int n;
    static double[] dist; // MST에 연결된 노드까지의 최소 거리를 저장하는 배열
    static boolean[] visited; // MST에 포함되었는지 여부

    public static void main(String[] args) throws IOException {
       // System.setIn(new FileInputStream("data/input.txt"));
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        stars = new double[n][2];
        for (int i = 0; i < n; i++) {
            stars[i][0] = sc.nextDouble();
            stars[i][1] = sc.nextDouble();
        }

        dist = new double[n];
        visited = new boolean[n];
        
        for (int i = 0; i < n; i++) {
            dist[i] = Double.MAX_VALUE;
        }

        prim(0);
        
        double ans = 0;
        for (double d : dist) {
            ans += d;
        }
        
        System.out.println(String.format("%.2f", ans));
    }

    private static void prim(int start) {
        dist[start] = 0;
        PriorityQueue<Node> heap = new PriorityQueue<>();
        heap.offer(new Node(start, 0));

        while (!heap.isEmpty()) {
            Node currentNode = heap.poll();
            
            // 이미 방문한 노드라면 건너뜀
            if (visited[currentNode.vertex]) {
                continue;
            }
            
            visited[currentNode.vertex] = true;

            // 현재 노드와 연결된 모든 노드들을 탐색
            for (int i = 0; i < n; i++) {
                if (!visited[i]) {
                    double currentDist = getDistance(currentNode.vertex, i);
                    
                    // 새로운 거리가 기존 최소 거리보다 짧다면 갱신
                    if (currentDist < dist[i]) {
                        dist[i] = currentDist;
                        heap.offer(new Node(i, currentDist));
                    }
                }
            }
        }
    }
    
    private static double getDistance(int i, int j) {
        double x1 = stars[i][0], y1 = stars[i][1], x2 = stars[j][0], y2 = stars[j][1];
        return Math.hypot(x1 - x2, y1 - y2);
    }
}