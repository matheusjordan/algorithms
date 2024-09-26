
public class BinaryTree {
	private class Node {
		private Node right;
		private Node left;
		private int value;
		
		public Node(int value) {
			this.value = value;
		}
	}
	
	
	public static void main(String ...args) {
		BinaryTree bt = new BinaryTree();
		
		bt.insert(5);
		
		bt.insert(1);
		bt.insert(4);
		bt.insert(9);
		bt.insert(6);
		bt.insert(3);
		bt.insert(7);
		bt.insert(2);
		bt.insert(8);
	}
	
	private Node root;
	private int inserted;

	public void insert(int value) {
		if (root == null) {
			root = new Node(value);
			System.out.println("adicionado na raiz " + value);
			inserted++;

		} else {
			insertItem(value, root);
		}
		
	}
	
	private void insertItem(int value, Node node) {
		if (value < node.value) {
			if (node.left == null) {
				node.left = new Node(value);
				inserted++;

			} else {
				insertItem(value, node.left);	
			}
		} else if (value > node.value){
			if (node.right == null) {
				node.right = new Node(value);
				inserted++;

			} else {
				insertItem(value, node.right);	
			}
		}
	}
	
	public void delete(int value) {
		
	}
	
	public void search(int value) {
		
	}
	
	public void inOrder() {
		
	}
	
	public void preOrder() {
		
	}
	
	public void postOrder() {
		
	}
	
	public int minimum() {
		return 0;
	}
	
	public int maximum() {
		return 0;
	}
}
