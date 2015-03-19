package chapter13;

public class Queue<Item> {

	private Node first;
	private Node last;
	private int N;
	private class Node{
		Item item;
		Node next;
	}
	
	public void enqueue(Item item){
		Node oldlast = last;
		last = new Node();
		last.item = item;
		last.next = null;
		if(first == null)
			first = last;
		else
			oldlast.next = last;
		N++;
	}
	
	public Item dequeue(){
		Item item = first.item;
		first = first.next;
		if(isEmpty())
			last = null;
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
		Queue<Integer> queue = new Queue<Integer>();
		int[] a = {1,2,3,4,5};
		for(int item : a)
			queue.enqueue(item);
		while(!queue.isEmpty())
			System.out.println(queue.dequeue());
	}
}
