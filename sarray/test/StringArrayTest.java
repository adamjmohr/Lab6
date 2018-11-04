/*
 * Name: Adam Mohr
 * Student ID: 040669681
 * Course & Section: CST8132 301
 * Assignment: Lab 6
 * Date: Nov 4, 2018
 */

package cst8132.sarray.test;

import cst8132.sarray.StringArray;
import cst8132.sarray.CapacityOutOfBoundsException;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class StringArrayTest {

	@Test
	public void DefaultConstructor_Initialized() {
		StringArray sA = new StringArray();

		assertFalse(sA.capacity() < 10);
		assertFalse(sA.capacity() > 10);

		assertTrue(sA.capacity() == 10);
		assertEquals(sA.capacity(), 10);
	}

	@Test
	public void InitialConstructor_Initialized() {
		StringArray sA = new StringArray(7);

		assertFalse(sA.capacity() < 7);
		assertFalse(sA.capacity() > 7);

		assertTrue(sA.capacity() == 7);
		assertEquals(sA.capacity(), 7);
	}

	@Test(expected = IllegalArgumentException.class)
	public void InitialConstructor_Negative_ExceptionThrown() {
		StringArray sA = new StringArray(-1);
	}

	@Test
	public void CopyConstructor_Initialized() {
		StringArray sA = new StringArray(5);
		sA.add("Adam");

		StringArray copy = new StringArray(sA);

		assertEquals(sA.capacity(), copy.capacity());
		assertEquals(sA.size(), copy.size());
		
		assertTrue(sA.contains("Adam"));
		assertTrue(copy.contains("Adam"));
		
	}

	@Test(expected = NullPointerException.class)
	public void CopyConstructor_Null_ExceptionThrown() {
		StringArray sA = new StringArray(null);
	}

	@Test
	public void addString() {
		StringArray sA = new StringArray();

		assertTrue(sA.size() == 0);

		sA.add("Adam");
		sA.add("Mohr");

		assertTrue(sA.size() == 2);
		assertTrue(sA.indexOf("Mohr") == 1);
	}

	@Test(expected = NullPointerException.class)
	public void addString_Null_ExceptionThrown() {
		StringArray sA = new StringArray();

		sA.add(null);
	}

	@Test
	public void addString_AtIndex() {
		StringArray sA = new StringArray();

		sA.add(0, "Adam");
		sA.add(1, "Mohr");

		assertTrue(sA.indexOf("Adam") == 0);
		assertTrue(sA.indexOf("Mohr") == 1);
	}

	@Test(expected = IndexOutOfBoundsException.class)
	public void addStringAtIndex_OutOfBounds_ExceptionThrown() {
		StringArray sA = new StringArray();

		sA.add(-1, "Adam");
		sA.add(10, "Mohr");
	}

	@Test(expected = NullPointerException.class)
	public void addStringAtIndex_Null_ExceptionThrown() {
		StringArray sA = new StringArray();

		sA.add(0, null);
	}

	@Test
	public void capacity() {
		StringArray sA = new StringArray(23);

		assertTrue(sA.capacity() == 23);
	}

	@Test
	public void clear() {
		StringArray sA = new StringArray();

		sA.add("Adam");
		sA.add("Mohr");

		sA.clear();

		assertTrue(sA.size() == 0);

		assertFalse(sA.contains("Adam"));
		assertFalse(sA.contains("Mohr"));
	}

	@Test
	public void containsString() {
		StringArray sA = new StringArray();

		sA.add("Adam");

		assertTrue(sA.contains("Adam"));

		assertFalse(sA.contains("Mohr"));
	}

	@Test(expected = NullPointerException.class)
	public void containsString_Null_ExceptionThrown() {
		StringArray sA = new StringArray();

		sA.contains(null);
	}

	@Test
	public void ensureCapacity() {
		StringArray sA = new StringArray();

		assertTrue(sA.capacity() == 10);

		sA.ensureCapacity(13);

		assertTrue(sA.capacity() == 13);

		assertFalse(sA.capacity() == 10);
	}

	@Test(expected = CapacityOutOfBoundsException.class)
	public void ensureCapacity_OutOfBounds_ExceptionThrown() {
		StringArray sA = new StringArray();

		sA.ensureCapacity(0);
	}

	@Test
	public void getIndex() {
		StringArray sA = new StringArray();

		sA.add("Adam");
		sA.add("Mohr");

		assertEquals("Adam", sA.get(0));
		assertEquals("Mohr", sA.get(1));
	}

	@Test(expected = IndexOutOfBoundsException.class)
	public void getIndex_OutOfBounds_ExceptionThrown() {
		StringArray sA = new StringArray();

		sA.add("Adam");

		sA.get(2);
		sA.get(-1);
	}

	@Test
	public void indexOf() {
		StringArray sA = new StringArray();

		sA.add("Adam");

		assertTrue(sA.indexOf("Adam") == 0);

		assertFalse(sA.indexOf("Adam") == 1);
		assertFalse(sA.indexOf("Mohr") == 0);
	}

	@Test(expected = NullPointerException.class)
	public void indexOf_Null_ExceptionThrown() {
		StringArray sA = new StringArray();

		sA.indexOf(null);
	}

	@Test
	public void isEmpty() {
		StringArray sA = new StringArray();

		assertTrue(sA.isEmpty());

		sA.add("Adam");

		assertFalse(sA.isEmpty());
	}

	@Test
	public void removeIndex() {
		StringArray sA = new StringArray();

		sA.add("Adam");
		sA.add("Mohr");

		assertTrue(sA.contains("Adam"));
		assertTrue(sA.contains("Mohr"));

		sA.remove(0);
		sA.remove(1);

		assertFalse(sA.contains("Adam"));
		assertFalse(sA.contains("Mohr"));
	}

	@Test(expected = IndexOutOfBoundsException.class)
	public void removeIndex_OutOfBounds_ExceptionThrown() {
		StringArray sA = new StringArray();

		sA.remove(-1);
		sA.remove(1);
	}

	@Test
	public void removeString() {
		StringArray sA = new StringArray();

		sA.add("Adam");
		sA.add("Mohr");

		assertTrue(sA.contains("Adam"));
		assertTrue(sA.contains("Mohr"));

		sA.remove("Adam");
		sA.remove("Mohr");

		assertFalse(sA.contains("Adam"));
		assertFalse(sA.contains("Mohr"));
	}

	@Test(expected = NullPointerException.class)
	public void removeString_Null_ExceptionThrown() {
		StringArray sA = new StringArray();

		sA.remove(null);
	}

	@Test
	public void set() {
		StringArray sA = new StringArray();

		sA.add("Adam");

		sA.set(0, "Mohr");

		assertTrue(sA.contains("Mohr"));
		assertFalse(sA.contains("Adam"));
	}

	@Test(expected = IndexOutOfBoundsException.class)
	public void set_OutOfBounds_ExceptionThrown() {
		StringArray sA = new StringArray();

		sA.set(-1, "Adam");
		sA.set(1, "Mohr");
	}

	@Test(expected = NullPointerException.class)
	public void set_Null_ExceptionThrown() {
		StringArray sA = new StringArray();

		sA.set(0, null);
	}

	@Test
	public void size() {
		StringArray sA = new StringArray();

		assertTrue(sA.size() == 0);

		sA.add("Adam");
		sA.add("Mohr");

		assertTrue(sA.size() == 2);
		assertFalse(sA.size() == 0);
	}

}
