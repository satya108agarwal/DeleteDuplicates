package com.cts;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import com.cts.facade.DeDupInterface;

public class DeDupImpl implements DeDupInterface {

	public Integer[] removeDuplicateUsingSet(Integer inputArr[], boolean maintainOrder) {
		if (inputArr == null)
			return null;
		if (inputArr.length < 2)
			return inputArr;
		Set<Integer> set = null;
		if (!maintainOrder)
			set = new HashSet<Integer>(inputArr.length);
		else
			// maintain order
			set = new LinkedHashSet<Integer>(inputArr.length);
		for (Integer integerVar : inputArr)
			set.add(integerVar);
		return (Integer[]) set.toArray(new Integer[set.size()]);
	}

	public Integer[] removeDupsUsingList(Integer inputArr[]) {
		if (inputArr == null)
			return null;
		if (inputArr.length < 2)
			return inputArr;
		List<Integer> orginalList = Arrays.asList(inputArr);
		List<Integer> dupsRemovedList = new ArrayList<Integer>(inputArr.length);
		for (Iterator<Integer> iterator = orginalList.iterator(); iterator.hasNext();) {
			Integer next = iterator.next();
			if (!dupsRemovedList.contains(next))
				dupsRemovedList.add(next);
		}
		return (Integer[]) dupsRemovedList.toArray(new Integer[dupsRemovedList.size()]);
	}

	public Integer[] removeDupsUsingStreams(Integer inputArr[]) {
		if (inputArr == null)
			return null;
		if (inputArr.length < 2)
			return inputArr;
		List<Integer> listWithDuplicates = Arrays.asList(inputArr);
		List<Object> listWithoutDuplicates = listWithDuplicates.stream().distinct()
				.collect(Collectors.toList());
		return (Integer[]) listWithoutDuplicates.toArray(new Integer[listWithoutDuplicates.size()]);
	}
}
