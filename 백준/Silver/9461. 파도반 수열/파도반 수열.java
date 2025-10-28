import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
	public static void main(String[] args) throws IOException  {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		List<Long> l = new ArrayList<>();
		l.add((long) 1);
		l.add((long)1);
		l.add((long)1);
		l.add((long)2);
		l.add((long)2);
		int idx = 0;
		for(int t = 0; t < T; t++) {
			int x = Integer.parseInt(br.readLine());
			
			if(x < l.size()) {
				System.out.println(l.get(x-1));
			}
			else {
				while(x > l.size()) {
					l.add(l.get(l.size()-1) + l.get(idx++));
				}
				System.out.println(l.get(x-1));
			}
		}
	}
}
