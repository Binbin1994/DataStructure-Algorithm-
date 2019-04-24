package StackAndQueue;

public class Browser {
	private Stack one=new Stack(3);
	private Stack two= new Stack(3);
	public void push(String item) {
		one.push(item);
	}
	public String forward() {
		if(two.getSize()==0) {
			System.out.println("nothing to forward");
			return null;
		}
		String item=two.pop();
		one.push(item);
		return item;		
		
	}
	public String getCurrent() {
		return one.getLastElement();
	}
	public String backward() {
		if(one.getSize()==1||one.getSize()==0) {
			return null;
		}
		two.push(one.pop());
		return one.getLastElement();		
	}
	
	public static void main(String[] args) {
		Browser bw=new Browser();
		bw.push("1");
		bw.push("2");
		bw.push("3");
		System.out.println(bw.getCurrent());
		System.out.println(bw.backward());
		System.out.println(bw.backward());
		System.out.println(bw.getCurrent());
		System.out.println(bw.forward());
		System.out.println(bw.forward());
		System.out.println(bw.backward());
		System.out.println(bw.backward());

	}
	
}
