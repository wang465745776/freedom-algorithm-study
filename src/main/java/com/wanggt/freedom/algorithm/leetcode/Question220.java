package com.wanggt.freedom.algorithm.leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * 给定一个整数数组，判断数组中是否有两个不同的索引 i 和 j，
 * 使得 nums [i] 和 nums [j] 的差的绝对值最大为 t，并且 i 和 j 之间的差的绝对值最大为 ķ。
 *
 * 示例 1:
 * 输入: nums = [1,2,3,1], k = 3, t = 0
 * 输出: true
 *
 * 示例 2:
 * 输入: nums = [1,0,1,1], k = 1, t = 2
 * 输出: true
 *
 * 示例 3:
 * 输入: nums = [1,5,9,1,5,9], k = 2, t = 3
 * 输出: false
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/contains-duplicate-iii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author freedom wang
 * @date 2020-01-12 10:41:07
 */
public class Question220 {

    /**
     * 方法1：暴力解法
     *
     * 这是最自然而然想到的解法，两层遍历数组，判断条件是否满足
     *
     * 复杂度分析：
     * 时间复杂度：O(n*k)
     * 空间复杂度：O(1)
     *
     * @author freedom wang
     * @date 2020-01-12 10:43:55
     */
    public boolean containsNearbyAlmostDuplicate1(int[] nums, int k, int t) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (Math.abs(i - j) > k) {
                    break;
                } else {
                    if (Math.abs((long)nums[i] - (long)nums[j]) <= t) {
                        return true;
                    }
                }
            }
        }

        return false;
    }

    /**
     * 方法2：
     *
     *
     * @author freedom wang
     * @date 2020-01-12 11:55:29
     */
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        return false;
    }

    public static void main(String[] args) {
        Question220 question220 = new Question220();

        System.out.println(question220.containsNearbyAlmostDuplicate1(new int[]{1, 5, 9, 1, 5, 9}, 2, 3));
    }
}
