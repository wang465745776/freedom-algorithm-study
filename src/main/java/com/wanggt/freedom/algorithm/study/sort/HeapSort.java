package com.wanggt.freedom.algorithm.study.sort;

import java.util.Arrays;
import java.util.Comparator;

import com.wanggt.freedom.algorithm.study.constant.SortType;
import com.wanggt.freedom.algorithm.study.util.ArrayBuilder;

/**
 * 堆排序
 *
 * @author freedom wang
 * @date 2019-11-21 21:58:59
 */
public class HeapSort implements Sort {

    @Override
    public <T> void sort(T[] array, Comparator<T> comparator) {

    }

    public static void heapSort(int[] array) {
        // 1.从最后一个非叶子节点开始进行一次初始化，初始化后，树满足完全二叉树
        for (int i = (array.length / 2 - 1); i >= 0; i--) {
            heapify(array, i, array.length);
        }

        //
        for (int i = array.length - 1; i >= 0; i--) {
            // 将数组的第一个元素跟当前未排序的最后一个元素交换
            int temp = array[i];
            array[i] = array[0];
            array[0] = temp;

            // 对树进行一次调整
            heapify(array, 0, i);
        }
    }

    /**
     * 建堆
     *
     * @param arrays           看作是完全二叉树
     * @param currentRootIndex 当前父节点位置
     * @param size             节点总数
     */
    public static void heapify(int[] arrays, int currentRootIndex, int size) {
        if (currentRootIndex < size) {
            //左子树和右字数的位置
            int leftChildIndex = 2 * currentRootIndex + 1;
            int rightChildIndex = 2 * currentRootIndex + 2;

            //把当前父节点位置看成是最大的
            int maxIndex = currentRootIndex;

            // 如果有左子节点，则判断左子节点跟根节点的大小
            if (leftChildIndex < size) {
                if (arrays[maxIndex] < arrays[leftChildIndex]) {
                    maxIndex = leftChildIndex;
                }
            }

            // 如果有右子节点，则判断右子节点跟根节点的大小
            if (rightChildIndex < size) {
                if (arrays[maxIndex] < arrays[rightChildIndex]) {
                    maxIndex = rightChildIndex;
                }
            }

            //如果最大的不是根元素位置，那么就交换
            if (maxIndex != currentRootIndex) {
                int temp = arrays[maxIndex];
                arrays[maxIndex] = arrays[currentRootIndex];
                arrays[currentRootIndex] = temp;

                //继续比较，直到完成一次建堆
                heapify(arrays, maxIndex, size);
            }
        }
    }

    public static void main(String[] args) {
        // 生成一个长度为10的整形数组，数值为0-50之间随机
        int[] intArray = ArrayBuilder.getIntArray(10000, 1, 51);
        // 进行排序
        heapSort(intArray);

        System.out.println(Arrays.toString(intArray));
    }
}
