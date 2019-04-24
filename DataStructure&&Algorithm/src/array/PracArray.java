package array;

public class PracArray {
	private int size;
	private int capacity;
	private int head=0;
	private int tail=0;
	private int[] items;
	public PracArray(int capacity) {
		this.capacity=capacity;
		items=new int[capacity];
	}
	
	public void add(int element) {
		if(tail>=capacity) {
			int newCapacity=capacity<<1;
			int[] newItems=new int[newCapacity];
			for(int i=0;i<items.length;i++) {
				newItems[i]=items[i];
			}
			this.items=newItems;
			this.capacity=newCapacity;
		}
		if(tail==0) {
			items[head]=element;
			++tail;
			++size;
		}
		else {
		    items[tail]=element;
		    ++size;
		    ++tail;
		}
	}
	
	
	public void updateByIndex(int index,int element) {
		if(tail==0||index>=size) {
			return;
		}
		items[index]=element;
		
	}
	
	public void deleteByIndex(int index) {
		if(tail==0||index>=size) {
			return;
		}
		for(int i=index;i<tail-1;i++) {
			items[i]=items[i+1];	
		}
		--tail;
		--size;
		if(size<capacity>>1) {
			int newCapacity=capacity>>1;
			int[] newItems=new int[newCapacity];
			for(int i=0;i<size;i++) {
				newItems[i]=items[i];
			}
			this.items=newItems;
			this.capacity=newCapacity;
		}
		
		
		//items[index]=0;
	}
	
	
	public int getSize() {
		System.out.println("size is");
		System.out.println(items.length);
		return size;
	}
	public String toString() {
		for(int i=0;i<tail;i++)
		{		
			System.out.println(items[i]);
		}
		return "loop done";
	}
	
	public int[] mergeArray(int[] array1,int[] array2) {
		int pos=0;
		int pos2=0;
		int count=0;
		int[] newArray=new int[array1.length+array2.length];
	    while(pos<array1.length&&pos2<array2.length) {
	    	if(array1[pos]<array2[pos2]) {
	    		newArray[count]=array1[pos];
	    		++pos;
	    		++count;
	    	}
	    	else {
	    	    newArray[count]=array2[pos2];
	    	    ++count;
	    	    ++pos2;
	    	}
	    }

	    if(pos<array1.length) {
	    	while(pos<array1.length) {
	    		newArray[count]=array1[pos];
	    		++pos;
	    		++count;
	    	}
	    }
	    if(pos2<array2.length) {
	    	while(pos2<array2.length) {
	    		newArray[count]=array2[pos2];
	    		++pos2;
	    		++count;
	    	}
	    }
	    for(int i=0;i<newArray.length;i++)
		{		
			System.out.println(newArray[i]);
		}
	    
	    return newArray;
			
	}
		
	public static void main(String[] args) {
		PracArray array=new PracArray(10);
	    int[] temp=new int[] {
	       4,6,8,10
	    };
	    int[] temp1=new int[] {
	 	       5,7,9,11
	 	    };
	    array.mergeArray(temp, temp1);	
	}
	
}
