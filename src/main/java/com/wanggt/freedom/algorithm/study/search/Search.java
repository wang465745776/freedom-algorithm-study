package com.wanggt.freedom.algorithm.study.search;

import java.util.Comparator;

/**
 * 查找接口，所有的查找算法都实现此接口功能
 *
 * @author freedom wang
 * @date 2019-11-23 13:34:27
 */
public interface Search {

    /**
     * 在数组中查找到值的索引
     *
     * @param array 待查找的数组
     * @param value 要查找的值
     *
     * @return int 值所在的索引，若未找到，则返回-1
     *
     * @author freedom wang
     * @date 2019-11-23 13:37:52
     */
    <T> int search(T[] array, T value, Comparator<T> comparator);
}
