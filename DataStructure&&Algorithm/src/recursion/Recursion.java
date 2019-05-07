package recursion;

public class Recursion {
	
	public int f(int n) {
		if(n==1) return 1;
		if(n==2) return 2;
		return f(n-1)+f(n-2);
	}
	public int fm(int n) {
		if(n==1) {
			return 1;
		}
		return n*fm(n-1);
		
	}
	
	public void permutation(char[] a,int start,int end) {
		if(start==end) {
			System.out.println(a);
			return;
		}
		else {
			for(int i=start;i<=end;i++) {
				swap(a,i,start);
				permutation(a,start+1,end);
				swap(a,start,i);
							
			}
		}
		
	}
	
	public void swap(char[] a,int i,int j) {
		char temp=a[i];
		a[i]=a[j];
		a[j]=temp;
	}
	

	public static void main(String[] args) {
		Recursion t=new Recursion();
//		System.out.println(t.f(5));
//		System.out.println(t.fm(5));
		char[] a=new char[] {'a','b','c','d'};
		t.permutation(a, 0, 3);
	}
}
