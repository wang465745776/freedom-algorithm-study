package com.wanggt.freedom.algorithm.leetcode;

/**
 * 给定一个整数数组和一个整数 k，判断数组中是否存在两个不同的索引 i 和 j，
 * 使得 nums [i] = nums [j]，并且 i 和 j 的差的绝对值最大为 k。
 *
 * 示例 1:
 *
 * 输入: nums = [1,2,3,1], k = 3
 * 输出: true
 * 示例 2:
 *
 * 输入: nums = [1,0,1,1], k = 1
 * 输出: true
 * 示例 3:
 *
 * 输入: nums = [1,2,3,1,2,3], k = 2
 * 输出: false
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/contains-duplicate-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author freedom wang
 * @date 2020-01-11 21:24:46
 */
public class Question219 {

    /**
     * 方法1：暴力解法
     *
     * 这道题自然而然就会想到暴力解法，遍历两个索引i和j,判断值是否相同且i和j的值小于等于k,若存在则返回true
     *
     * 复杂度分析：
     * 时间复杂度：O(n * min(n,k))
     * 遍历数组中的n个元素，每次查找最多k个元素
     * 空间复杂度：O(1)
     * 没有使用额外的空间
     *
     * @author freedom wang
     * @date 2020-01-11 21:50:41
     */
    public boolean containsNearbyDuplicate1(int[] nums, int k) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (Math.abs(i - j) <= k) {
                    if (nums[i] == nums[j]) {
                        return true;
                    }
                } else {
                    break;
                }
            }
        }

        return false;
    }

    /**
     * 方法2：滑动窗口 + 查找表
     *
     * 在方法1中使用遍历进行判断，复杂度是O(n)，是否能够优化？
     * 可以使用哈希表优化查找过程，时间复杂度：O(1)，空间复杂度：O(n)
     * TODO 未完待续
     *
     * @author freedom wang
     * @date 2020-01-11 21:50:41
     */
    public boolean containsNearbyDuplicate(int[] nums, int k) {

        return false;
    }
}
