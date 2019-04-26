package TrieTree;

public class TrieTree {
	private TrieNode root=new TrieNode("/");
	
	public void insert(String string) {
		
		
		
		
		
		
		
	}
	
	public boolean find() {
		
		
		
		
		
		
		
		
		return false;
	}
	
	
	
	
	
	public class TrieNode{
		public String data;
		public TrieNode[] children=new TrieNode[26];
		public boolean isEndingChar=false;
		public TrieNode(String data) {
			this.data=data;
		}	
		public String getData() {
			return data;
		}
		
	}
	
	public static void main(String[] args) {
		
	}
	
}
