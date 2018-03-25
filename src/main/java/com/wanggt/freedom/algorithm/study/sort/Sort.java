package com.wanggt.freedom.algorithm.study.sort;

import java.util.Comparator;

import com.wanggt.freedom.algorithm.study.constant.SortType;

/**
 * 实现此接口的类拥有排序功能
 * @author freedom wang
 * @date 2018年3月23日下午10:25:32
 * @version 1.0
 */
public interface Sort {

	/**
	 * 此方法通过排序算法对整形数组进行排序
	 * @param primaryArray 待排序的整形数组
	 * @return
	 * @author freedom wang
	 * @date 2018年3月22日下午9:20:35
	 * @version 1.0
	 */
	int[] sort(int[] primaryArray);

	/**
	 * 此方法对数组进行排序
	 * @param priaryArray 带排序的数组
	 * @param comparator 比较器
	 * @return
	 * @author freedom wang
	 * @date 2018年3月25日上午10:05:02
	 * @version 1.0
	 */
	<T> T[] sort(T[] primaryArray, Comparator<T> comparator, SortType sortType);
}
