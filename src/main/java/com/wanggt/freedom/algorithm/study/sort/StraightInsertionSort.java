package com.wanggt.freedom.algorithm.study.sort;

import java.util.Comparator;

/**
 * 直接插入排序，是插入排序的一种。
 * @author freedom wang
 * @date 2018年3月22日下午7:09:35
 * @version 1.0
 */
public class StraightInsertionSort implements Sort {
	
	@Override
	public <T> void sort(T[] primaryArray, Comparator<T> comparator) {
		if (primaryArray == null) {
			throw new NullPointerException("The int array can't be null!");
		}

		if (primaryArray.length == 0) {
			return;
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
	}
}
