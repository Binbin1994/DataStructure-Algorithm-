package LinkedList;

public class SingleList {
	private int size;
	private Node head;
	private Node tail;

	public Node getHead() {
		return head;
	}

	public int getSize() {
		System.out.println("size is " + size);
		return size;
	}

	public void add(int data) {
		if (head == null) {
			Node newNode = new Node(data);
			head = newNode;
			++size;
			tail = head;
			return;
		}
		++size;
		Node node = new Node(data);
		tail.next = node;
		tail = node;

	}

	public void reverse() {
		Node pre = null;
		Node node = head;
		System.out.println("linkedlist is reversing");
		while (node != null) {
			Node next = node.next;
			if (node == head) {
				node.next = pre;
				pre = node;
				tail = node;
			} else {
				node.next = pre;
				pre = node;
				if (next == null) {
					head = node;
				}
			}
			node = next;
		}
	}

	public boolean delete(int data) {
		Node node = head;
		if (node.getData() == data) {
			head = head.next;
			--size;
			return true;
		}
		node=node.next;
		while (node != null) {
			if (node.getData() == data) {
				Node preNode = findPreNode(node);
				if (node == tail) {
					preNode.next = preNode.next.next;
					--size;
					tail = preNode;
					return true;
				}
				--size;
				preNode.next = preNode.next.next;
			}
			node = node.next;
		}
		return false;
	}

	public SingleList mergeLinkedList(SingleList list1, SingleList list2) {
		SingleList mergeList = new SingleList();
		Node head = list1.getHead();
		Node headSec = list2.getHead();
		while (head != null && headSec != null) {
			if (head.getData() < headSec.getData()) {
				mergeList.add(head.getData());
				head = head.next;
			} else {
				mergeList.add(headSec.getData());
				headSec = headSec.next;
			}
		}
		if (head != null) {
			while (head != null) {
				mergeList.add(head.getData());
				head = head.next;
			}

		} else {
			while (headSec != null) {
				mergeList.add(headSec.getData());
				headSec = headSec.next;
			}
		}

		return mergeList;

	}

	public Node findPreNode(Node node) {
		Node preNode = head;
		while (preNode != null) {
			Node next = preNode.next;
			if (next.getData() == node.getData()) {
				return preNode;
			}
			preNode = preNode.next;
		}
		return null;
	}

//	public void sorting() {
//		Node node = head;
//		System.out.println("size is "+size);
//		for (int i = 0; i < size; i++) {
//			for (int j = 0; j < size - i; j++) {
//				Node next=node.next;
//				if (node == head) {
//					
//					if (node.getData() > node.next.getData()) {
//						node.next = node.next.next;
//						node.next.next = node;
//						head = next;
//						node = next;
//					}
//					else {
//						System.out.println("running");
//						if(i==0) {head=node;}
//						continue;
//					}
//					
//				} else {
//					if (node.getData() > node.next.getData()) {
//						node.next = node.next.next;
//						node.next.next = node;
//						node = next;
//					}
//					else {
//						continue;
//					}
//					
//				}
//			}
//
//		}
//
//	}

	public void print() {
		Node node = head;
		while (node != null) {
			System.out.println(node.data);
			node = node.next;
		}
	}

	public static class Node {
		private Node next;
		private int data;

		public Node(int data) {
			this.data = data;
		}

		public int getData() {
			return data;
		}

		public void setDate(int data) {
			this.data = data;
		}

	}

	public static void main(String[] args) {
		SingleList linkedlist = new SingleList();
		System.out.println(System.currentTimeMillis());
		linkedlist.add(1);
		linkedlist.add(14);
		linkedlist.add(11);
		linkedlist.add(10);
		linkedlist.print();

//		SingleList linkedlistTest = new SingleList();
//		linkedlistTest.add(5);
//		linkedlistTest.add(6);
//		linkedlistTest.add(7);
//
//		SingleList SortedList = linkedlistTest.mergeLinkedList(linkedlist, linkedlistTest);
//		SortedList.print();
		System.out.println(System.currentTimeMillis());

	}

}
