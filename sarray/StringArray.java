/*
 * Name: Adam Mohr
 * Student ID: 040669681
 * Course & Section: CST8132 301
 * Assignment: Lab 6
 * Date: Nov 4, 2018
 */

package cst8132.sarray;

/**
 * A StringArray class based loosely on the Java List interface without using
 * any Java List classes or subclasses.
 * 
 * @author Adam Mohr
 * @version 1.0
 * @since 1.8
 */
public class StringArray {

	private int capacity; // Current capacity of array. I chose to use capacity() instead.

	private int size; // Current size of array. I chose to use size() instead.

	private String[] stringArray; // Current StringArray.

	/**
	 * Default constructor, instantiates an empty StringArray with an initial
	 * capacity of ten.
	 */
	public StringArray() {
		stringArray = new String[10];

		for (int i = 0; i < stringArray.length; i++) {
			stringArray[i] = "";
		}
	}

	/**
	 * Initial constructor, instantiates a StringArray with desired capacity.
	 * 
	 * @param initialCapacity constructs an empty StringArray with the specified
	 *                        capacity.
	 * 
	 * @throws IllegalArgumentException if the specified initial capacity is
	 *                                  negative.
	 */
	public StringArray(int initialCapacity) throws IllegalArgumentException {
		if (initialCapacity < 0) {
			throw new IllegalArgumentException();
		}

		stringArray = new String[initialCapacity];

		for (int i = 0; i < initialCapacity; i++) {
			stringArray[i] = "";
		}
	}

	/**
	 * Copy constructor, instantiates a StringArray that is a copy of a given
	 * StringArray.
	 * 
	 * @param copy StringArray object.
	 * @throws NullPointerException if copy is null.
	 */
	public StringArray(StringArray copy) throws NullPointerException {
		if (copy == null) {
			throw new NullPointerException();
		}

		stringArray = copy.stringArray;
		copy.size();
		copy.capacity();
		for (int i = 0; i < copy.size(); i++) {
			stringArray[i] = get(i);
		}
	}

	/**
	 * Append the specified string to the end of this StringArray. Increases
	 * capacity if needed.
	 * 
	 * @param s String to add.
	 * @throws NullPointerException if String s is null.
	 */
	public void add(String s) throws NullPointerException {
		if (s == null) {
			throw new NullPointerException();
		}

		if (this.size() >= this.capacity()) {
			ensureCapacity(capacity() + 1);

		}
		stringArray[this.size()] = s;
	}

	/**
	 * Insert the specified string at the specified position in this StringArray.
	 * Increases capacity if needed.
	 * 
	 * @param index position to insert at.
	 * @param s     String to add.
	 * @throws IndexOutOfBoundsException if index is less than 0 or greater than
	 *                                   size.
	 * @throws NullPointerException      if String s is null.
	 */
	public void add(int index, String s) throws IndexOutOfBoundsException, NullPointerException {
		if (index < 0 || index > size()) {
			throw new IndexOutOfBoundsException();
		}

		if (s == null) {
			throw new NullPointerException();
		}

		if (index >= this.capacity()) {
			ensureCapacity(index);
		}

		System.arraycopy(stringArray, index, stringArray, index + 1, capacity() - index - 1);
		stringArray[index] = s;
	}

	/**
	 * Return the capacity of this StringArray.
	 * 
	 * @return capacity length of this StringArray.
	 */
	public int capacity() {
		return stringArray.length;
	}

	/**
	 * Remove all of the Strings from this StringArray.
	 */
	public void clear() {
		for (int i = 0; i < stringArray.length; i++) {
			stringArray[i] = "";
		}
	}

	/**
	 * Return true if this StringArray contains the specified String.
	 * 
	 * @param s String to check for.
	 * @return true if this StringArray contains the specified String.
	 * @throws NullPointerException if String s is null.
	 */
	public boolean contains(String s) throws NullPointerException {
		if (s == null) {
			throw new NullPointerException();
		}

		for (String element : stringArray) {
			if (element.equals(s)) {
				return true;
			}
		}
		return false;
	}

