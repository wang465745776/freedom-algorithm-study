package com.wanggt.freedom.algorithm.study.sort;

import org.junit.Assert;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.wanggt.freedom.algorithm.study.util.ArrayBuilder;
import com.wanggt.freedom.algorithm.study.util.ExecutionTime;
import com.wanggt.freedom.algorithm.study.util.SortUtil;

/**
 * 直接选择排序，是选择排序的一种。
 * @author freedom wang
 * @date 2018年3月22日下午7:09:35
 * @version 1.0
 */
public class StraightSelectionSort {

	private Logger logger = LoggerFactory.getLogger(StraightSelectionSort.class);

	@Test
	public void testSort() {
		// 生成一个长度为10的整形数组，数值为0-50之间随机
		int[] intArray = ArrayBuilder.getIntArray(1000, 1, 51);

		// 进行排序
		ExecutionTime executionTime = new ExecutionTime();
		int[] sortResult = intSort(intArray);
		logger.info("直接选择排序长度为1000的数组，消耗时间是：{}毫秒", executionTime.getTime());

		Assert.assertTrue(SortUtil.isSorted(sortResult));
	}

	/**
	 * 此方法通过直接选择排序算法对整形数组进行排序
	 * @param primaryArray 待排序的整形数组
	 * @return
	 * @author freedom wang
	 * @date 2018年3月22日下午9:20:35
	 * @version 1.0
	 */
	public static int[] intSort(int[] primaryArray) {
		if (primaryArray == null) {
			throw new NullPointerException("The int array can't be null!");
		}

		if (primaryArray.length == 0) {
			return primaryArray;
		}

		for (int i = 0; i < primaryArray.length - 1; i++) {
			// 求得第i+1次判断出的最小数字
			int min = i;
			for (int j = i + 1; j < primaryArray.length; j++) {
				if (primaryArray[min] > primaryArray[j]) {
					min = j;
				}
			}

			// 将第i+1次判断出来的最小数字所在的位置跟第i个位置上的数据对调
			if (i != min) {
				int temp = primaryArray[i];
				primaryArray[i] = primaryArray[min];
				primaryArray[min] = temp;
			}
		}

		return primaryArray;
	}
}
