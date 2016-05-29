package com.cts.facade;

public interface DeDupInterface {

	public Integer[] removeDuplicateUsingSet(Integer inputArr[], boolean maintainOrder);
	
	public  Integer[] removeDupsUsingList(Integer inputArr[]);
	
	public  Integer[] removeDupsUsingStreams(Integer inputArr[]);
	
}
