package com.wanggt.freedom.algorithm.leetcode;

import com.wanggt.freedom.algorithm.leetcode.structure.ListNode;

/**
 * 19. 删除链表的倒数第N个节点
 * 给定一个链表，删除链表的倒数第 n 个节点，并且返回链表的头结点。
 *
 * 示例：
 *
 * 给定一个链表: 1->2->3->4->5, 和 n = 2.
 *
 * 当删除了倒数第二个节点后，链表变为 1->2->3->5.
 * 说明：
 *
 * 给定的 n 保证是有效的。
 *
 * 进阶：
 *
 * 你能尝试使用一趟扫描实现吗？
 *
 * @author freedom wang
 * @date 2020-01-11 12:29:28
 */
public class Question19 {

    /**
     * 解法一：使用快慢指针可以实现一次遍历，慢指针固定比快指针慢n步，当快指针到达重点，则慢指针则到达倒数第n个节点
     *
     * @author freedom wang
     * @date 2020-03-17 20:56:19
     */
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null || n <= 0) {
            return head;
        }

        ListNode dummyNode = new ListNode(-1);
        dummyNode.next = head;

        ListNode slowNode = dummyNode;
        ListNode fastNode = head;

        for (int i = 1; i < n; i++) {
            fastNode = fastNode.next;
        }

        while (fastNode.next != null) {
            fastNode = fastNode.next;
            slowNode = slowNode.next;
        }

        slowNode.next = slowNode.next.next;

        return dummyNode.next;
    }
}
