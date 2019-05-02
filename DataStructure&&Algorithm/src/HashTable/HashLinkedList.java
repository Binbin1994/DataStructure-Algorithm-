package HashTable;

import LinkedList.SingleList;
/*
 * author: Hongbin Deng
 */
/*
 * Example of implementing hashtable based on combination of array and linkedlist,
   The following example is not generic, and it only suits for integers
 */
public class HashLinkedList {
	private SingleList[] bucket;
	//private int default_capacity=10;
	private int capacity;
	private int size;
	public HashLinkedList() {
		capacity=10;
		bucket=new SingleList[capacity];
	}
	
	public HashLinkedList(int capacity) {
		this.capacity=capacity;
		bucket=new SingleList[capacity];
	}
	
	public void put(String key,int value) {
		
		int hash=hashcodeGeneric(key);
		if(size>=capacity) {
			int newCapacity=capacity<<1;
			SingleList[] newBucket=new SingleList[newCapacity];
			for(int i=0;i<bucket.length;i++) {
				newBucket[i]=bucket[i];
			}
			this.bucket=newBucket;
			this.capacity=newCapacity;
		}

		if(bucket[hash]==null) {
			bucket[hash]=new SingleList();
			++size;
		}	
		bucket[hash].add(value);	
			
	}
	
	public void get(String key) {
		int hash=hashcodeGeneric(key);
		if(key==null) return;
		if(bucket[hash]==null) return; 
		if(bucket[hash].getSize()==1) {
			bucket[hash].print();
		}
	}
	
	
	
	public void add(int element) {
		int hash=hashcode(element);
		if(size>=capacity) {
			int newCapacity=capacity<<1;
			SingleList[] newBucket=new SingleList[newCapacity];
			for(int i=0;i<bucket.length;i++) {
				newBucket[i]=bucket[i];
			}
			this.bucket=newBucket;
			this.capacity=newCapacity;
		}
		if(bucket[hash]==null) {
			bucket[hash]=new SingleList();
			++size;
		}
		bucket[hash].add(element);	
		
	}

	
	public void delete(int element) {
		if(size==0) {
			return;
		}
		int hash=hashcode(element);
		if(!bucket[hash].delete(element)) {
			System.out.println("element "+element+" not found");
			return;
		}		
	    if(bucket[hash].getSize()==0) {
	    	bucket[hash]=null;
	    	--size;
	    }
	    if(size<(capacity>>1)-5) {
	    	int newCapacity=capacity>>1;
			SingleList[] newBucket=new SingleList[newCapacity];
			int pos=0;
			for(int i=0;i<bucket.length;i++) {
				if(bucket[i]!=null) {
					newBucket[pos]=bucket[i];
					++pos;
				}
			}
			this.bucket=newBucket;
			this.capacity=newCapacity;
	    }
		
	}
	
	public boolean containsKey(int key) {
		return bucket[key]!=null?true:false;
	}
	
	public SingleList getByKey(int key) {
		if(!containsKey(key)) {
			return null;
		}
		return bucket[key];
	}
	
	public void ToString(int key) {
		System.out.println("print the table "+key);
		if(!containsKey(key)) {
			System.out.println("The table is null");
			return;
		}
		bucket[key].print();
	}
		
	public int getSize() {
		return size;
	}
	
	private int hashcode(int element) {
		return element%capacity;
	}
	
	/*
	 * 
	 * The implementation of hashcode algorithm for generic
	 */
	private int hashcodeGeneric(Object element) {
		//System.out.println((element.hashCode())^((element.hashCode())>>>16));
		return ((element.hashCode())^((element.hashCode())>>16))%capacity;
	}
	
	
	
	
	public static void main(String[] args) {
		HashLinkedList linekedHash=new HashLinkedList();
//		linekedHash.add(1);
//		linekedHash.add(11);
//		linekedHash.delete(11);
//		linekedHash.add(2);
//		linekedHash.add(12);
//		linekedHash.ToString(1);
//		linekedHash.ToString(2);
		linekedHash.put("sd", 1);
		linekedHash.put("sdasfas", 1);
		linekedHash.put("sdfafa", 1);
		linekedHash.put("sfasfagfd", 1);
		linekedHash.get("sd");
		//System.out.println(linekedHash.containsKey(1));	
	}
}
