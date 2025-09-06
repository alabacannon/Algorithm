import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException {
//		BufferedReader br = new BufferedReader(new FileReader("data/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String st = br.readLine();
		if (st.length() == 1) {
			System.out.println(0);
			return;
		}
		int count = 0;
		for (int i = 0; i < st.length()-1; i++) {
			 if (st.charAt(i) != st.charAt(i+1)) {
				count++;
			}
		}
		System.out.println((count+1)/2);

		br.close();
	}
}
