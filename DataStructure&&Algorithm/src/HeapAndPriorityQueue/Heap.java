package HeapAndPriorityQueue;

import java.util.Arrays;

/*
 * author: HongBin Deng
 * achieve the priority queue in log(n) time
 */
public class Heap {
	private int[] a;
	private int size;
	private int count;

	public Heap(int capacity) {
		a = new int[capacity + 1];
		this.size = capacity;
		this.count = 0;
	}

	public int getSize() {
		return count;
	}

	public void add(int element) {
		if (count >= size) {
			return;
		}
		++count;
		a[count] = element;
		int i = count;
		while (i > 1) {
			int j = i / 2;
			if (a[i] < a[j]) {
				break;
			}
			int value = a[j];
			a[j] = a[i];
			a[i] = value;
			i = j;
		}
	}

	public int pop() {
		if (count == 0) {
			System.out.println("the heap now is empty");
			return -1;
		}
		int topValue = a[1];
		a[1] = a[count];
		int i = 1;
		while (true) {
			int max = i;
			if (2 * i <= count && a[max] < a[2 * i]) {
				max = 2 * i;
			}
			if (2 * i + 1 <= count && a[max] < a[2 * i + 1]) {
				max = 2 * i + 1;
			}
			if (max == i) {
				break;
			}
			int value = a[max];
			a[max] = a[i];
			a[i] = value;
			i = max;
		}
		--count;
		return topValue;
	}

	public int peek() {
		if (count == 0) {
			return -1;
		}
		return a[1];
	}
/*
 * the sorting of array based on the heap need to use heapify method
 */
	
//	public void heapify(int[] array) {
//		
//		
//		
//		
//	}
//
//	public int[] sort() {
//
//		return null;
//	}

	public int[] mergeToSortedArray(int[] array1, int[] array2) {
		int len = array1.length + array2.length;
		int[] array = new int[len];
		Heap heap = new Heap(len);
		for (int i = 0; i < array1.length; i++) {
			heap.add(array1[i]);
		}
		for (int i = 0; i < array2.length; i++) {
			heap.add(array2[i]);
		}
		for (int i = 0; i < array.length; i++) {
			array[i] = heap.pop();
		}

		return array;
	}

	public void print() {
		for (int i = 1; i <= count; i++) {
			System.out.println(a[i]);
		}
	}

	public static void main(String[] args) {
		Heap heap = new Heap(10);
		heap.add(7);
		heap.add(6);
		heap.add(13);
		heap.add(12);
		heap.add(11);
		heap.add(20);
		heap.add(29);
		heap.add(5);
		heap.add(4);
		heap.add(28);
		heap.print();

		/*
		 * running in concurrent environment
		 */
		Thread thread = new Thread() {
			public void run() {
				while (heap.getSize() != 0) {
					System.out.println("The biggest value is " + heap.pop());
					heap.print();
				}

			}
		};

		thread.start();
		Thread thread1 = new Thread() {
			public void run() {
				while (heap.getSize() != 0) {
					System.out.println("Second thread The biggest value is " + heap.pop());
					heap.print();
				}
			}
		};

		thread1.start();

		int[] array = new int[] { 5, 1, 7, 9, 10 };
		int[] array2 = new int[] { 10, 67, 15, 13, 20 };
		int[] mergeArray = heap.mergeToSortedArray(array, array2);
		System.out.println(Arrays.toString(mergeArray));

	}

}