	/**
	 * Ensure that it can hold at least the number of Strings specified by the
	 * minimum capacity argument.
	 * 
	 * @param minCapacity required in this StringArray.
	 * @throws CapacityOutOfBoundsException if specified capacity is less than or
	 *                                      equal to the StringArray size.
	 */
	public void ensureCapacity(int minCapacity) throws CapacityOutOfBoundsException {
		if (minCapacity <= size()) {
			throw new CapacityOutOfBoundsException();
		}

		// Ensure capacity - iterate through, whatever is left, set to empty string.
		if (minCapacity < capacity()) {
			return;
		}

		String[] tempArray = new String[minCapacity];

		for (int i = 0; i < capacity(); i++) {
			tempArray[i] = stringArray[i];
		}
		stringArray = tempArray;
	}

	/**
	 * Return the index of the first occurrence of the specified String in this
	 * StringArray, or null if this StringArray does not contain the String.
	 * 
	 * @param index of specified String if it exists.
	 * @return index if String is present or null if it is not.
	 * @throws IndexOutOfBoundsException if index is less than 0 or greater than
	 *                                   size of StringArray.
	 */
	public String get(int index) throws IndexOutOfBoundsException {
		if (index < 0 || index > size()) {
			throw new IndexOutOfBoundsException();
		}

		// check if index is less than -1 and greater than size, return null
		if (index < -1 && index > size()) {
			return null;
		}
		return stringArray[index];
	}

	/**
	 * Return the index of the first occurrence of the specified String in this
	 * StringArray, or -1 if this StringArray does not contain the String.
	 * 
	 * @param s String to check for
	 * @return index if String occurs or -1 if it does not.
	 * @throws NullPointerException is String is null.
	 */
	public int indexOf(String s) throws NullPointerException {
		if (s == null) {
			throw new NullPointerException();
		}

		for (int i = 0; i < this.capacity(); i++) {
			if (stringArray[i].equals(s)) {
				return i;
			}
		}
		return -1;
	}

	/**
	 * Check to see if StringArray is currently empty.
	 * 
	 * @return true if this StringArray contains no Strings.
	 */
	public boolean isEmpty() {
		// Iterate through, !isEMpty, return false, else return true
		for (int i = 0; i < stringArray.length; i++) {
			if (!stringArray[i].isEmpty()) {
				return false;
			}
		}
		return true;
	}

	/**
	 * Remove the String at the specified position in this StringArray.
	 * 
	 * @param index position to remove at.
	 * @return String previously at the specified position.
	 * @throws IndexOutOfBoundsException if index is less than 0 or greater than
	 *                                   size of StringArray.
	 */
	public String remove(int index) throws IndexOutOfBoundsException {
		if (index < 0 || index > size()) {
			throw new IndexOutOfBoundsException();
		}

		if (index < 0 || index > stringArray.length) {
			return null;
		}

		stringArray[index] = "";
		return stringArray[index];
	}

	/**
	 * Remove the first occurrence of the specified String from this StringArray, if
	 * it is present.
	 * 
	 * @param s String to check for.
	 * @return true if this StringArray contained the specified String.
	 * @throws NullPointerException if String is null.
	 */
	public boolean remove(String s) throws NullPointerException {
		if (s == null) {
			throw new NullPointerException();
		}

		int indexOfString = this.indexOf(s);

		if (indexOfString <= -1) {
			return false;
		}
		stringArray[indexOfString] = "";
		return true;
	}

	/**
	 * Replace the String at the specified position in this StringArray with the
	 * specified String. Increases capacity if needed.
	 * 
	 * @param index position in StringArray.
	 * @param s     String to set.
	 * @return String previously at the specified position.
	 * @throws IndexOutOfBoundsException if index is less than 0 or greater than
	 *                                   size of StringArray.
	 * @throws NullPointerException      if String is null.
	 */
	public String set(int index, String s) throws IndexOutOfBoundsException, NullPointerException {
		if (index < 0 || index > size()) {
			throw new IndexOutOfBoundsException();
		}

		if (s == null) {
			throw new NullPointerException();
		}

		String returnString = stringArray[index];

		if (index <= this.capacity()) {
			stringArray[index] = s;
		}
		return returnString;
	}

	/**
	 * Check size of this StringArray.
	 * 
	 * @return size of this StringArray.
	 */
	public int size() {
		// iterate through, !is Empty, increase total ++
		int total = 0;

		for (int i = 0; i < stringArray.length; i++) {
			if (!stringArray[i].isEmpty()) {
				total++;
			}
		}
		return total;
	}

}
