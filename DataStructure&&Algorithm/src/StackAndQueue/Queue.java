package StackAndQueue;

/*
 * This is not a thread-safe stack
 */
public class Queue {
	private int defaultCapacity=10;
	private int tail;
	private int head;
	private int size;
	private int[] stack;
	public Queue() {
		stack=new int[defaultCapacity];
	}
	public Queue(int capacity) {
		this.defaultCapacity=capacity;
		stack=new int[defaultCapacity];
	}
	public int getSize() {
		return size;
	}
	
	public void add(int element) {
		if(tail>=defaultCapacity) {
			if(head==0) {
				System.out.println("the queue is full");
				return;
			}
			for(int i=head;i<tail;i++) {
				stack[i-head]=stack[i];
			}
			tail=tail-head;
			head=0;
		}
		stack[tail]=element;
		++tail;
		++size;
		
	}
	
	public int pop() {
		if(head==tail) {
			System.out.println("the queue is empty");
			return -1;
		}
		int first=stack[head];
		++head;
		--size;
		return first;
	}
	
	public void print() {
//		for(int element:stack) {
//			System.out.println(element);
//		}
		System.out.println("print from head to tail");
		for(int i=head;i<tail;i++) {
			System.out.println(stack[i]);
		}
	}
	
	public static void main(String[] args) {
		
		Queue queue=new Queue(3);
		queue.add(12);
		queue.add(13);
		System.out.println(queue.pop());
		System.out.println(queue.pop());
		System.out.println(queue.pop());
		queue.print();
		
	}
	
	
	

}
