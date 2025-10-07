import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	static class Gem {
		int m;
		int v;
		
		public Gem(int m, int v) {
			this.m = m;
			this.v = v;
		}

		@Override
		public String toString() {
			return "Gem [m=" + m + ", v=" + v + "]";
		}
	}
	
	static ArrayList<Gem> list;
	public static void main(String[] args) throws IOException {
//		BufferedReader br = new BufferedReader(new FileReader("data/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		list = new ArrayList<>();
		
		// 가치 기준으로 꺼낼 예정
		PriorityQueue<Gem> pqGem = new PriorityQueue<>((o1,o2) -> Integer.compare(o2.v, o1.v));
		
		// 가벼운놈이 먼저 나오도록
		PriorityQueue<Integer> pqBack = new PriorityQueue<>();
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			int m = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			list.add(new Gem(m,v));
		}
		
		// 무게 기준으로 정렬
		Collections.sort(list, (o1,o2) -> Integer.compare(o1.m, o2.m));
		for (int i = 0; i < k; i++) {
			int c = Integer.parseInt(br.readLine());
			pqBack.offer(c);
		}
		int idx = 0;
		long totalValue = 0;
		while (!pqBack.isEmpty()) {
			int curCapa = pqBack.poll();
			while (idx < list.size()) {
				Gem g = list.get(idx);
				if (g.m > curCapa) break; 
				pqGem.offer(list.get(idx));
				idx ++ ;
			}
			if (!pqGem.isEmpty()) {
				totalValue += pqGem.poll().v;
			}
		}
		System.out.println(totalValue);
		
//		System.out.println(pqGem);
//		System.out.println(pqBack);
		
		br.close();
	}
}