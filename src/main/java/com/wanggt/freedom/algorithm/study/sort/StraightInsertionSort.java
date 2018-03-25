package com.wanggt.freedom.algorithm.study.sort;

import java.util.Comparator;

import com.wanggt.freedom.algorithm.study.comparator.IntegerComparator;
import com.wanggt.freedom.algorithm.study.constant.SortType;
import com.wanggt.freedom.algorithm.study.util.ArrayUtil;

/**
 * 直接插入排序，是插入排序的一种。
 * @author freedom wang
 * @date 2018年3月22日下午7:09:35
 * @version 1.0
 */
public class StraightInsertionSort implements Sort {
	
	@Override
	public <T> T[] sort(T[] primaryArray, Comparator<T> comparator, SortType sortType) {
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
				if (comparator.compare(primaryArray[j], primaryArray[i]) > 0) {
					location = j;
				}
			}

			// 将第i个值直接插入到正确的位置
			if (location != i) {
				T temp = primaryArray[i];
				for (int index = i - 1; index >= location; index--) {
					primaryArray[index + 1] = primaryArray[index];
				}
				primaryArray[location] = temp;
			}
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
	public int[] sort(int[] primaryArray) {
		Integer[] integers = sort(ArrayUtil.convert(primaryArray), new IntegerComparator(), SortType.ASC);
		
		return ArrayUtil.convert(integers);
	}
}
