package com.wanggt.freedom.algorithm.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * 3. 无重复字符的最长子串
 * 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
 *
 * 示例 1:
 *
 * 输入: "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 * 示例 2:
 *
 * 输入: "bbbbb"
 * 输出: 1
 * 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
 * 示例 3:
 *
 * 输入: "pwwkew"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
 * 请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
 *
 * @author freedom wang
 * @date 2020-01-11 12:29:28
 */
public class Question3 {

    /**
     * 解法一：暴力解法，穷举所有可能的子串，判断是否存在重复字串，找出所有不重复子串中的最大长度
     * 时间复杂度：O(n^3)
     * 空间复杂度：O(1)
     *
     * @author freedom wang
     * @date 2020-03-14 17:16:03
     */
    public int lengthOfLongestSubstring1(String s) {
        return 0;
    }

    /**
     * 解法二：滑动窗口解法。使用两个指针，一个指向当前遍历的位置，一个指向上一个没有重复的地方。
     * 使用字符串abcabcbb进行演示：i表示当前遍历位置，j表示上一次没有重复的位置。length表示最大长度 length = i-j+1
     * i=0;j=0;length=1;
     * i=1;j=0;length=2;
     * i=2;j=0;length=3;
     * i=3;j=1;length=3; // 发生重复
     * i=4;j=2;length=3; // 发生重复
     * i=5;j=3;length=3; // 发生重复
     * i=6;j=4;length=3; // 发生重复
     * i=7;j=6;length=3；// 发生重复
     *
     * i和j之间一直构成了一个滑动窗口，[i,j]之间是不重复的子串。至于判断[i,j]之间是否存在子串，可以通过Map,空间换时间，则复杂度
     * 变为O(1)
     *
     * 时间复杂度:O(n)
     * 空间复杂度：O(n)
     *
     * @author freedom wang
     * @date 2020-03-14 17:19:01
     */
    public int lengthOfLongestSubstring(String s) {
        int maxLength = 0; // 最大长度

        Map<Character, Integer> charIndex = new HashMap<>(); // 此Map用于记录字符的上一次出现位置
        // 定义[j,i]位无重复子串
        for (int i = 0, j = 0; i < s.length(); i++) {
            if (charIndex.containsKey(s.charAt(i))) {
                j = Math.max(charIndex.get(s.charAt(i)) + 1, j);
            }

            maxLength = Math.max(i - j + 1, maxLength);
            charIndex.put(s.charAt(i), i);
        }

        return maxLength;
    }

    public static void main(String[] args) {
        Question3 question3 = new Question3();
        System.out.println(question3.lengthOfLongestSubstring("bbbbb"));
    }
}
