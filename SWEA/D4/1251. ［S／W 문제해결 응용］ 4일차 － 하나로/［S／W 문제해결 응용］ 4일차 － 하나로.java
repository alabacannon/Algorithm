import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;
 
public class Solution {
    static class Node implements Comparable<Node>{
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
    static long ans;
    static boolean[] visited;
    static StringBuilder sb;
    static PriorityQueue<Node> heap;
    static ArrayList<ArrayList<Node>> graph;
    public static void main(String[] args) throws IOException {
//    	BufferedReader br = new BufferedReader(new FileReader("data/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();
        StringTokenizer st;
        int t = Integer.parseInt(br.readLine());
        for (int test_case = 1; test_case <= t; test_case++) {
            ans = 0;
            sb.append("#").append(test_case).append(" ");
            n = Integer.parseInt(br.readLine());
            int[] xArr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            int[] yArr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            double e = Double.parseDouble(br.readLine());
            visited = new boolean[n+1];
            heap = new PriorityQueue<>();
            graph = new ArrayList<>();
            for (int i = 0; i <= n; i++) {
				graph.add(new ArrayList<>());
			}
            for (int i = 1; i <= n; i++) {
                for (int j = i+1; j <= n; j++) {
                	double d = getDistance(xArr[i-1],yArr[i-1],xArr[j-1],yArr[j-1]);
                    graph.get(i).add(new Node(j,d)) ;
                    graph.get(j).add(new Node(i,d)) ;
                }
            }
            heap.offer(new Node(1,0));
            while (!heap.isEmpty()) {
                Node cur = heap.poll();
                int to = cur.to;
                double cost = cur.cost;
                if (visited[to]) continue; 
				visited[to] = true;
				ans += cost;
                for (Node next : graph.get(to)) {
                	if (visited[next.to]) continue;
                	heap.offer(new Node(next.to, next.cost));
				}
            }
             
            sb.append(Math.round(ans * e)).append("\n");
        }
        System.out.println(sb.toString());
        br.close();
    }
     
 
 
    private static double getDistance(int a, int b, int c, int d) {
        long dx = (long) (a - c);
        long dy = (long) (b - d);
        return (double) (dx * dx + dy * dy);
    }
}