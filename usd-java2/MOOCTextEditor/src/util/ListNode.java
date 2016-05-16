package util;

public class ListNode<E> {
	public ListNode<E> next;
	public ListNode<E> prev;
	public E data;
	
	public ListNode(E data) {
		this.data = data;
	}
}
