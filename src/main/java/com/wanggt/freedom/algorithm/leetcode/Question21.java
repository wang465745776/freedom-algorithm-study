package com.wanggt.freedom.algorithm.leetcode;

import com.wanggt.freedom.algorithm.leetcode.structure.ListNode;

/**
 * 21. 合并两个有序链表
 * 将两个有序链表合并为一个新的有序链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
 *
 * 示例：
 *
 * 输入：1->2->4, 1->3->4
 * 输出：1->1->2->3->4->4
 *
 * @author freedom wang
 * @date 2020-01-11 12:29:28
 */
public class Question21 {

    /**
     * 解法一：使用归并的思想，并使用多个指针来辅助
     *
     * 时间复杂度：O(n+m)
     * 空间复杂度：O(1)
     *
     * @author freedom wang
     * @date 2020-03-21 09:07:49
     */
    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        // 1 极端情况的处理
        if (l1 == null) {
            return l2;
        }

        if (l2 == null) {
            return l1;
        }

        // 2 创建辅助的指针
        ListNode node1 = l1;
        ListNode node2 = l2;
        ListNode dummy = new ListNode(-1);
        ListNode cur = dummy;

        // 3 执行一次归并
        while (node1 != null && node2 != null) {
            if (node1.val < node2.val) {
                cur.next = node1;
                node1 = node1.next;
            } else {
                cur.next = node2;
                node2 = node2.next;
            }

            cur = cur.next;
        }

        if (node1 != null) {
            cur.next = node1;
        } else {
            cur.next = node2;
        }

        return dummy.next;
    }
}
