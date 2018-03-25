package com.wanggt.freedom.algorithm.study.comparator;

import java.util.Comparator;

/**
 * 整型比较器
 * @author freedom wang
 * @date 2018年3月25日上午10:36:40
 * @version 1.0
 */
public class IntegerComparator implements Comparator<Integer> {

	@Override
	public int compare(Integer o1, Integer o2) {
		return o1 - o2;
	}
}
