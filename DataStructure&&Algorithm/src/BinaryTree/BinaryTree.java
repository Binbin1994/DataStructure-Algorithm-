package BinaryTree;

import java.util.ArrayList;
/*
 * author: Hongbin Deng
 */
import java.util.LinkedList;
import java.util.List;
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

	public int getMaxHeight(Node node) {
		if (node == null) {
			return 0;
		}
		return Math.min(getMaxHeight(node.left), getMaxHeight(node.right)) + 1;
	}

	public void middleOrderPrint(Node node,List<Integer> list) {

		if (node == null) {
			return;
		}

		middleOrderPrint(node.left,list);
		list.add(node.getData());
		System.out.println(node.getData());
		middleOrderPrint(node.right,list);
	}

	public void callPath(int value) {
		List<Integer> list = new ArrayList<>();
		list.add(root.getData());
		List<List<Integer>> listTwo = new ArrayList<>();
		boolean found = false;
		binaryTreePath(root.getData(), root, value, list, listTwo, found);
		System.out.println(listTwo.size());
		if (listTwo.size() == 0) {
			System.out.println("there is no path for this sum");
		} else {
			for (List<Integer> item : listTwo) {
				System.out.println(item);
			}
		}

	}

	public void binaryTreePath(int element, Node node, int sum, List<Integer> list, List<List<Integer>> listTwo,
			boolean found) {

		if (node.left == null && node.right == null) {
			if (element == sum) {
				List<Integer> temp=new ArrayList();
				for(Integer item:list) {
					temp.add(item);
				}
				listTwo.add(temp);
				return;
			}
			return;
		}
		if (element == sum) {
			List<Integer> temp=new ArrayList();
			for(Integer item:list) {
				temp.add(item);
			}
			listTwo.add(temp);
			found = true;
			return;
		}
		if (node.left != null) {
			list.add(node.left.getData());
			binaryTreePath(element + node.left.getData(), node.left, sum, list, listTwo, found);
			list.remove(list.size() - 1);

		}
		if (node.right != null) {
			list.add(node.right.getData());
			binaryTreePath(element + node.right.getData(), node.right, sum, list, listTwo, found);
			list.remove(list.size() - 1);

		}

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
		tree.add(18);
		//get sorted list in log(n) time
		List<Integer> list=new ArrayList<>();	
		// tree.delete(78);
		tree.middleOrderPrint(tree.root,list);		 
		for(Integer number:list) {
			 System.out.println(number);
		 }
//		System.out.println("the height of tree is " + tree.getHeight());
//		System.out.println(tree.getMaxHeight(tree.root));
//		System.out.println(System.currentTimeMillis());
		tree.callPath(228);
		// tree.preOrderPrint(tree.root);
	}

}
