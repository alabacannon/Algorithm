import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] problems = {12,11,11,10,9,9,9,8,7,6,6}; 
		int[] penalties = {1600,894,1327,1311,1004,1178,1357,837,1055,556,773}; 
		int n = sc.nextInt()-1;
		
		System.out.println(problems[n] + " " + penalties[n]);
		
	}
}