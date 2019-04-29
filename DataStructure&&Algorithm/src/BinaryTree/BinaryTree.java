package BinaryTree;

import java.util.LinkedList;
import java.util.Queue;

public class BinaryTree {
	public Node root;

	public void add(int element) {
		if (root == null) {
			root = new Node(element);
			return;
		}
		Node node = root;
		while (node != null) {
			if (element < node.getData()) {
				Node preNode = node;
				if (preNode.left == null) {
					Node newNode = new Node(element);
					preNode.left = newNode;
					return;
				}
				node = node.left;
			} else {
				Node preNode = node;
				if (preNode.right == null) {
					Node newNode = new Node(element);
					preNode.right = newNode;
					return;
				}
				node = node.right;
			}
		}
	}

	public void preOrderPrint(Node node) {

		if (node == null) {

			return;
		}
		System.out.println(node.getData());
		preOrderPrint(node.left);
		preOrderPrint(node.right);
	}

	public void delete(int element) {
		Node node = root;
		Node pp = null;
		while (node != null && node.getData() != element) {
			pp = node;
			if (node.getData() < element) {
				node = node.right;
			} else {
				node = node.left;
			}
		}

		if (node == null) {
			System.out.println("the element not found");
			return;
		}
		if (node.left != null && node.right != null) {
			Node minNode = node.right;
			Node pMinNode = null;
			Node dataNode = node;
			while (minNode.left != null) {
				pMinNode = minNode;
				minNode = minNode.left;
			}
			node.setData(minNode.data);
			if (dataNode == root) {
				root = node;
			}
			if (pMinNode == null) {
				dataNode.right = null;
			} else {
				pMinNode.left = null;
			}
		} else if (node.left != null || node.right != null) {
			if (node.left != null) {
				Node leftnode = node.left;
				node.setData(leftnode.getData());
				if (node == root) {
					root = node;
				}
				node.left = null;
				return;
			}
			Node rightNode = node.right;
			node.setData(rightNode.getData());
			if (node == root) {
				root = node;
			}
			node.right = null;
		}
		if (node.left == null && node.right == null) {
			if (pp == null) {
				root = null;
			} else {
				if (pp.left == node) {
					pp.left = null;
				} else {
					pp.right = null;
				}
			}
		}
	}

	public int getHeight() {
		int height = 0;
		int last = 0;
		int rear = 0;
		int pre = -1;
		Queue<Node> queue = new LinkedList<>();
		queue.add(root);
		while (!queue.isEmpty()) {

			if (queue.peek().left != null) {
				++rear;
				queue.add(queue.peek().left);
			}
			if (queue.peek().right != null) {
				++rear;
				queue.add(queue.peek().right);
			}
			++pre;
			if (pre == last) {
				++height;
				last = rear;
			}
			queue.poll();

		}

		return height;

	}

	public void middleOrderPrint(Node node) {

		if (node == null) {
			return;
		}

		middleOrderPrint(node.left);
		System.out.println(node.getData());
		middleOrderPrint(node.right);
	}

	public void lastOrderPrint(Node node) {

		if (node == null) {

			return;
		}

		lastOrderPrint(node.left);
		lastOrderPrint(node.right);
		System.out.println(node.getData());

	}

	private class Node {
		private int data;
		public Node left;
		public Node right;

		private Node(int data) {
			this.data = data;
		}

		public int getData() {
			return this.data;
		}

		public void setData(int data) {
			this.data = data;
		}

	}

	public static void main(String[] args) {
		System.out.println(System.currentTimeMillis());
		BinaryTree tree = new BinaryTree();
		tree.add(80);
		tree.add(90);
		tree.add(70);
		tree.add(78);
		tree.add(60);
		tree.add(100);
		tree.add(120);
		tree.add(140);
		tree.add(88);
		tree.add(92);
		tree.delete(78);
		tree.middleOrderPrint(tree.root);
		System.out.println("the height of tree is " + tree.getHeight());
		System.out.println(System.currentTimeMillis());
		// tree.preOrderPrint(tree.root);
	}

}
