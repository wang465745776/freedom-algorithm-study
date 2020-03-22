package com.wanggt.freedom.algorithm.leetcode;

import com.wanggt.freedom.algorithm.leetcode.structure.ListNode;

/**
 * 61. 旋转链表
 * 给定一个链表，旋转链表，将链表每个节点向右移动 k 个位置，其中 k 是非负数。
 *
 * 示例 1:
 *
 * 输入: 1->2->3->4->5->NULL, k = 2
 * 输出: 4->5->1->2->3->NULL
 * 解释:
 * 向右旋转 1 步: 5->1->2->3->4->NULL
 * 向右旋转 2 步: 4->5->1->2->3->NULL
 * 示例 2:
 *
 * 输入: 0->1->2->NULL, k = 4
 * 输出: 2->0->1->NULL
 * 解释:
 * 向右旋转 1 步: 2->0->1->NULL
 * 向右旋转 2 步: 1->2->0->NULL
 * 向右旋转 3 步: 0->1->2->NULL
 * 向右旋转 4 步: 2->0->1->NULL
 *
 * @author freedom wang
 * @date 2020-01-11 12:29:28
 */
public class Question61 {

    /**
     * 解法一：双指针法，找出旋转后的最后一个节点，将这个节点后的节点加入到这个链表的头部
     *
     * 时间复杂度：O(n)
     * 空间复杂度：O(1)
     *
     * @author freedom wang
     * @date 2020-03-22 17:13:48
     */
    public static ListNode rotateRight(ListNode head, int k) {
        // 1 特殊情况处理
        if (head == null || head.next == null) {
            return head;
        }

        // 2 定义辅助的指针
        ListNode cur = head;
        ListNode pre = null;
        int length = 0;
        while (cur != null) {
            pre = cur;
            cur = cur.next;
            length++;
        }
        pre.next = head;

        ListNode current = head;
        for (int i = 1; i < (length - k % length); i++) {
            current = current.next;
        }
        ListNode newHead = current.next;
        current.next = null;
        return newHead;
    }
}
