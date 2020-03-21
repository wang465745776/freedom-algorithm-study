package com.wanggt.freedom.algorithm.leetcode;

import com.wanggt.freedom.algorithm.leetcode.structure.ListNode;
import com.wanggt.freedom.algorithm.leetcode.utils.LinkedListUtils;

/**
 * 83. 删除排序链表中的重复元素
 * 给定一个排序链表，删除所有重复的元素，使得每个元素只出现一次。
 *
 * 示例 1:
 *
 * 输入: 1->1->2
 * 输出: 1->2
 * 示例 2:
 *
 * 输入: 1->1->2->3->3
 * 输出: 1->2->3
 *
 * @author freedom wang
 * @date 2020-01-11 12:29:28
 */
public class Question83 {

    /**
     * 解法一：使用两个指针，一个记录上一个节点，一个记录当前节点，如果当前节点的值跟上一个节点的值相同，
     * 则删除当前节点。
     *
     * 时间复杂度：O(n)
     * 空间复杂度：O(1)
     *
     * @author freedom wang
     * @date 2020-03-19 07:37:21
     */
    public static ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode pre = head;
        ListNode cur = head.next;

        while (cur != null) {
            if (pre.val == cur.val) {
                cur = cur.next;
                pre.next = cur;
            } else {
                pre = cur;
                cur = cur.next;
            }
        }

        return head;
    }

    public static void main(String[] args) {
        ListNode linkedList = LinkedListUtils.createLinkedList(new int[]{1, 2, 2, 3, 4});
        LinkedListUtils.printLinkedList(linkedList);

        ListNode listNode = deleteDuplicates(linkedList);
        LinkedListUtils.printLinkedList(listNode);
    }
}
