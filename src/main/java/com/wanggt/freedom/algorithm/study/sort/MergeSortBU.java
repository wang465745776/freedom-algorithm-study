package com.wanggt.freedom.algorithm.study.sort;

import java.lang.reflect.Array;
import java.util.Comparator;

/**
 * 自底向上的归并排序
 *
 * @author freedom wang
 * @date 2019-12-16 21:36:11
 */
public class MergeSortBU implements Sort {

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

    @Override
    public <T> void sort(T[] primaryArray, Comparator<T> comparator) {
        for (int length = 1; length < primaryArray.length; length += length) {
            for (int beginIndex = 0; beginIndex < primaryArray.length; beginIndex += 2 * length) {
                int endIndex = beginIndex + 2 * length - 1;
                int middleIndex = beginIndex + length - 1;

                merge(primaryArray, beginIndex, middleIndex, endIndex, comparator);
            }
        }
    }
}
