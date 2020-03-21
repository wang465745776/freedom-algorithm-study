package com.wanggt.freedom.algorithm.leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * 给定一个整数数组，判断是否存在重复元素。
 *
 * 如果任何值在数组中出现至少两次，函数返回 true。如果数组中每个元素都不相同，则返回 false。
 *
 * 示例 1:
 * 输入: [1,2,3,1]
 * 输出: true
 *
 * 示例 2:
 * 输入: [1,2,3,4]
 * 输出: false
 *
 * 示例 3:
 * 输入: [1,1,1,3,3,4,3,2,4,2]
 * 输出: true
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/contains-duplicate
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author freedom wang
 * @date 2020-01-11 23:26:42
 */
public class Question217 {

    /**
     * 方法1：哈希表
     * 自然而然就会想到使用哈希表来解决问题
     *
     * 复杂度分析：
     * 时间复杂度：O(n)
     * 遍历数组，时间复杂度是：O(n)，插入到哈希表里面，时间复杂度是：O(1)
     *
     * 空间复杂度：O(n)
     * 因为使用哈希表保存数组的值
     *
     *
     * @author freedom wang
     * @date 2020-01-11 23:28:17
     */
    public boolean containsDuplicate(int[] nums) {
        Set<Integer> numsSet = new HashSet<>();
        for (int num : nums) {
            boolean add = numsSet.add(num);
            if (!add) {
                return true;
            }
        }

        return false;
    }
}
