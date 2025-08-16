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
		for (int i = 0; i < points.length-2; i++) {
			area += getArea(points[0], points[i+1], points[i+2]);
		}
		return area;
	}
	
	static double getDistance(Point a, Point b) {
		return Math.hypot(a.x - b.x, a.y - b.y);
	}
	static double getArea(Point a, Point b, Point c) {
		double x1 = b.x - a.x;
		double x2 = c.x - a.x;
		double y1 = b.y - a.y;
		double y2 = c.y - a.y;
		
		return (x2*y1 - x1*y2)/2; 
				
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
