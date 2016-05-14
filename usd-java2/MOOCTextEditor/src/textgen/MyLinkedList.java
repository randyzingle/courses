package textgen;

import java.util.AbstractList;


/** A class that implements a doubly linked list
 * 
 * @author UC San Diego Intermediate Programming MOOC team
 *
 * @param <E> The type of the elements stored in the list
 */
public class MyLinkedList<E> extends AbstractList<E> {
	LLNode<E> head;
	LLNode<E> tail;
	int size;

	/** Create a new empty LinkedList */
	public MyLinkedList() {
		head = new LLNode<E>(null);
		tail = new LLNode<E>(null);
		head.next = tail;
		tail.prev = head;
		size = 0;
	}
	
	// helper method, get the node at the given index
	private LLNode<E> getNode(int index) {
		LLNode<E> n = null;
		if (index < 0 || index >= size) throw new IndexOutOfBoundsException();
		// we have at least one node
		n = head.next;
		for (int i=0; i<index; i++) {
			n = n.next;
		}
		return n;
	}

	/**
	 * Appends an element to the end of the list
	 * @param element The element to add
	 */
	public boolean add(E element ) 
	{
		if (element == null) throw new NullPointerException();
		LLNode<E> n = new LLNode<E>(element);
		LLNode<E> old = tail.prev; // this is either head or a node
		old.next = n;
		n.prev = old;
		tail.prev = n;
		n.next = tail;
		size += 1;
		return false;
	}

	/** Get the element at position index 
	 * @throws IndexOutOfBoundsException if the index is out of bounds. */
	public E get(int index) 
	{
		if (index < 0 || index >= size) throw new IndexOutOfBoundsException();
		LLNode<E> n = getNode(index);
		return n.data;
	}

	/**
	 * Add an element to the list at the specified index
	 * @param The index where the element should be added
	 * @param element The element to add
	 */
	public void add(int index, E element ) 
	{
		if (element == null) throw new NullPointerException();
		if (index < 0 || index > size) throw new IndexOutOfBoundsException();
		LLNode<E> n = new LLNode<E>(element);
		LLNode<E> old = null;
		if (index == size) {
			old = tail;
		} else {
			old = getNode(index);
		}
		old.prev.next = n;
		n.prev = old.prev;
		old.prev = n;
		n.next = old;
		size += 1;
	}


	/** Return the size of the list */
	public int size() 
	{
		return size;
	}

	/** Remove a node at the specified index and return its data element.
	 * @param index The index of the element to remove
	 * @return The data element removed
	 * @throws IndexOutOfBoundsException If index is outside the bounds of the list
	 * 
	 */
	public E remove(int index) 
	{
		if (index < 0 || index >= size) throw new IndexOutOfBoundsException();
		LLNode<E> n = getNode(index);
		n.prev.next = n.next;
		n.next.prev = n.prev;
		E data = n.data;
		n = null;
		size = size - 1;
		return data;
	}

	/**
	 * Set an index position in the list to a new element
	 * @param index The index of the element to change
	 * @param element The new element
	 * @return The element that was replaced
	 * @throws IndexOutOfBoundsException if the index is out of bounds.
	 */
	public E set(int index, E element) 
	{
		if (element == null) throw new NullPointerException();
		if (index < 0 || index >= size) throw new IndexOutOfBoundsException();
		LLNode<E> n = getNode(index);
		E old = n.data;
		n.data = element;
		return old;
	}   
}

class LLNode<E> 
{
	LLNode<E> prev;
	LLNode<E> next;
	E data;

	// TODO: Add any other methods you think are useful here
	// E.g. you might want to add another constructor

	public LLNode(E e) 
	{
		this.data = e;
		this.prev = null;
		this.next = null;
	}

}
