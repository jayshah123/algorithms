package ds;

import java.util.Iterator;
import java.util.NoSuchElementException;

//iterable multi set (just a linked list)
public class Bag<Item> implements Iterable<Item> {

	int N;// no of items
	private Node<Item> first; // beginning of bag

	// helper linked list class
	private static class Node<Item> {
		private Item item;
		private Node<Item> next;
	}

	public Bag() {
		first = null;
		N = 0;
	}

	public boolean isEmpty() {
		return first == null;
	}

	public int size() {
		return N;
	}

	//add item to the front of linked list
	public void add(Item item){
		Node<Item> oldfirst = first;
		first = new Node<Item>();
		first.item = item;
		first.next = oldfirst;
		N++;
	}
	
	@Override
	public Iterator<Item> iterator() {
		// TODO Auto-generated method stub
		return new BagItemIterator<Item>(first);
	}
	
	private class BagItemIterator<Item> implements Iterator<Item>{

		Node<Item> current;
		
		public BagItemIterator(Node<Item> first){
			current = first;
		}
		
		@Override
		public boolean hasNext() {
			return current!=null;
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

}
