package com.wanggt.freedom.algorithm.study.sort;

import org.junit.Test;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Random;

/**
 * 归并算法测试
 *
 * @author freedom wang
 * @date 2019-12-15 21:35:18
 */
public class MergeSortTest {

    @Test
    public void testSort() {
        Integer[] data = new Integer[100000];
        Random random = new Random();
        for (int i = 0; i < data.length; i++) {
            data[i] = random.nextInt(100000);
        }

        long beginTime = System.currentTimeMillis();
        MergeSort mergeSort = new MergeSort();
        mergeSort.sort(data, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1 - o2;
            }
        });
        System.out.println("耗时：" + (System.currentTimeMillis() - beginTime) + "毫秒");
        System.out.println(Arrays.toString(data));
    }
}
