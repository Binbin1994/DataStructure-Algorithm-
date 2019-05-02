package HeapAndPriorityQueue;

/*
 * The implementation of (non-thread safe)priority queue based on the heap
 * author: HongBin Deng
 */
public class PriorityQueue {
	private int capacity;
	private Heap heap;

	public PriorityQueue(int capacity) {
		this.capacity = capacity;
		heap = new Heap(capacity);
	}
	/*
	 * Normal adding functions for queue
	 */
	public void add(int element) {	
		heap.add(element);
	}

	
	/*
	 * To get the TopK OR SmallK, such as getting smallest 3
	 */
//	public void add(int element) {
//		if(heap.getSize()==3) {
//			if(element<heap.peek()) {
//				heap.pop();
//				heap.add(element);
//			}
//		}
//		else {
//			heap.add(element);
//		}
//	
//	}
//	
	
	public int pop() {
		if (heap.getSize() == 0) {
			System.out.println("the queue is empty");
			return -1;
		}
		return heap.pop();
	}
	
	public void print() {
		heap.print();
	}

	public static void main(String[] args) {
		PriorityQueue queue=new PriorityQueue(5);
		System.out.println(System.currentTimeMillis());
		queue.add(7);
		queue.add(6);		
		queue.add(13);
		queue.add(12);
		queue.add(11);
		queue.add(20);
		queue.add(29);
		queue.add(5);
		queue.add(4);
		queue.add(28);
		System.out.println("Printing out queue");
		queue.print();
		System.out.println(System.currentTimeMillis());
	}

}
