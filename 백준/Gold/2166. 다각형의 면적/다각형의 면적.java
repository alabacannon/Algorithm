import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Iterator;
import java.util.StringTokenizer;

public class Main {
	static int n;
	static Point[] points;
	public static void main(String[] args) throws IOException {
//		BufferedReader br = new BufferedReader(new FileReader("data/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		n = Integer.parseInt(br.readLine());
		points = new Point[n];
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			points[i] = new Point(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()));
		}
		double ans = calculateArea();
		
		System.out.printf("%.1f",Math.abs(ans));
		br.close();
		bw.close();
	}
	
	static double calculateArea() {
		double area = 0;
		for (int i = 0; i < points.length-1; i++) {
			area += getArea(points[i], points[i+1]);
		}
		area += getArea(points[n-1], points[0]);
		return area;
	}
	
	static double getArea(Point a, Point b) {
		return (a.x*b.y - b.x*a.y)/2; 
	}
	
	
	static class Point{
		double x;
		double y;
		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
}
