package Sorting;

import java.util.Arrays;

public class SortingAlgorithm {

	public void bubbleSort(int[] a) {
		for (int i = 0; i < a.length; i++) {
			boolean tag = false;
			for (int j = 0; j < a.length - 1 - i; j++) {
				if (a[j] > a[j + 1]) {
					swap(a, j, j + 1);
					tag = true;
				}
			}
			if (!tag) {
				break;
			}
		}

	}

	public void selectSort(int[] a) {
		for (int i = 0; i < a.length - 1; i++) {
			int min = i;
			for (int j = i + 1; j < a.length; j++) {
				if (a[j] < a[min]) {
					min = j;
				}
			}
			if (min != i) {
				swap(a, i, min);
			}
		}
	}

	public void insertSort(int[] a) {
		for (int i = 1; i < a.length; i++) {
			int j;
			int temp=a[i];
			for (j = i - 1; j >= 0; j--) {
				if (temp > a[j]) {
					break;
				}
				a[j+1]=a[j];
			}
			
			a[j+1]=temp;
			
		}
	}
	
	public void quickSortTrigger(int[] a) {
		quickSort(a, 0, a.length-1);
	}
	
	public void quickSort(int[] a, int p, int q) {
		if(p>=q) {
			return;
		}
		int division=partition(a,p,q);
		quickSort(a, p, division-1);
		quickSort(a, division+1, q);
				
	}
	
	public int partition(int[] a,int p,int q) {
		int d=a[q];
		int pos=p;
		
		for(int i=p;i<q;i++) {
			if (a[i]<d) {
				if(pos==i) {
					++pos;
				}
				else {
					swap(a, pos, i);
					++pos;
				}
			
			}
		}	
		swap(a,pos,q);	
		return pos;
	}
	
	
	public void mergeSortBegin(int[] a) {
		mergeSort(a,0,a.length-1);
	}
	
	
	private void mergeSort(int[] a,int p,int q) {
		 if(p>=q) {
			 return;
		 }
		 int mid=p+(q-p)/2;
		 mergeSort(a,p,mid);
		 mergeSort(a,mid+1,q);
		 merge(a,p,mid,q);
		 	
	}
	
	private void merge(int[] a,int p,int m,int q) {
		int posOne=p;
		int posTwo=m+1;
		int[] copyArray=new int[q-p+1];
		int k=0;
		while(posOne<=m&&posTwo<=q) {
			if(a[posOne]<a[posTwo]) {
				copyArray[k]=a[posOne];
				++posOne;
				++k;
			}
			else {
				copyArray[k]=a[posTwo];
				++posTwo;
				++k;
			}
		}
		
		int start=posOne;
		int end=m;
		if(posTwo<=q) {
			start=posTwo;
			end=q;
		}
		
		while(start<=end) {
			copyArray[k++]=a[start++];
		}
		
		for(int i=0;i<=q-p;i++) {
			a[p+i]=copyArray[i];
		}
				
	}
	
	private void swap(int[] a, int i, int j) {
		int temp = a[i];
		a[i] = a[j];
		a[j] = temp;
	}

	public static void main(String[] args) {
		SortingAlgorithm sort = new SortingAlgorithm();
		System.out.println(System.currentTimeMillis());
		int[] a = new int[] { 2, 3, 1,5,7,6,19,16 };
//		sort.bubbleSort(a);
//		sort.selectSort(a);
//		sort.insertSort(a);
//		sort.mergeSortBegin(a);
//		sort.quickSortTrigger(a);
		System.out.println(Arrays.toString(a));
		System.out.println(System.currentTimeMillis());
	}

}
