package com.wanggt.freedom.algorithm.study.sort;

import java.util.LinkedList;

import org.junit.Assert;
import org.junit.Test;

import com.wanggt.freedom.algorithm.study.util.ArrayBuilder;
import com.wanggt.freedom.algorithm.study.util.SortUtil;

/**
 * 直接插入排序，是插入排序的一种。
 * @author freedom wang
 * @date 2018年3月22日下午7:09:35
 * @version 1.0
 */
public class StraightInsertionSort {

	@Test
	public void testSort() {
		// 生成一个长度为10的整形数组，数值为0-50之间随机
		int[] intArray = ArrayBuilder.getIntArray(100, 1, 51);

		// 进行排序
		int[] sortResult = intSort(intArray);

		Assert.assertTrue(SortUtil.isSorted(sortResult));
		
		// 生成一个长度为10的整形数组，数值为0-50之间随机
		int[] intArray2 = ArrayBuilder.getIntArray(100, 1, 51);
		// 进行排序
		int[] sortResult2 = intSort2(intArray2);
		Assert.assertTrue(SortUtil.isSorted(sortResult2));
	}

	/**
	 * 此方法通过直接插入排序算法对整形数组进行排序.此实现使用了链表，查询慢，修改快
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

		// 将数组结构转换成链接结构
		LinkedList<Integer> list = new LinkedList<>();
		for (int i : primaryArray) {
			list.add(i);
		}

		for (int i = 1; i < primaryArray.length; i++) {
			// 求得第i个值所应该在的位置
			int location = i;
			for (int j = i - 1; j >= 0; j--) {
				if (list.get(j) > list.get(i)) {
					location = j;
				}
			}

			// 将第i个值直接插入到正确的位置
			if (location != i) {
				list.add(location, primaryArray[i]);
				list.remove(i + 1);
			}
		}

		// 将链表转换为数组
		for (int i = 0; i < list.size(); i++) {
			primaryArray[i] = list.get(i);
		}

		return primaryArray;
	}

	/**
	 * 此方法通过直接插入排序算法对整形数组进行排序.
	 * @param primaryArray 待排序的整形数组
	 * @return
	 * @author freedom wang
	 * @date 2018年3月22日下午9:20:35
	 * @version 1.0
	 */
	public static int[] intSort2(int[] primaryArray) {
		if (primaryArray == null) {
			throw new NullPointerException("The int array can't be null!");
		}

		if (primaryArray.length == 0) {
			return primaryArray;
		}

		for (int i = 1; i < primaryArray.length; i++) {
			// 求得第i个值所应该在的位置
			int location = i;
			for (int j = i - 1; j >= 0; j--) {
				if (primaryArray[j] > primaryArray[i]) {
					location = j;
				}
			}

			// 将第i个值直接插入到正确的位置
			if (location != i) {
				int temp = primaryArray[i];
				for (int index = i - 1; index >= location; index--) {
					primaryArray[index + 1] = primaryArray[index];
				}
				primaryArray[location] = temp;
			}
		}

		return primaryArray;
	}
}
