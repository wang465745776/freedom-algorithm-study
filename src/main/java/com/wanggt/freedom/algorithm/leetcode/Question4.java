package com.wanggt.freedom.algorithm.leetcode;

/**
 * 4. 寻找两个有序数组的中位数
 * 给定两个大小为 m 和 n 的有序数组 nums1 和 nums2。
 *
 * 请你找出这两个有序数组的中位数，并且要求算法的时间复杂度为 O(log(m + n))。
 *
 * 你可以假设 nums1 和 nums2 不会同时为空。
 *
 * 示例 1:
 *
 * nums1 = [1, 3]
 * nums2 = [2]
 *
 * 则中位数是 2.0
 * 示例 2:
 *
 * nums1 = [1, 2]
 * nums2 = [3, 4]
 *
 * 则中位数是 (2 + 3)/2 = 2.5
 *
 * @author freedom wang
 * @date 2020-01-11 12:29:28
 */
public class Question4 {

    /**
     * 解法一：暴力法，通过归并将两个数组处理成一个有序数组，再找出中位数。
     * 归并的过程的时间复杂度为：O(n+m)，因为需要一个新的数组保存归并结果，所以，空间复杂度为O(n+m)
     *
     * 时间复杂度：O(n+m)
     * 空间复杂度：O(n+m)
     *
     * 并不满足题目要求的时间复杂度为 O(log(m + n))
     *
     * @author freedom wang
     * @date 2020-03-14 18:19:45
     */
    public double findMedianSortedArrays1(int[] nums1, int[] nums2) {
        return 0d;
    }

    /**
     * 解法二：分别对两个有序数组求和
     *
     * @author freedom wang
     * @date 2020-03-14 18:19:45
     */
    public double findMedianSortedArrays2(int[] nums1, int[] nums2) {
        return 0d;
    }


}
