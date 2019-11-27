package com.wanggt.freedom.algorithm.study.sort;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Random;

import com.wanggt.freedom.algorithm.study.comparator.IntegerComparator;
import com.wanggt.freedom.algorithm.study.constant.SortType;
import com.wanggt.freedom.algorithm.study.util.ArrayUtil;

/**
 * 直接选择排序，是选择排序的一种。
 * @author freedom wang
 * @date 2018年3月22日下午7:09:35
 * @version 1.0
 */
public class StraightSelectionSort implements Sort {

	@Override
	public <T> void sort(T[] primaryArray, Comparator<T> comparator) {
		if (primaryArray == null) {
			throw new NullPointerException("The int array can't be null!");
		}

		if (primaryArray.length == 0) {
			return;
		}

		for (int i = 0; i < primaryArray.length - 1; i++) {
			// 求得第i+1次判断出的最小或最大数字
			int num = i;
			for (int j = i + 1; j < primaryArray.length; j++) {
				if (comparator.compare(primaryArray[num], primaryArray[j]) > 0) {
					num = j;
				}
			}

			// 将第i+1次判断出来的最小数字所在的位置跟第i个位置上的数据对调
			if (i != num) {
				T temp = primaryArray[i];
				primaryArray[i] = primaryArray[num];
				primaryArray[num] = temp;
			}
		}
	}
}
