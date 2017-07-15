package util;

public class NodeTester {

	public static void main(String[] args) {
		LinkedList<Integer> ll = new LinkedList<Integer>();
		ListNode<Integer> n = new ListNode<Integer>(1);
		ll.add(n);
		for (int i=2; i<=10; i++) {
			n = new ListNode<Integer>(i);
			ll.add(n);
		}
		System.out.println(ll);
		
		ll.set(5, new ListNode<Integer>(99));
		System.out.println(ll);
		ll.set(0, new ListNode<Integer>(99));
		ll.set(99, new ListNode<Integer>(99));
		
		ll.set(1, new ListNode<Integer>(99));
		ll.set(10, new ListNode<Integer>(99));
		System.out.println(ll);
		
		ll.remove(5);
		System.out.println(ll);
	}

}
