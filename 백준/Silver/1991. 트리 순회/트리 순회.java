import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

public class Main {
	static TreeNode[] arr;
	public static void main(String[] args) throws IOException {
		//System.setIn(new FileInputStream("data/input.txt"));
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		arr = new TreeNode[n];
		arr[0] =  new TreeNode('A');
		for (int i = 0; i < n; i++) {
			char parent = sc.next().charAt(0);
			char child1 = sc.next().charAt(0);
			char child2 = sc.next().charAt(0);
			arr[parent-'A'].data = parent;
			if (child1 >= 'A') {
				arr[child1-'A'] = new TreeNode(child1);
				arr[parent-'A'].left = arr[child1-'A'];
			}
			if (child2 >= 'A') {
				arr[child2-'A'] = new TreeNode(child2);
				arr[parent-'A'].right = arr[child2-'A'];
			}
		}
		preOrder(arr[0]);
		System.out.println();
		inOrder(arr[0]);
		System.out.println();
		postOrder(arr[0]);
	}
	
	private static void preOrder(TreeNode parent) {
		if (parent == null)	return;
		System.out.print(parent.data);
		preOrder(parent.left);
		preOrder(parent.right);
	}
	
	private static void inOrder(TreeNode parent) {
		if (parent == null)	return;
		inOrder(parent.left);
		System.out.print(parent.data);
		inOrder(parent.right);
		
	}
	
	private static void postOrder(TreeNode parent) {
		if (parent == null)	return;
		postOrder(parent.left);
		postOrder(parent.right);
		System.out.print(parent.data);
		
	}

	static class TreeNode{
		char data;
		TreeNode left;
		TreeNode right;
		public TreeNode(char data) {
			this.left = null;
			this.right = null;
		}
	}
	
}