package com.wanggt.freedom.algorithm.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * 给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词。
 *
 * 示例 1:
 *
 * 输入: s = "anagram", t = "nagaram"
 * 输出: true
 * 示例 2:
 *
 * 输入: s = "rat", t = "car"
 * 输出: false
 * 说明:
 * 你可以假设字符串只包含小写字母。
 *
 * 进阶:
 * 如果输入字符串包含 unicode 字符怎么办？你能否调整你的解法来应对这种情况？
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/valid-anagram
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author freedom wang
 * @date 2020-01-11 12:29:28
 */
public class Question242 {

    // 1. 暴力解法，两层遍历，时间复杂度：O(n2),空间复杂度：O(n)

    /**
     * 2.使用一个哈希表来优化一层遍历
     *
     * 时间复杂度：O(n)
     * 空间复杂度：O(n)
     * @author freedom wang
     * @date 2020-01-11 12:32:26
     */
    public boolean isAnagram(String s, String t) {
        // 1.将字符串s的每一个字符加入到哈希表中，时间复杂度：O(n)
        char[] sChars = s.toCharArray();
        Map<Character, Integer> sCharMap = new HashMap<>();
        for (char sChar : sChars) {
            if (!sCharMap.containsKey(sChar)) {
                sCharMap.put(sChar, 1);
            } else {
                sCharMap.put(sChar, sCharMap.get(sChar) + 1);
            }
        }

        // 2.判断t字符串的每一个字符是否都存在，每匹配一次，哈希表中对应字符数量减少1
        for (char tChar : t.toCharArray()) {
            if (!sCharMap.containsKey(tChar)) {
                return false;
            } else {
                sCharMap.put(tChar, sCharMap.get(tChar) - 1);
            }
        }

        // 3. 判断是否哈希表中所有字符数都是0,若是则表示是字母异位词
        for (Integer value : sCharMap.values()) {
            if (value != 0) {
                return false;
            }
        }

        return true;
    }

    // 3.对方法2进行再次优化，
}
