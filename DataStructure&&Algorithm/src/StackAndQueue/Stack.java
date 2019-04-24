package StackAndQueue;
/*
 * This is not a thread-safe stack
 */
public class Stack {
	private String[] items;
	private int count;
	private int capacity;

	public Stack(int capacity) {
		this.capacity = capacity;
		items = new String[capacity];
	}

	public  boolean push(String item) {	
		if (count >= capacity) {
			System.out.println("the stack is full");
			return false;
		}
		items[count++] = item;
		print();
		System.out.println("the count is "+count);
		System.out.println("new printing");
		return true;
	}

	public String pop() {
		if (count == 0) {
			return null;
		}
		String item = items[--count];
		return item;
	}

	public int getSize() {
		return count;
	}

	public String getLastElement() {
		return items[count - 1];
	}

	public void print() {
		//System.out.println("the count is "+count);
		System.out.println("one time");
		for (int i = 0; i < count; i++) {
			//System.out.println(i);
			System.out.println(items[i]);
		}

	}

	public static void main(String[] args) {
		Stack stack=new Stack(100);
		Thread thread = new Thread() {
			public void run() {
				int i=0;
				while(i<100) {
					stack.push("test"+i);
					++i;
				}
			}
		};
		thread.start();
		Thread thread1 = new Thread() {
			public void run() {
				int i=0;
				while(i<100) {
					stack.push("sd"+i);
					++i;
				}
			}
		};
		
		thread1.start();
	
	}

}
