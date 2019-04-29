package TrieTree;

/*
 * author: Hongbin Deng
 * The sample implementation of TrieTree
 * 
 */
public class TrieTree {
	private TrieNode root = new TrieNode('/');

	public void insert(char[] string) {
		TrieNode head = root;
		for (int i = 0; i < string.length; i++) {
			int index = string[i] - 'a';
			if (head.children[index] == null) {
				TrieNode newNode = new TrieNode(string[i]);
				head.children[index] = newNode;
			}
			head = head.children[index];
		}
		head.isEndingChar = true;
	}

	public boolean find(char[] string) {
		TrieNode node=root;

		for(int i=0;i<string.length;i++) {
			int index=string[i]-'a';
			if(node.children[index]==null) {
				return false;
			}
			node=node.children[index];
			
		}
		if(node.isEndingChar==true) {
			return true;
		}
		return false;	
		
	}

	/*
	 * Recursively print the tree
	 */
	public void print(char[] letter) {
		TrieNode head = root;
		for (int i = 0; i < letter.length; i++) {
			int index = letter[i] - 'a';
			if (head.children[index] == null) {
				System.out.println("there is no that prefix");
				return;
			}
			head = head.children[index];
		}
		System.out.println("ready for print");
		recursivePrint(head);

	}

	public void recursivePrint(TrieNode node) {
		if (node.isEndingChar == true) {
			System.out.println("print a new word");
			return;
		}

		for (int i = 0; i < node.children.length; i++) {
			if (node.children[i] != null) {
				System.out.println(node.children[i].getData());
				recursivePrint(node.children[i]);
			}
		}

	}

	public class TrieNode {
		public char data;
		public TrieNode[] children = new TrieNode[26];
		public boolean isEndingChar = false;

		public TrieNode(char data) {
			this.data = data;
		}

		public char getData() {
			return data;
		}

	}

	public static void main(String[] args) {

		TrieTree tree=new TrieTree();
		System.out.println(System.currentTimeMillis());
		tree.insert(new char[] {'h','e','l','l','o'});
		tree.insert(new char[] {'h','e','g','w','r'});
		tree.insert(new char[] {'h','e','g','g','r'});
		//tree.insert(new char[] {'h','e','g','w','r'});
		//tree.print(new char[] {'h','e'});
		boolean value=tree.find(new char[] {'h','e','g','w','r'});
		System.out.println(value);
		System.out.println(System.currentTimeMillis());
	}

}
