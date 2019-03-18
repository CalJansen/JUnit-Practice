package cse360assign3;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class OrderedIntListTest {

	@Test
	public void testConstructor() {
		OrderedIntList testClass = new OrderedIntList();
		int expectedSize = 10; // basic constructor automatically creates size 10
		assertTrue(expectedSize == testClass.size());
	}

	@Test
	public void testOverloadedConstructor() {
		OrderedIntList testClass = new OrderedIntList(15);
		int expectedSize = 15; // overloaded constructor accepts array size as a parameter
		assertTrue(expectedSize == testClass.size());
	}

	@Test
	public void testSize() {
		OrderedIntList testClass = new OrderedIntList(5);
		int expectedSize = 5;
		assertTrue(expectedSize == testClass.size());
	}

	@Test
	public void testLength() {
		OrderedIntList testClass = new OrderedIntList(5);
		testClass.insert(3);
		testClass.insert(4);
		testClass.insert(5);
		int expectedLength = 3; // length is the number of items in the array, not the total size
		assertTrue(expectedLength == testClass.length());
	}

	@Test
	public void testToString() {
		OrderedIntList testClass = new OrderedIntList(5);
		testClass.insert(3);
		testClass.insert(4);
		testClass.insert(5);
		String expectedString = "3 4 5";
		assertTrue(expectedString.equals(testClass.toString()));
	}

	@Test
	public void testInsert() {
		OrderedIntList testClass = new OrderedIntList(4);
		testClass.insert(5);
		testClass.insert(3);
		testClass.insert(4);
		testClass.insert(4);
		testClass.insert(2);
		testClass.insert(1);

		int expectedSize = 6; // array size should automatically increase by 50% when array is full
		int expectedLength = 5; // doesn't add the duplicate four
		String expectedString = "1 2 3 4 5"; // maintains ascending order

		assertTrue(expectedSize == testClass.size());
		assertTrue(expectedLength == testClass.length());
		assertTrue(expectedString.equals(testClass.toString()));
	}

	@Test
	public void testDelete() {
		OrderedIntList testClass = new OrderedIntList(6);
		testClass.insert(3);
		testClass.insert(4);
		testClass.insert(5);
		testClass.delete(4);

		int expectedSize = 3; // array size should automatically decrease by 50% when array is <50% full
		int expectedLength = 2; 
		String expectedString = "3 5";

		assertTrue(expectedSize == testClass.size());
		assertTrue(expectedLength == testClass.length());
		assertTrue(expectedString.equals(testClass.toString()));
	}
}
