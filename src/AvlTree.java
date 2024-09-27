import enums.Labels;
import enums.TreeOrderType;

public class AvlTree {
	private class Node {
		private Node parent;
		private Node right;
		private Node left;
		private int heigth = 1;

		private int value;
		
		public Node(int value, Node parent) {
			this.value = value;
			this.parent = parent;
		}
	}
	
	public static void main(String ...args) {
		AvlTree bt = new AvlTree();
		bt.insert(5);
		
		bt.insert(1);
		bt.insert(4);
		bt.insert(9);
		bt.insert(6);
		bt.insert(3);
		bt.insert(7);
		bt.insert(2);
		bt.insert(8);
		
		bt.inOrder();
		System.out.println();
		bt.preOrder();
		System.out.println();
		bt.postOrder();
		System.out.println();
		bt.search(8);
		
		System.out.println();
		System.out.println(bt.inserted);
	}
	
	private Node root;
	private int inserted;

	public void insert(int value) {
		if (root == null) {
			root = new Node(value, null);
			inserted++;

		} else {
			insertNode(value, root);
		}
		
	}
	
	private void insertNode(int value, Node node) {
		if (value < node.value) {
			if (node.left == null) {
				node.left = new Node(value, node);
				inserted++;

			} else {
				insertNode(value, node.left);	
			}
		} else if (value > node.value){
			if (node.right == null) {
				node.right = new Node(value, node);
				inserted++;

			} else {
				insertNode(value, node.right);	
			}
		}
	}
	
	public void delete(int value) {
		if (root == null) {
			throw new RuntimeException(Labels.BINARY_TREE_EMPTY.getLabel());
		} else {
			deleteNode(value, root);
		}
	}
	
	private void deleteNode(int value, Node node) {
		if (value == node.value) {
			
			if (node.parent == null ) {
				root = null;
			} else {
				if (node.parent.left.value == node.value) {
					node.parent.left = null;
				} else {
					node.parent.right = null;
				}
			}
			inserted--;

		} else {
			if (value < node.value && node.left != null) {
				deleteNode(value, node.left);
				
			} else if (value > node.value && node.right != null) {
				deleteNode(value, node.right);
			}
		}
		
	}
	
	public void search(int value) {
		if (root == null) {
			throw new RuntimeException(Labels.BINARY_TREE_EMPTY.getLabel());
		} else {
			if (value < root.value) {
				findNode(value, root.left);
			} else if (value > root.value) {
				findNode(value, root.right);
			} else {
				findNode(value, root);
			}
		}
		
//		// Low Performance
//		findNode(value, root);
	}
	
	private void findNode(int value, Node node) {
		if (node != null) {
			if (node.value == value) {
				System.out.println("result: " + node.value);
			} else {
				findNode(value, node.left);
				findNode(value, node.right);
			}	
		}
	}
	
	public void inOrder() {
		viewTree(root, TreeOrderType.IN_ORDER);
	}
	
	public void preOrder() {
		viewTree(root, TreeOrderType.PRE_ORDER);
	}
	
	public void postOrder() {
		viewTree(root, TreeOrderType.POST_ORDER);
		
	}
	
	private void viewTree(Node node, TreeOrderType type) {
		if (node != null) {
			switch (type) {
			case TreeOrderType.IN_ORDER:
				System.out.println(node.value);
				viewTree(node.left, type);
				viewTree(node.right, type);
				break;
			case TreeOrderType.PRE_ORDER:
				viewTree(node.left, type);
				System.out.println(node.value);
				viewTree(node.right, type);
				break;
			case TreeOrderType.POST_ORDER:
				viewTree(node.left, type);
				viewTree(node.right, type);
				System.out.println(node.value);
				break;
			}
		}
	}
	public int minimum() {
		return 0;
	}
	
	public int maximum() {
		return 0;
	}
}
