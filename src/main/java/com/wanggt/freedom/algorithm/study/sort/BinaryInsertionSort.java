package com.wanggt.freedom.algorithm.study.sort;

import org.junit.Assert;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.wanggt.freedom.algorithm.study.util.ArrayBuilder;
import com.wanggt.freedom.algorithm.study.util.ExecutionTime;
import com.wanggt.freedom.algorithm.study.util.SortUtil;

/**
 * 折半插入排序，是直接插入排序的一种优化算法，利用了数组时有序的特点，进行折半快速定位插入位置。
 * @author freedom wang
 * @date 2018年3月22日下午7:09:35
 * @version 1.0
 */
public class BinaryInsertionSort implements Sort {
	private Logger logger = LoggerFactory.getLogger(BinaryInsertionSort.class);

	private int length = 1000;

	@Test
	@Override
	public void testSort() {
		// 生成整形数组
		int[] intArray = ArrayBuilder.getIntArray(length, 1, 51);
		
		testSort(intArray);

	}

	@Override
	public void testSort(int[] primaryArray) {
		// 进行排序
		ExecutionTime executionTime = new ExecutionTime();
		int[] sortResult = intSort(primaryArray);
		logger.info("折半插入排序长度为{}的数组，执行时间是：{}毫秒", primaryArray.length, executionTime.getTime());

		Assert.assertTrue(SortUtil.isSorted(sortResult));
	}

	/**
	 * 此方法通过折半插入排序算法对整形数组进行排序.
	 * @param primaryArray 待排序的整形数组
	 * @return
	 * @author freedom wang
	 * @date 2018年3月22日下午9:20:35
	 * @version 1.0
	 */
	public int[] intSort(int[] primaryArray) {
		if (primaryArray == null) {
			throw new NullPointerException("The int array can't be null!");
		}

		if (primaryArray.length == 0) {
			return primaryArray;
		}

		for (int i = 1; i < primaryArray.length; i++) {
			// 求得第i个值的插入位置
			int begin = 0;
			int end = i - 1;

			while (end >= begin) {
				int mid = (begin + end) / 2;
				if (primaryArray[mid] > primaryArray[i]) {
					end = mid - 1;
				} else {
					begin = mid + 1;
				}
			}

			// 将第i个值直接插入到正确的位置
			if (begin != i) {
				int temp = primaryArray[i];
				for (int index = i - 1; index >= begin; index--) {
					primaryArray[index + 1] = primaryArray[index];
				}
				primaryArray[begin] = temp;
			}
		}

		return primaryArray;
	}
}
