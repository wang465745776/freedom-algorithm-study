package com.wanggt.freedom.algorithm.leetcode;

/**
 * 9. 回文数
 * 判断一个整数是否是回文数。回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。
 *
 * 示例 1:
 *
 * 输入: 121
 * 输出: true
 * 示例 2:
 *
 * 输入: -121
 * 输出: false
 * 解释: 从左向右读, 为 -121 。 从右向左读, 为 121- 。因此它不是一个回文数。
 * 示例 3:
 *
 * 输入: 10
 * 输出: false
 * 解释: 从右向左读, 为 01 。因此它不是一个回文数。
 * 进阶:
 *
 * 你能不将整数转为字符串来解决这个问题吗？
 *
 * @author freedom wang
 * @date 2020-01-11 12:29:28
 */
public class Question9 {

    /**
     * 解法一：解析这个数字，变换数字的位置，根据回文的特点，中间对称相等，如果改变了数字的位置，依旧等于
     * 先前的数字，也即是表示数字是回文的。
     *
     * 例如：针对数字121
     * 各位数字依次为：个位1、十位2、百位1。将百位1改位个位1，十位2不动，百位1改到最低位，依旧为121，即表示
     * 121是回文的
     *
     * 时间复杂度：O(n)
     * 空间复杂度：O(1)
     *
     * @author freedom wang
     * @date 2020-03-15 15:26:53
     */
    public static boolean isPalindrome(int x) {
        // 对参数进行校验
        if (x < 0 || (x != 0 && x % 10 == 0)) {
            return false;
        }

        int initNum = x;
        int revertNum = 0;
        while (initNum >= 10) {
            revertNum = revertNum * 10 + initNum % 10;
            initNum = initNum / 10;
        }

        revertNum = revertNum * 10 + initNum;

        return revertNum == x;
    }

    public static void main(String[] args) {
        System.out.println(isPalindrome(121));
        System.out.println(isPalindrome(122));
    }

}
