package com.wanggt.freedom.algorithm.leetcode;

import com.wanggt.freedom.algorithm.leetcode.structure.ListNode;

/**
 * 25. K 个一组翻转链表
 * 给你一个链表，每 k 个节点一组进行翻转，请你返回翻转后的链表。
 *
 * k 是一个正整数，它的值小于或等于链表的长度。
 *
 * 如果节点总数不是 k 的整数倍，那么请将最后剩余的节点保持原有顺序。
 *
 *
 *
 * 示例：
 *
 * 给你这个链表：1->2->3->4->5
 *
 * 当 k = 2 时，应当返回: 2->1->4->3->5
 *
 * 当 k = 3 时，应当返回: 3->2->1->4->5
 *
 *
 *
 * 说明：
 *
 * 你的算法只能使用常数的额外空间。
 * 你不能只是单纯的改变节点内部的值，而是需要实际进行节点交换。
 *
 * @author freedom wang
 * @date 2020-01-11 12:29:28
 */
public class Question25 {
    /**
     * 解法一：翻转列表，可以考虑使用栈，但是使用了栈就没有常数空间了，不满足题目要求
     *
     * @author freedom wang
     * @date 2020-03-17 21:08:20
     */
    public ListNode reverseKGroup1(ListNode head, int k) {

        return null;
    }

    /**
     * 解法二：通过多个指针来翻转链表，这个解法比较复杂，需要搞清楚定义
     *
     * @author freedom wang
     * @date 2020-03-17 21:08:20
     */
    public ListNode reverseKGroup(ListNode head, int k) {

        return null;
    }
}
