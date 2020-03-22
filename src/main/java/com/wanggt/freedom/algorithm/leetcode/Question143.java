package com.wanggt.freedom.algorithm.leetcode;

import com.wanggt.freedom.algorithm.leetcode.structure.ListNode;

import java.util.ArrayDeque;

/**
 * 143. 重排链表
 * 给定一个单链表 L：L0→L1→…→Ln-1→Ln ，
 * 将其重新排列后变为： L0→Ln→L1→Ln-1→L2→Ln-2→…
 *
 * 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
 *
 * 示例 1:
 *
 * 给定链表 1->2->3->4, 重新排列为 1->4->2->3.
 * 示例 2:
 *
 * 给定链表 1->2->3->4->5, 重新排列为 1->5->2->4->3.
 *
 * @author freedom wang
 * @date 2020-01-11 12:29:28
 */
public class Question143 {

    /**
     * 解法一：使用双向队列重组链表
     *
     * 时间复杂度：O(n)
     * 空间复杂度：O(1)
     *
     * @author freedom wang
     * @date 2020-03-22 20:00:38
     */
    public static void reorderList(ListNode head) {
        // 1 特殊情况处理
        if (head == null || head.next == null) {
            return;
        }

        // 2 定义一个双向队列保存链表的所有内容
        ArrayDeque<ListNode> deque = new ArrayDeque<>();
        ListNode cur = head;
        while (cur != null) {
            deque.offerLast(cur);

            cur = cur.next;
        }

        // 3 分别从队列的两端弹出节点重组成链表返回
        ListNode dummy = new ListNode(-1);
        ListNode current = dummy;
        while (deque.size() > 0) {
            ListNode firstNode = deque.pollFirst();
            current.next = firstNode;
            current = current.next;

            if (deque.size() > 0) {
                ListNode lastNode = deque.pollLast();
                current.next = lastNode;
                current = current.next;
            }

            if (deque.size() == 0) {
                current.next = null;
            }
        }
    }
}
