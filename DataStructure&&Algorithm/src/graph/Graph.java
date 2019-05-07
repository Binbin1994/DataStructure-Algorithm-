package graph;

import LinkedList.SingleList;
import StackAndQueue.Queue;

public class Graph {
	private SingleList[] list;
	private int v;

	public Graph(int count) {
		this.v = count;
		list = new SingleList[count];
		for (int i = 0; i < list.length; i++) {
			list[i] = new SingleList();
		}
	}

	public void addEdge(int s, int t) {
		list[s].add(t);
		/*
		 * the following is for double pointer graph
		 */
		//list[t].add(s);
	}

	public void sortByKahn() {
		int[] degree=new int[v];
		for(int i=0;i<v;i++) {
			for(int j=0;j<list[i].getSize();j++) {
				int vertex=list[i].getByIndex(j).getData();
				++degree[vertex];
			}
		}
		Queue queue = new Queue();
		Queue queue2 = new Queue();
		for(int i=0;i<degree.length;i++) {
			if(degree[i]==0) {
				System.out.println("the 0 degree vertex "+i);
				queue.add(i);
			}		
		}
		while(!queue.isEmpty()) {
			int vertex=queue.pop();
			System.out.println("the vertex is "+vertex);
			queue2.add(vertex);
			for(int i=0;i<list[vertex].getSize();i++) {
				int element=list[vertex].getByIndex(i).getData();
				--degree[element];
				if(degree[element]==0) queue.add(element);
			}
		}
		queue2.print();
		
	}

	public void bfs(int s, int t) {
		Queue queue = new Queue();
		queue.add(s);
		boolean[] element = new boolean[v];
		int[] pre = new int[v];
		element[s] = true;
		while (!queue.isEmpty()) {
			int vertex = queue.pop();
			System.out.println("the queue size is " + queue.getSize());
			System.out.println("The current vertex is " + vertex);
			for (int i = 0; i < list[vertex].getSize(); i++) {
				int data = list[vertex].getByIndex(i).getData();
				if (data == t) {
					pre[data] = vertex;
					System.out.println("found it, begin to print");
					printRoute(pre, data, s);
					return;
				} else {
					if (!element[data]) {
						pre[data] = vertex;
						element[data] = true;
						queue.add(data);
					}
				}
			}
		}
		System.out.println("not found");
	}

	private void printRoute(int[] array, int s, int t) {
		if (s == t) {
			System.out.println(s);
			return;
		}
		System.out.println(s);
		printRoute(array, array[s], t);
	}

	boolean found = false;

	public void dfs(int s, int t) {
		boolean[] dict = new boolean[v];
		dfsLoop(s, t, dict);
		if (found == true) {
			System.out.println("found it");
		}
		if (found == false) {
			System.out.println("not found");
		}
	}

	private void dfsLoop(int s, int t, boolean[] a) {
		System.out.println(s);
		if (s == t) {
			found = true;
			return;
		}
		if (found) {
			return;
		}
		if (a[s]) {
			System.out.println("it has been travelled");
			return;
		}
		a[s] = true;
		for (int i = 0; i < list[s].getSize(); i++) {
			int q = list[s].getByIndex(i).getData();
			dfsLoop(q, t, a);
		}

	}

	public static void main(String[] args) {
		Graph graph = new Graph(5);
		graph.addEdge(0, 1);
		graph.addEdge(0, 2);
		graph.addEdge(1, 2);
		graph.addEdge(2, 3);
		graph.addEdge(4,3);
		//graph.addEdge(2, 1);
		 graph.bfs(0, 3);
		// graph.dfs(0, 8);
		graph.sortByKahn();
	}

}
