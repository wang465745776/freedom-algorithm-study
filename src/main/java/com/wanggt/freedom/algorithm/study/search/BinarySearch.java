package com.wanggt.freedom.algorithm.study.search;

import com.wanggt.freedom.algorithm.study.sort.MergeSort;

import java.util.Comparator;
import java.util.Random;

/**
 * 二分查找算法
 *
 * @author freedom wang
 * @date 2019-11-23 13:34:00
 */
public class BinarySearch implements Search {

    @Override
    public <T> int search(T[] array, T value, Comparator<T> comparator) {
        int beginIndex = 0;
        int endIndex = array.length - 1;


        while (beginIndex <= endIndex) {
            int middleIndex = beginIndex + (endIndex - beginIndex) / 2;
            if (comparator.compare(array[middleIndex], value) == 0) {
                return middleIndex;
            } else if (comparator.compare(array[middleIndex], value) > 0) {
                endIndex = middleIndex - 1;
            } else {
                beginIndex = middleIndex + 1;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        System.out.println(10 + (Integer.MAX_VALUE-10) / 2);
        System.out.println((10 + 100) / 2);
        System.out.println(10 + (100-10) / 2);


        Integer[] array = new Integer[10000];
        Random random = new Random();
        for (int i = 0; i < array.length; i++) {
            array[i] = random.nextInt(array.length);
        }

        // 二分查找要求数组是一个有序数组
        MergeSort mergeSort = new MergeSort();
        mergeSort.sort(array, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1 - o2;
            }
        });

        BinarySearch binarySearch = new BinarySearch();
        System.out.println(binarySearch.search(array, array[100], new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        }));
    }
}
