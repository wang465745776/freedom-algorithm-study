package com.wanggt.freedom.algorithm.study;

import org.junit.Assert;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.wanggt.freedom.algorithm.study.sort.BinaryInsertionSort;
import com.wanggt.freedom.algorithm.study.sort.StraightInsertionSort;
import com.wanggt.freedom.algorithm.study.sort.StraightSelectionSort;
import com.wanggt.freedom.algorithm.study.util.ArrayBuilder;
import com.wanggt.freedom.algorithm.study.util.ExecutionTime;
import com.wanggt.freedom.algorithm.study.util.SortUtil;

/**
 * 此类用于测试各种排序算法
 * @author freedom wang
 * @date 2018年3月23日下午5:10:52
 * @version 1.0
 */
public class SortTest {
	private Logger logger = LoggerFactory.getLogger(SortTest.class);

	private int length = 5000;

	@Test
	public void testSort() {
		// 生成一个整形数组
		int[] intArray = ArrayBuilder.getIntArray(length, 1, 51);

		// 测试直接插入排序算法
		testStraightInsertionSort(intArray.clone());

		// 测试折半插入排序算法，速度明显比直接插入排序算法更快
		testBinaryInsertionSort(intArray.clone());

		// 测试直接选择排序
		testStraightSelectionSort(intArray.clone());
	}

	/**
	 * 测试直接选择排序
	 * @param primaryArray
	 * @author freedom wang
	 * @date 2018年3月25日上午11:22:39
	 * @version 1.0
	 */
	public void testStraightSelectionSort(int[] primaryArray) {
		// 进行排序
		ExecutionTime executionTime = new ExecutionTime();
		int[] sortResult = new StraightSelectionSort().sort(primaryArray);
		logger.info("直接选择排序长度为{}的数组，消耗时间是：{}毫秒", primaryArray.length, executionTime.getTime());

		Assert.assertTrue(SortUtil.isSorted(sortResult));
	}
	
	/**
	 * 测试折半插入排序
	 * @param primaryArray
	 * @author freedom wang
	 * @date 2018年3月25日上午11:24:43
	 * @version 1.0
	 */
	public void testBinaryInsertionSort(int[] primaryArray) {
		// 进行排序
		ExecutionTime executionTime = new ExecutionTime();
		int[] sortResult = new BinaryInsertionSort().sort(primaryArray);
		logger.info("折半插入排序长度为{}的数组，执行时间是：{}毫秒", primaryArray.length, executionTime.getTime());

		Assert.assertTrue(SortUtil.isSorted(sortResult));
	}
	
	/**
	 * 测试直接插入排序
	 * @param primaryArray
	 * @author freedom wang
	 * @date 2018年3月25日上午11:31:48
	 * @version 1.0
	 */
	public void testStraightInsertionSort(int[] primaryArray) {
		StraightInsertionSort straightInsertionSort = new StraightInsertionSort();
		// 进行排序
		ExecutionTime executionTime = new ExecutionTime();
		int[] sortResult = straightInsertionSort.sort(primaryArray);
		logger.info("直接插入排序长度为{}的数组，执行时间是：{}毫秒", primaryArray.length, executionTime.getTime());

		Assert.assertTrue(SortUtil.isSorted(sortResult));

		// 直接插入排序在越有序的数组中运行速度就越快，因为大量的数据本来就来对的位置上
		int[] intArray3 = ArrayBuilder.getNearlyOrderlyIntArray(primaryArray.length, 0);
		// 进行排序
		executionTime.refreshTime();
		int[] sortResult3 = straightInsertionSort.sort(intArray3);
		logger.info("直接插入算法排序近乎有序的长度为{}的数组，执行时间是：{}毫秒", primaryArray.length, executionTime.getTime());
		Assert.assertTrue(SortUtil.isSorted(sortResult3));
	}
}
