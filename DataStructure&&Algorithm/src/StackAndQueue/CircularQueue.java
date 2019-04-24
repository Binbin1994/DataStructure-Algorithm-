package StackAndQueue;

public class CircularQueue {
	private int head = 0;
	private int tail = 0;
	private int n = 0;
	private int[] items;

	public CircularQueue(int capacity) {
		items = new int[capacity];
		n = capacity;
	}

	public boolean enqueue(int element) {
		if ((tail + 1) % n == head) {
			System.out.println("the queue is full");
			return false;
		}
		items[tail]=element;
		tail=(tail+1)%n;
		return true;
	}
	public int dequeue() {
		if(head==tail) {
			return -1;
		}
		int element=items[head];
		head=(head+1)%n;
		return element;		
	}
	
	public void print() {
		for(int item:items) {
			System.out.println(item);
		}
	}
	
	

}
