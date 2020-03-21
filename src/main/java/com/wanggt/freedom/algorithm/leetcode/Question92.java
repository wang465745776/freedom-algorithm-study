package com.wanggt.freedom.algorithm.leetcode;

import com.wanggt.freedom.algorithm.leetcode.structure.ListNode;

/**
 * 92. 反转链表 II
 * 反转从位置 m 到 n 的链表。请使用一趟扫描完成反转。
 *
 * 说明:
 * 1 ≤ m ≤ n ≤ 链表长度。
 *
 * 示例:
 *
 * 输入: 1->2->3->4->5->NULL, m = 2, n = 4
 * 输出: 1->4->3->2->5->NULL
 *
 * @author freedom wang
 * @date 2020-01-12 12:04:41
 */
public class Question92 {

    /**
     * 解法一：使用三个指针pre、cur和next帮助进行翻转
     *
     * 时间复杂度：O(n)
     * 空间复杂度：O(1)
     *
     * @author freedom wang
     * @date 2020-03-18 21:17:31
     */
    public ListNode reverseBetween(ListNode head, int m, int n) {
        if (head == null) {
            return head;
        }

        ListNode dummy = new ListNode(-1);
        dummy.next = head;

        ListNode pre = dummy;
        ListNode cur = head; // 当前节点
        ListNode next = cur.next; // 下一个节点
        int nodeIndex = 1;
        while (cur != null && nodeIndex <= n) {
            if (nodeIndex >= m) {
                cur.next = pre;
            }

            pre = cur;
            cur = next;
            next = cur != null ? cur.next : null;
            nodeIndex++;
        }

        return dummy.next;
    }
}
