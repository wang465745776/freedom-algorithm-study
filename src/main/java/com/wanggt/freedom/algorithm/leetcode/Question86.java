package com.wanggt.freedom.algorithm.leetcode;

import com.wanggt.freedom.algorithm.leetcode.structure.ListNode;
import com.wanggt.freedom.algorithm.leetcode.utils.LinkedListUtils;

/**
 * 86. 分隔链表
 * 给定一个链表和一个特定值 x，对链表进行分隔，使得所有小于 x 的节点都在大于或等于 x 的节点之前。
 *
 * 你应当保留两个分区中每个节点的初始相对位置。
 *
 * 示例:
 *
 * 输入: head = 1->4->3->2->5->2, x = 3
 * 输出: 1->2->2->4->3->5
 *
 * @author freedom wang
 * @date 2020-01-11 12:29:28
 */
public class Question86 {

    /**
     * 解法一：用两个个指针，分别组织两个子链表，在拼接在一起，即可得到分隔完成的链表
     *
     * 时间复杂度：O(n)
     * 空间复杂度：O(1)
     *
     * @author freedom wang
     * @date 2020-03-19 21:24:57
     */
    public static ListNode partition(ListNode head, int x) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode dummy1 = new ListNode(-1);
        ListNode dummy2 = new ListNode(-1);

        ListNode small = dummy1;
        ListNode eqOrBig = dummy2;

        ListNode cur = head;
        while (cur != null) {
            if (cur.val >= x) {
                eqOrBig.next = cur;
                eqOrBig = eqOrBig.next;
            } else {
                small.next = cur;
                small = small.next;
            }

            cur = cur.next;
        }

        small.next = dummy2.next;
        eqOrBig.next = null;

        return dummy1.next;
    }

    public static void main(String[] args) {
        ListNode linkedList = LinkedListUtils.createLinkedList(new int[]{1, 2, 3, 7, 2, 1});
        LinkedListUtils.printLinkedList(linkedList);

        ListNode listNode = partition(linkedList, 3);
        LinkedListUtils.printLinkedList(listNode);
    }
}
