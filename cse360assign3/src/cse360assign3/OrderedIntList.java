package cse360assign3;

/**
 * Name: Callan Jansen Class ID: CSE360 #11369 Assignment #3 Description:
 * Updating the OrderedIntList class and JUnit practice.
 * 
 * The OrderedIntList class creates an integer array, has an insert() method to
 * add to the array, a delete() method to remove from the array, and has a
 * toString() method to return the contents in the form of a String.
 */

public class OrderedIntList {
	private int[] array; // holds the contents of our list
	private int counter; // counts the # of items in the list

	/**
	 * Class constructor that creates an array of size 10.
	 */
	OrderedIntList() {
		array = new int[10];
	}

	/**
	 * Overloaded constructor that creates an array of specified size.
	 * 
	 * @param size contains the new size of the array
	 */
	OrderedIntList(int size) {
		array = new int[size];
	}

	/**
	 * The insert method adds a new integer to the array.
	 * <p>
	 * This method inserts the new value into the existing array so that the list is
	 * maintained in ascending order. If the array is already full, the array size
	 * will be increased by 50%. Duplicate values will not be inserted. The
	 * "pointer" variable points to the location in the array that the new value
	 * will be inserted.
	 * 
	 * @param newValue this contains the integer value to be added to the list
	 */
	public void insert(int newValue) {
		int pointer = 0;

		if (counter == size()) {
			int newSize = size() + size() / 2;
			int[] temp = array;
			array = new int[newSize];
			for (int index = 0; index < temp.length; index++) {
				array[index] = temp[index];
			}

		}

		for (int index = 0; index < counter; index++) {
			if (newValue == array[index]) {
				counter--; // duplicates do not add to counter

				index = counter; // exit loop
			} else if (newValue < array[index]) {
				for (index = counter - 1; index > pointer - 1; index--) {
					if (index == size() - 1) {
						index--;
					}

					array[index + 1] = array[index];
				}

				index = counter; // exit loop
			} else {
				pointer++;
			}
		}

		if (pointer == size()) {
			pointer--;
		}

		if (counter < size()) {
			counter++;
		}

		array[pointer] = newValue;
	}

	/**
	 * The size method returns the total size of the array.
	 * 
	 * @return array.length contains the total size of the array.
	 */
	public int size() {
		return array.length;
	}

	/**
	 * The length method returns the current # of elements in the array.
	 * 
	 * @return counter contains the current # of elements.
	 */
	public int length() {
		return counter;
	}

	/**
	 * The delete method removes a value from the array.
	 * <p>
	 * This method also checks if the array is over 50% empty. If so, the array size
	 * is made smaller by 50% using integer arithmetic.
	 * 
	 * @param key contains the value to be deleted from t he array.
	 */
	public void delete(int key) {
		for (int index = 0; index < length(); index++) {
			if (key == array[index]) {
				for (int index2 = index; index2 < length() - 1; index2++) {
					array[index2] = array[index2 + 1];
				}

				counter--;
			}
		}

		if (size() > 2 * length()) {
			int newSize = size() / 2;
			int[] temp = array;
			array = new int[newSize];
			for (int index = 0; index < array.length; index++) {
				array[index] = temp[index];
			}
		}
	}

	/**
	 * The toString method returns a String with all of the contents of the array.
	 */
	public String toString() {
		String returnString = "";
		if (counter == 0) {
			return returnString;
		}

		for (int index = 0; index < counter; index++) {
			returnString = returnString + array[index];
			if (index != counter - 1) {
				returnString = returnString + " ";
			}
		}

		return returnString;
	}
}