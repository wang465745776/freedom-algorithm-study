package com.wanggt.freedom.algorithm.study.sort;

import java.util.Comparator;

import com.wanggt.freedom.algorithm.study.constant.SortType;

/**
 * 实现此接口的类拥有排序功能
 *
 * @author freedom wang
 * @version 1.0
 * @date 2018年3月23日下午10:25:32
 */
public interface Sort {

    /**
     * 此方法对数组进行排序
     *
     * @param array      待排序的数组
     * @param comparator 比较器
     *
     * @return
     *
     * @author freedom wang
     * @date 2018年3月25日上午10:05:02
     * @version 1.0
     */
    <T> void sort(T[] array, Comparator<T> comparator);
}
