/**
 * 
 */
package textgen;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

/**
 * @author UC San Diego MOOC team
 *
 */
public class MyLinkedListTester {

	private static final int LONG_LIST_LENGTH =10; 

	MyLinkedList<String> shortList;
	MyLinkedList<Integer> emptyList;
	MyLinkedList<Integer> longerList;
	MyLinkedList<Integer> list1;
	MyLinkedList<Integer> myList;
	
	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		// Feel free to use these lists, or add your own
	    shortList = new MyLinkedList<String>();
		shortList.add("A");
		shortList.add("B");
		emptyList = new MyLinkedList<Integer>();
		longerList = new MyLinkedList<Integer>();
		myList = new MyLinkedList<Integer>();
		myList.add(1);
		myList.add(2);
		for (int i = 0; i < LONG_LIST_LENGTH; i++)
		{
			longerList.add(i);
		}
		list1 = new MyLinkedList<Integer>();
		list1.add(65);
		list1.add(21);
		list1.add(42);
		
	}

	
	/** Test if the get method is working correctly.
	 */
	/*You should not need to add much to this method.
	 * We provide it as an example of a thorough test. */
	@Test
	public void testGet()
	{
		//test empty list, get should throw an exception
		try {
			emptyList.get(0);
			fail("Check out of bounds");
		}
		catch (IndexOutOfBoundsException e) {
			
		}
		
		// test short list, first contents, then out of bounds
		assertEquals("Check first", "A", shortList.get(0));
		assertEquals("Check second", "B", shortList.get(1));
		
		try {
			shortList.get(-1);
			fail("Check out of bounds");
		}
		catch (IndexOutOfBoundsException e) {
		
		}
		try {
			shortList.get(2);
			fail("Check out of bounds");
		}
		catch (IndexOutOfBoundsException e) {
		
		}
		// test longer list contents
		for(int i = 0; i<LONG_LIST_LENGTH; i++ ) {
			assertEquals("Check "+i+ " element", (Integer)i, longerList.get(i));
		}
		
		// test off the end of the longer array
		try {
			longerList.get(-1);
			fail("Check out of bounds");
		}
		catch (IndexOutOfBoundsException e) {
		
		}
		try {
			longerList.get(LONG_LIST_LENGTH);
			fail("Check out of bounds");
		}
		catch (IndexOutOfBoundsException e) {
		}
		
	}
	
	
	/** Test removing an element from the list.
	 * We've included the example from the concept challenge.
	 * You will want to add more tests.  */
	@Test
	public void testRemove()
	{
		int a = list1.remove(0);
		assertEquals("Remove: check a is correct ", 65, a);
		assertEquals("Remove: check element 0 is correct ", (Integer)21, list1.get(0));
		assertEquals("Remove: check size is correct ", 2, list1.size());
		
		// TODO: Add more tests here
	}
	
	/** Test adding an element into the end of the list, specifically
	 *  public boolean add(E element)
	 * */
	@Test
	public void testAddEnd()
	{
        // myList has 1,2 as entries
		try {
			myList.add(null);
			fail("Check null pointer");
		}
		catch (NullPointerException e) {
		}
		myList.add(3);
		assertEquals("Last element is 3", (Integer)3, myList.get(myList.size-1));
		assertEquals("Size has increased by 1", myList.size, 3);
	}

	
	/** Test the size of the list */
	@Test
	public void testSize()
	{
		int bigsize = 50000;
		MyLinkedList<Integer> bigList = new MyLinkedList<Integer>();
		for (int i=0; i<bigsize; i++) {
			bigList.add(i);
		}
		try {
			bigList.remove(-1);
			fail("Check out of bounds");
		}
		catch (IndexOutOfBoundsException e) {
		
		}
		try {
			bigList.remove(bigList.size);
			fail("Check out of bounds");
		}
		catch (IndexOutOfBoundsException e) {
		}
		assertEquals("Testing list size after adding elements", bigsize, bigList.size);
		bigList.remove(0);
		assertEquals("Testing list size after removing an element", bigsize-1, bigList.size);
		
	}

	
	
	/** Test adding an element into the list at a specified index,
	 * specifically:
	 * public void add(int index, E element)
	 * */
	@Test
	public void testAddAtIndex()
	{
		// myList has 1,2
		try {
			myList.add(-1, null);
			fail("Check out of bounds");
		}
		catch (IndexOutOfBoundsException e) {
		
		}
		try {
			myList.add(myList.size, null);
			fail("Check out of bounds");
		}
		catch (IndexOutOfBoundsException e) {
		}
		try {
			myList.add(0, null);
			fail("Check null pointer");
		}
		catch (NullPointerException e) {
		}
		int index = 1;
        myList.add(index,99);
		assertEquals("Add at index should push old node forward", (Integer)99, myList.get(1));
		assertEquals("The size should be 3", 3, myList.size);
	}
	
	/** Test setting an element in the list */
	@Test
	public void testSet()
	{
		try {
			myList.set(-1, null);
			fail("Check out of bounds");
		}
		catch (IndexOutOfBoundsException e) {
		
		}
		try {
			myList.set(myList.size, null);
			fail("Check out of bounds");
		}
		catch (IndexOutOfBoundsException e) {
		}
		try {
			myList.set(0, null);
			fail("Check null pointer");
		}
		catch (NullPointerException e) {
		}
	    myList.set(0, 99);
	    assertEquals("set first element to 99", (Integer)99, myList.get(0));
	}
	
	
	// TODO: Optionally add more test methods.
	
}
