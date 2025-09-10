import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;
 
public class Solution {
    static class Node implements Comparable<Node> {
        int to;
        double cost;
 
        public Node(int to, double cost) {
            this.to = to;
            this.cost = cost;
        }
        @Override
        public int compareTo(Node o) {
            return Double.compare(this.cost, o.cost);
        }
    }
 
    static int n;
    static double[] minEdge;
    static boolean[] visited;
    static StringBuilder sb;
 
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedReader br = new BufferedReader(new FileReader("data/input.txt"));
        sb = new StringBuilder();
        int t = Integer.parseInt(br.readLine());
 
        for (int test_case = 1; test_case <= t; test_case++) {
            sb.append("#").append(test_case).append(" ");
            n = Integer.parseInt(br.readLine());
            
            int[] xArr = new int[n];
            int[] yArr = new int[n];
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) xArr[i] = Integer.parseInt(st.nextToken());
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) yArr[i] = Integer.parseInt(st.nextToken());
            
            double e = Double.parseDouble(br.readLine());
 
            minEdge = new double[n]; 
            visited = new boolean[n];
            
            Arrays.fill(minEdge, Double.MAX_VALUE);
            
            minEdge[0] = 0;
            PriorityQueue<Node> heap = new PriorityQueue<>();
            heap.offer(new Node(0, 0));
 
            double ans = 0;
            int count = 0;
 
            while (!heap.isEmpty()) {
                Node cur = heap.poll();
                if (visited[cur.to]) continue;
                visited[cur.to] = true;
                ans += cur.cost;
                count++;
                if (count == n) break;
                for (int i = 0; i < n; i++) {
                    if (!visited[i]) {
                        double distance = getDistance(xArr[cur.to], yArr[cur.to], xArr[i], yArr[i]);
                        if (distance < minEdge[i]) {
                            minEdge[i] = distance;
                            heap.offer(new Node(i, distance));
                        }
                    }
                }
            }
 
            sb.append(Math.round(ans * e)).append("\n");
        }
        System.out.println(sb.toString());
        br.close();
    }
 
    private static double getDistance(long x1, long y1, long x2, long y2) {
        return Math.pow(Math.hypot(x2-x1, y2-y1), 2);
    }
}