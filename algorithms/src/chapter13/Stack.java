package chapter13;

public class Stack<Item> {

	private Node first;
	private int N;
	private class Node{
		//定义结点
		Item item;
		Node next;
	}
	public void push(Item item){
		/*Node node = new Node();
		node.item = item;
		if(first != null)
			node.next = first;
		first = node;*/
		Node oldfirst = first;
		first = new Node();
		first.item = item;
		first.next = oldfirst;
		N++;
	}
	
	public Item pop(){
		Item item = first.item;
		first = first.next;
		N--;
		return item;
	}
	
	public boolean isEmpty(){
		return first == null;
	}
	
	public int size(){
		return N;
	}
	
	public static void main(String[] args) {
		Stack<Integer> stack = new Stack<Integer>();
		int[] a = {1,2,3,4};
		for(int i=0; i<4; i++)
			stack.push(a[i]);
		while(!stack.isEmpty())
			System.out.println(stack.pop());
		
		
	}
}
