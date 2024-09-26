import enums.Labels;

public class BinaryTree {
	private class Node {
		private Node parent;
		private Node right;
		private Node left;
		private int value;
		
		public Node(int value, Node parent) {
			this.value = value;
			this.parent = parent;
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
		
		bt.delete(5);
		bt.inOrder();
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
		
	}
	
	public void inOrder() {
		if (root == null) {
			throw new RuntimeException(Labels.BINARY_TREE_EMPTY.getLabel());
		} else {
			showChildNodesInOrder(root);
		}
	}
	
	private void showChildNodesInOrder(Node node) {
		if (node != null) {
			System.out.println(node.value);
			showChildNodesInOrder(node.left);
			showChildNodesInOrder(node.right);
		}
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
