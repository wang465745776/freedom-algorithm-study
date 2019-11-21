package com.wanggt.freedom.algorithm.study.sort;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Random;

import com.wanggt.freedom.algorithm.study.constant.SortType;

/**
 * 归并排序
 *
 * @author freedom wang
 * @version 1.0
 * @date 2018年3月24日下午10:50:22
 */
public class MergeSort implements Sort {
    private static int count;

    @Override
    public int[] sort(int[] primaryArray) {
        return sort(primaryArray, 0, primaryArray.length - 1);
    }

    public static int[] sort(int[] array, int beginIndex, int endIndex) {
        if (endIndex == beginIndex) {
            return array;
        }

        int middleIndex = beginIndex + (endIndex - beginIndex) / 2;
        sort(array, beginIndex, middleIndex);
        sort(array, middleIndex + 1, endIndex);
        merge(array, beginIndex, middleIndex, endIndex);

        return array;
    }

    public static void merge(int[] array, int beginIndex, int middleIndex, int endIndex) {
        count++;
        int[] temp = new int[endIndex - beginIndex + 1];

        int tempIndex = 0;
        int firstIndex = beginIndex;
        int secondIndex = middleIndex + 1;

        while (firstIndex <= middleIndex && secondIndex <= endIndex) {
            temp[tempIndex++] = array[firstIndex] < array[secondIndex] ? array[firstIndex++] : array[secondIndex++];
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
    public <T> T[] sort(T[] primaryArray, Comparator<T> comparator, SortType sortType) {
        return null;
    }

    public static void main(String[] args) {
        int[] data = new int[100000];
        Random random = new Random();
        for (int i = 0; i < data.length; i++) {
            data[i] = random.nextInt(100000);
        }

        MergeSort mergeSort = new MergeSort();
        long beginTime = System.currentTimeMillis();
        System.out.println(Arrays.toString(mergeSort.sort(data)));
        System.out.println("耗时：" + (System.currentTimeMillis() - beginTime) + "毫秒");

        System.out.println("合并次数：" + count);
    }

}
