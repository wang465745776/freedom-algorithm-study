package com.wanggt.freedom.algorithm.leetcode;

import com.wanggt.freedom.algorithm.leetcode.structure.ListNode;

/**
 * 206. 反转链表
 * 反转一个单链表。
 *
 * 示例:
 *
 * 输入: 1->2->3->4->5->NULL
 * 输出: 5->4->3->2->1->NULL
 *
 * 进阶:
 * 你可以迭代或递归地反转链表。你能否用两种方法解决这道题？
 *
 * @author freedom wang
 * @date 2020-01-12 12:04:41
 */
public class Question206 {

    /**
     * 解法一：使用三个指针pre、cur和next帮助进行翻转
     *
     * 时间复杂度：O(n)
     * 空间复杂度：O(1)
     * @author freedom wang
     * @date 2020-03-18 21:17:31
     */
    public ListNode reverseList(ListNode head) {
        if (head == null) {
            return head;
        }

        ListNode pre = null;
        ListNode cur = head;
        ListNode next = head.next;

        while (cur != null) {
            cur.next = pre;

            pre = cur;
            cur = next;


            next = cur != null ? cur.next : null;
        }

        return pre;
    }
}
