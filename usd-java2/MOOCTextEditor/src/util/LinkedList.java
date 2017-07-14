package util;

public class LinkedList<E> {

	public ListNode<E> head;
	public ListNode<E> tail;
	public int size;
	public LinkedList() {
		size = 0;
	}
	
	public ListNode<E> get(int index) {
		if (index < 0 || index > size) return null; // throw an exception
		ListNode<E> node = null;
		if (index == 1) {
			node = head;
		} else if (index == size) {
			node = tail;
		} else {
			node = head;
			for (int i = 2; i <= index; i++) {
				node = node.next;
			}
		}
		return node;
	}
	
	// set replaces the node at the index with a new node
	public void set(int index, ListNode<E> node) {
		if (index > size) return;
		// get the node at the index
		ListNode<E> n = get(index);
		node.next = n.next;
		node.prev = n.prev;
		if (n == head) head = node;
		if (n == tail) tail = node;
		if (n.prev != null) n.prev.next = node;
		if (n.next != null) n.next.prev = node;
	}
	
	public void add(ListNode<E> node) {
		if (size == 0) {
			// creating a new linked list
			head = node;
			tail = node;
		} else {
			ListNode<E> n = tail;
			node.prev = n;
			n.next = node;
			tail = node;
		} 
		size += 1;
	}
	
	public ListNode<E> remove(int index) {
		if (index <= 0 || index > size) return null;
		ListNode<E> n = get(index);
		if (size == 1) {
			head = null;
			tail = null;
		} else if (n == head) {
			n.next.prev = null;
			head = n.next;
		} else if (n == tail) {
			n.prev.next = null;
			tail = n.prev;
		} else {
			n.prev.next = n.next;
			n.next.prev = n.prev;
			n = null;
		}
		size -= 1;
		return n;
		
	}
	
	public ListNode<E> getHead() {
		return head;
	}
	public void setHead(ListNode<E> head) {
		this.head = head;
	}
	public ListNode<E> getTail() {
		return tail;
	}
	public void setTail(ListNode<E> tail) {
		this.tail = tail;
	}
	public int getSize() {
		return size;
	}
	public void setSize(int size) {
		this.size = size;
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("size: " + size +", data: ");
		for (int i=1; i<size; i++) {
			sb.append(get(i).data + " - ");
		}
		sb.append(get(size).data);
		return sb.toString();
	}
	
	
}
