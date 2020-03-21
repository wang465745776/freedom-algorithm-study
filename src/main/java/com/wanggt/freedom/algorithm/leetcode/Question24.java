package com.wanggt.freedom.algorithm.leetcode;

import com.wanggt.freedom.algorithm.leetcode.structure.ListNode;

/**
 * 24. 两两交换链表中的节点
 * 给定一个链表，两两交换其中相邻的节点，并返回交换后的链表。
 *
 * 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
 *
 * 示例:
 *
 * 给定 1->2->3->4, 你应该返回 2->1->4->3.
 *
 * @author freedom wang
 * @date 2020-01-11 12:29:28
 */
public class Question24 {
    /**
     * 使用迭代的方式进行交换链表的数据
     *
     * 时间复杂度：O(n)
     * 空间复杂度：O(1)
     * @author freedom wang
     * @date 2020-03-16 21:28:29
     */
    public ListNode swapPairs(ListNode head) {

        if (head == null || head.next == null) {
            return head;
        }

        ListNode preNode = new ListNode(-1);
        preNode.next = head;

        ListNode firstNode = preNode;
        ListNode secondNode = head;

        while (secondNode != null && secondNode.next != null) {
            // 进行一次交换
            firstNode.next = secondNode.next;
            secondNode.next = secondNode.next.next;
            firstNode.next.next = secondNode;

            // 切换到下一次的迭代
            firstNode = firstNode.next.next;
            secondNode = secondNode.next;
        }

        return preNode.next;
    }

    /**
     * 解法二：递归
     * @author freedom wang
     * @date 2020-03-16 21:38:38
     */
    public ListNode swapPairs1(ListNode head) {
        return null;
    }

}
