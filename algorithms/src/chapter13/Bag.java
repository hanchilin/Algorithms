package chapter13;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class Bag<Item> implements Iterable<Item>{

	private Node first;
	private class Node {
		Item item;
		Node next;
	}
	
	public void add(Item item){
		Node oldfirst = first;
		first = new Node();
		first.item = item;
		first.next = oldfirst;
	}
	
	@Override
	public Iterator<Item> iterator() {
		return new ListIterator();
	}	
	
	private class ListIterator implements Iterator<Item>{

		private Node current = first;

		@Override
		public boolean hasNext() {			
			return current != null;
		}

		@Override
		public Item next() {
			if (!hasNext()) throw new NoSuchElementException();
			Item item = current.item;
			current = current.next;
			return item;
		}

		@Override
		public void remove() {
			throw new UnsupportedOperationException();
		}		
	}
	
	public static void main(String[] args) {
		Bag<Integer> bag = new Bag<Integer>();
		int[] a = {1,2,3,4,5,6};
		for(int i=0; i<a.length; i++)
			bag.add(a[i]);		

		for(int i : bag)
			System.out.println(i);
		System.out.println("===================");
			
	}
}
