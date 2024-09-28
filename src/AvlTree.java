import enums.Labels;
import enums.TreeOrderType;

public class AvlTree {
	private class Node {
		private Node parent;
		private Node right;
		private Node left;
		private int height = 1;

		private int value;
		
		public Node(int value, Node parent) {
			this.value = value;
			this.parent = parent;
		}
	}
	
	public static void main(String ...args) {
		AvlTree bt = new AvlTree();
		bt.insert(30);
		bt.insert(20);
		bt.insert(40);
		bt.insert(10);
		bt.insert(5);
		bt.insert(3);
	}
	
	private static int TREE_BALANCE_LIMIT = 2;
	private Node root;
	private int inserted;
	
	private void rotate(Node node) {
		
	}

	public void insert(int value) {
		if (root == null) {
			root = insertNode(value, null);
		} else {
			insertNode(value, root);
		}
		
	}
	
	private Node insertNode(int value, Node node) {
		if (node == null) {
			return new Node(value, null);
		}

		if (value < node.value) {
			node.left = insertNode(value, node.left);
		} else if (value > node.value) {
			node.right = insertNode(value, node.right);
		}
		
		inserted++;
		
		node.height = 1 + max(heightOf(node.left), heightOf(node.right));
		int nodeBalance = getBalance(node);
		
		if (nodeBalance >= TREE_BALANCE_LIMIT && value < node.left.value) {
			System.out.println("LL");
		}
		
		if (nodeBalance <= -TREE_BALANCE_LIMIT && value > node.right.value) {
			System.out.println("RR");
		}
		
		if (nodeBalance >= TREE_BALANCE_LIMIT && value > node.left.value) {
			System.out.println("LR");
		}
		
		if (nodeBalance <= -TREE_BALANCE_LIMIT && value < node.right.value) {
			System.out.println("RL");
		}
		
		return node;
	}
	
	private Node rotateRight(Node node) {
		var leftChild = node.left;
		node.left = leftChild.right;
		leftChild.left = node;
		
		node.height = 1 + max(heightOf(node.left), heightOf(node.right));
		leftChild.height = 1 + max(heightOf(leftChild.left), heightOf(leftChild.right));
		
		return leftChild;
	}
	
	private Node rotateLeft(Node node) {
		var rightChild = node.right;
		node.right = rightChild;
		rightChild.right = node;
		
		node.height = 1 + max(heightOf(node.left), heightOf(node.right));
		rightChild.height = 1 + max(heightOf(rightChild.left), heightOf(rightChild.right));
		
		return rightChild;
	}
	
	private int getBalance(Node node) {
		int balance = 0;
		
		if (node != null) {
			balance = heightOf(node.left) - heightOf(node.right);
		}
		
		return balance;
	}
	
	private int heightOf(Node node) {
		return (node != null) ? node.height : 0;
	}
	
	private int max(int a, int b) {
		return (a == b) ? a : (a < b) ? b : a;
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
