package com.wanggt.freedom.algorithm.study.sort;

import java.lang.reflect.Array;
import java.util.Comparator;

/**
 * 快速排序-最快的排序方式
 *
 * @author freedom wang
 * @date 2019-12-16 22:22:35
 */
public class QuickSort implements Sort {

    @Override
    public <T> void sort(T[] primaryArray, Comparator<T> comparator) {
        // 选中一个基准数，并以此基准数，拆除小于次数的数组和大于次数的数组


        sort(primaryArray, 0, primaryArray.length - 1, comparator);
    }

    public static <T> void sort(T[] array, int beginIndex, int endIndex, Comparator<T> comparator) {
        if (endIndex == beginIndex) {
            return;
        }

        int middleIndex = beginIndex + (endIndex - beginIndex) / 2;
        sort(array, beginIndex, middleIndex, comparator);
        sort(array, middleIndex + 1, endIndex, comparator);
        merge(array, beginIndex, middleIndex, endIndex, comparator);
    }

    public static <T> void merge(T[] array, int beginIndex, int middleIndex, int endIndex, Comparator<T> comparator) {
        T[] temp = (T[]) Array.newInstance(array.getClass().getComponentType(), endIndex - beginIndex + 1);

        int tempIndex = 0;
        int firstIndex = beginIndex;
        int secondIndex = middleIndex + 1;

        while (firstIndex <= middleIndex && secondIndex <= endIndex) {
            temp[tempIndex++] = comparator.compare(array[firstIndex], array[secondIndex]) > 0 ? array[firstIndex++] : array[secondIndex++];
        }

        while (firstIndex <= middleIndex) {
            temp[tempIndex++] = array[firstIndex++];
        }

        while (secondIndex <= endIndex) {
            temp[tempIndex++] = array[secondIndex++];
        }

        for (int i = 0; i < temp.length; i++) {
            array[beginIndex + i] = temp[i];
        }
    }

}
