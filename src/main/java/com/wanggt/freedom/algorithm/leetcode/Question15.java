package com.wanggt.freedom.algorithm.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，
 * 使得 a + b + c = 0 ？找出所有满足条件且不重复的三元组。
 *
 * 注意：答案中不可以包含重复的三元组。
 *
 * 例如, 给定数组 nums = [-1, 0, 1, 2, -1, -4]，
 *
 * 满足要求的三元组集合为：
 * [
 * [-1, 0, 1],
 * [-1, -1, 2]
 * ]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/3sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author freedom wang
 * @date 2020-01-11 18:02:46
 */
public class Question15 {

    /**
     * 方法1：暴力解法
     *
     * 这是最简单最直接的思想，遍历数组中任意三个数，如果相加等于0，则满足要求加入返回的集合中
     *
     * @author freedom wang
     * @date 2020-01-11 19:22:43
     */
    public List<List<Integer>> threeSum1(int[] nums) {
        ArrayList<List<Integer>> results = new ArrayList<>();
        if (nums == null || nums.length < 3) {
            return results;
        }

        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                for (int k = j + 1; k < nums.length; k++) {
                    if (nums[i]+ nums[j]+nums[k] == 0) {
                        ArrayList<Integer> result = new ArrayList<>();
                        result.add(nums[i]);
                        result.add(nums[j]);
                        result.add(nums[k]);

                        results.add(result);
                    }
                }
            }
        }

        return results;
    }

    public static void main(String[] args){
        Question15 question15 = new Question15();

        int[] nums = {-1, 0, 1, 2, -1, -4};
        List<List<Integer>> result = question15.threeSum1(nums);
        System.out.println(result.toString());
    }
}
