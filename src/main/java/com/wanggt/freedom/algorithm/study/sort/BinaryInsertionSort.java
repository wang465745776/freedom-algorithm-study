package com.wanggt.freedom.algorithm.study.sort;

import java.util.Comparator;

import com.wanggt.freedom.algorithm.study.comparator.IntegerComparator;
import com.wanggt.freedom.algorithm.study.constant.SortType;
import com.wanggt.freedom.algorithm.study.util.ArrayUtil;

/**
 * 折半插入排序，是直接插入排序的一种优化算法，利用了数组时有序的特点，进行折半快速定位插入位置。
 * @author freedom wang
 * @date 2018年3月22日下午7:09:35
 * @version 1.0
 */
public class BinaryInsertionSort implements Sort {
	
	@Override
	public <T> T[] sort(T[] primaryArray, Comparator<T> comparator, SortType sortType) {
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
				if (comparator.compare(primaryArray[mid], primaryArray[i]) > 0) {
					end = mid - 1;
				} else {
					begin = mid + 1;
				}
			}

			// 将第i个值直接插入到正确的位置
			if (begin != i) {
				T temp = primaryArray[i];
				for (int index = i - 1; index >= begin; index--) {
					primaryArray[index + 1] = primaryArray[index];
				}
				primaryArray[begin] = temp;
			}
		}

		return primaryArray;
	}

	/**
	 * 此方法通过折半插入排序算法对整形数组进行排序.
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
