package com.wanggt.freedom.algorithm.leetcode;

/**
 * TODO 待优化
 * 请你来实现一个 atoi 函数，使其能将字符串转换成整数。
 *
 * 首先，该函数会根据需要丢弃无用的开头空格字符，直到寻找到第一个非空格的字符为止。
 *
 * 当我们寻找到的第一个非空字符为正或者负号时，则将该符号与之后面尽可能多的连续数字组合起来，作为该整数的正负号；
 * 假如第一个非空字符是数字，则直接将其与之后连续的数字字符组合起来，形成整数。
 *
 * 该字符串除了有效的整数部分之后也可能会存在多余的字符，这些字符可以被忽略，它们对于函数不应该造成影响。
 *
 * 注意：假如该字符串中的第一个非空格字符不是一个有效整数字符、字符串为空或字符串仅包含空白字符时，则你的函数不需要进行转换。
 *
 * 在任何情况下，若函数不能进行有效的转换时，请返回 0。
 *
 * 说明：
 *
 * 假设我们的环境只能存储 32 位大小的有符号整数，那么其数值范围为 [−231,  231 − 1]。
 * 如果数值超过这个范围，请返回  INT_MAX (231 − 1) 或 INT_MIN (−231) 。
 *
 * 示例 1:
 * 输入: "42"
 * 输出: 42
 *
 * 示例 2:
 * 输入: "   -42"
 * 输出: -42
 * 解释: 第一个非空白字符为 '-', 它是一个负号。
 *      我们尽可能将负号与后面所有连续出现的数字组合起来，最后得到 -42 。
 *
 * 示例 3:
 * 输入: "4193 with words"
 * 输出: 4193
 * 解释: 转换截止于数字 '3' ，因为它的下一个字符不为数字。
 *
 * 示例 4:
 * 输入: "words and 987"
 * 输出: 0
 * 解释: 第一个非空字符是 'w', 但它不是数字或正、负号。
 * 因此无法执行有效的转换。
 *
 * 示例 5:
 * 输入: "-91283472332"
 * 输出: -2147483648
 * 解释: 数字 "-91283472332" 超过 32 位有符号整数范围。
 *      因此返回 INT_MIN (−231) 。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/string-to-integer-atoi
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author freedom wang
 * @date 2020-01-12 09:13:50
 */
public class Question8 {

    /**
     * 方法1：解析字符串的每一个字符，对题目要求的每一种情况进行判断。
     * 1.丢弃非空格的字符前的空白字符
     * 2.第一个非空格字符只允许为正号、负号和数字，若不是一个有效整数字符、字符串为空或字符串仅包含空白字符时，则你的函数不需要进行转换
     * 3.与第一个非空字符连续的数字字符组合起来，形成整数
     * 4.若函数不能进行有效的转换时，请返回 0
     * 5.数值范围为 [−231,  231 − 1]，如果数值超过这个范围，请返回  INT_MAX (231 − 1) 或 INT_MIN (−231)
     *
     * @author freedom wang
     * @date 2020-01-12 09:30:04
     */
    public int myAtoi(String str) {
        char[] numChars = str.toCharArray();
        int minThrehold = (int) (Integer.MIN_VALUE * 0.1);
        int maxThrehold = (int) (Integer.MAX_VALUE * 0.1);

        boolean start = false; // 表示是否遍历到达了第一个非空字符
        int value = 0;
        int status = 1;
        for (char numChar : numChars) {
            if (!start) {
                // 当前未到达第一个非空字符，如果出现第一个有效字符，则开始解析；若是出现空白字符则跳过；若是出现无效字符，则结束转换
                if (numChar == '+') {
                    start = true;
                } else if (numChar == '-') {
                    start = true;
                    status = -1;
                } else if ((numChar + "").matches("^\\d$")) {
                    start = true;
                    value = Integer.parseInt(numChar + "");
                } else if (numChar == ' ') {
                    continue;
                } else {
                    break;
                }
            } else {
                // 若已经出现了第一个非空字符，则解析连续出现的数字，否则推出转换
                if ((numChar + "").matches("^\\d$")) {
                    // 需要判断是否当前数字已经（> INT_MAX*0.1 或者  < INT_MIN * 0.1，若是则直接返回
                    if (value * status > maxThrehold) {
                        value = Integer.MAX_VALUE;
                        break;
                    } else if (value * status < minThrehold) {
                        value = Integer.MIN_VALUE;
                        break;
                    } else {
                        if (value * status == minThrehold && Integer.parseInt(numChar + "") > 8) {
                            value = Integer.MIN_VALUE;
                            break;
                        } else if (value * status == maxThrehold && Integer.parseInt(numChar + "") > 7) {
                            value = Integer.MAX_VALUE;
                            break;
                        } else {
                            value = value * 10 + Integer.parseInt(numChar + "");
                        }
                    }
                } else {
                    break;
                }
            }
        }

        return value * status;
    }

    public static void main(String[] args) {
        Question8 question8 = new Question8();

        int i = question8.myAtoi("2147483648");
        System.out.println(i);
    }
}
