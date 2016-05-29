package com.cts;

import static org.junit.Assert.*;
import org.junit.Test;
import com.cts.facade.DeDupInterface;

public class DeDupTest {
	@Test
	public void testAllImplementationsForNull() throws NumberFormatException, Exception {
		Integer inputArr[] = null;
		DeDupInterface deDup = new DeDupImpl();
		assertNull(deDup.removeDuplicateUsingSet(inputArr, true));
		assertNull(deDup.removeDuplicateUsingSet(inputArr, false));
		assertNull(deDup.removeDupsUsingList(inputArr));
		assertNull(deDup.removeDupsUsingStreams(inputArr));
	}

	@Test
	public void testAllImplementationsForSingleElementArray() throws NumberFormatException, Exception {
		Integer inputArr[] = { 1 };
		Integer expectedArr[] = { 1 };
		DeDupInterface deDup = new DeDupImpl();
		assertArrayEquals(expectedArr, deDup.removeDuplicateUsingSet(inputArr, true));
		assertArrayEquals(expectedArr, deDup.removeDuplicateUsingSet(inputArr, false));
		assertArrayEquals(expectedArr, deDup.removeDupsUsingList(inputArr));
		assertArrayEquals(expectedArr, deDup.removeDupsUsingStreams(inputArr));
	}

	@Test
	public void testAllImplementationsForLargeArray() throws NumberFormatException, Exception {
		Integer inputArr[] = { 3, 5, 1, 2, 2, 4, 6, 5, 7 };
		Integer expectedArrOrder[] = { 3, 5, 1, 2, 4, 6, 7 };
		Integer expectedArrIgnoreOrder[] = { 1, 2, 3, 4, 5, 6, 7 };
		DeDupInterface deDup = new DeDupImpl();
		assertArrayEquals(expectedArrOrder, deDup.removeDuplicateUsingSet(inputArr, true));
		assertArrayEquals(expectedArrIgnoreOrder, deDup.removeDuplicateUsingSet(inputArr, false));
		assertArrayEquals(expectedArrOrder, deDup.removeDupsUsingList(inputArr));
		assertArrayEquals(expectedArrOrder, deDup.removeDupsUsingStreams(inputArr));

	}

}
