package BinarySearch;

import java.text.DecimalFormat;

/*
 * author: Hongbin Deng
 */
public class BinarySearchAlogirthm {
	
	private int[] a=new int[] {1,2,3,4,5,6};
	
	public boolean BiSearch(int element) {
		int start=0;
		int end=a.length-1;
		int mid=start+(end-start)/2;
		while(start<=end) {
			if(a[mid]>element) {
				end=mid-1;			
				mid=start+((end-start)>>2);
			}
			else if(a[mid]<element) {
				start=mid+1;
				mid=start+((end-start)>>2);
			}
			else {
				return true;
			}
		}	
		return false;
	}
	
	public int findSmallestThan(int element) {
		int start=0;
		int end=a.length-1;
		int mid=start+(end-start)/2;
		while(start<=end) {
			if(a[mid]>=element) {
				end=mid-1;			
				mid=start+(end-start)/2;
			}
			else {
				if(a[mid+1]>=element) {
					return a[mid];
				}
				start=mid+1;
				mid=start+(end-start)/2;
			}
		
		}
			
		return -1;
	}
	
	private double getSqrt(double start,double end,double mid,double value) {
//		if(element*element==value) {
//			return element;
//		}
		if(value<0) {
			return -1;
		}
		if(Math.abs(end-start) < 1e-6) {
			return mid;
		}	
		
		mid=start+(mid-start)/2;
		
		if(mid*mid>value) {
			end=mid;
			mid=start+(end-start)/2;
		}
		else if(mid*mid<value) {
			start=mid;
			mid=start+(end-start)/2;
		}
		//DecimalFormat df = new DecimalFormat("0.000000");
		return getSqrt(start,end,mid,value);
	}
	
	public double sqrt(int value) {
		return getSqrt(0, value, 0, value);
	}
	
	//public call
	
	
	public static void main(String[] args) {
		BinarySearchAlogirthm search=new BinarySearchAlogirthm();
//		System.out.println(search.BiSearch(7));
//		System.out.println(search.findSmallestThan(3));
		System.out.println(search.sqrt(7));
		double a= 1.00001;
		double b=0.99999;
		System.out.println(Math.abs(a - b) <= 1e-4);
		
	}

}
