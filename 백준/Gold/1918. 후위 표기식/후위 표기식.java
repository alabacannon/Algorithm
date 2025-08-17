import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;
import java.util.Stack;

public class Main {
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		char[] inputArr = sc.nextLine().toCharArray();
		Stack<Character> stack = new Stack<>();
		for (int i = 0; i < inputArr.length; i++) {
			char c = inputArr[i];
			switch (c) {
			case '(':
				stack.push(c);
				break;
			case ')':
				while (true) {
					char temp = stack.pop();
					if (temp == '(') {
						break;
					}
					System.out.print(temp);
				}
				break;
			case '+':
			case '-':
				while (!stack.isEmpty()&&(stack.peek() == '*' 
				|| stack.peek() == '/' || stack.peek() == '+' || stack.peek() == '-')) {
					System.out.print(stack.pop());
				} 
				stack.push(c);
				break;
				
			case '*':
			case '/':
				while (!stack.isEmpty() && (stack.peek() == '*' || stack.peek() == '/')) {
					System.out.print(stack.pop());
                }
				stack.push(c);
				break;
			default:
				System.out.print(c);
				break;
			}
		}
		while (!stack.isEmpty()) {
			System.out.print(stack.pop());
		}
	}
}