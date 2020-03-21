package com.wanggt.freedom.algorithm.leetcode;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

/**
 * 20. 有效的括号
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
 *
 * 有效字符串需满足：
 *
 * 左括号必须用相同类型的右括号闭合。
 * 左括号必须以正确的顺序闭合。
 * 注意空字符串可被认为是有效字符串。
 *
 * 示例 1:
 *
 * 输入: "()"
 * 输出: true
 * 示例 2:
 *
 * 输入: "()[]{}"
 * 输出: true
 * 示例 3:
 *
 * 输入: "(]"
 * 输出: false
 * 示例 4:
 *
 * 输入: "([)]"
 * 输出: false
 * 示例 5:
 *
 * 输入: "{[]}"
 * 输出: true
 *
 * @author freedom wang
 * @date 2020-01-11 12:29:28
 */
public class Question20 {

    /**
     * 解法一：如果是有效的字符串，应该呈现全局或者局部对称的效果，可以使用栈来辅助判断是否对称
     *
     * 时间复杂度：O(n)
     * 空间复杂度：O(n)
     *
     * @author freedom wang
     * @date 2020-03-21 08:25:43
     */
    public static boolean isValid(String s) {
        if (s == null || s.length() == 0) {
            return true;
        }

        Map<Character, Character> map = new HashMap<>();
        map.put('(', ')');
        map.put('{', '}');
        map.put('[', ']');

        Deque<Character> validDeque = new ArrayDeque<>();
        for (int i = 0; i < s.length(); i++) {
            if (map.containsKey(s.charAt(i))) {
                // 如果是左侧的字符，则直接加入
                validDeque.offerLast(s.charAt(i));
            } else {
                // 若是右侧的字符，则判断是否跟栈中内容对应，否则返回false
                Character lastChar = validDeque.peekLast();
                if (lastChar != null && map.containsKey(lastChar) && map.get(lastChar) == s.charAt(i)) {
                    validDeque.removeLast();
                } else {
                    return false;
                }
            }
        }

        return validDeque.size() == 0;
    }
}
