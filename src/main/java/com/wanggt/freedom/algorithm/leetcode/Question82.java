package com.wanggt.freedom.algorithm.leetcode;

import com.wanggt.freedom.algorithm.leetcode.structure.ListNode;
import com.wanggt.freedom.algorithm.leetcode.utils.LinkedListUtils;

/**
 * 82. 删除排序链表中的重复元素 II
 * 给定一个排序链表，删除所有含有重复数字的节点，只保留原始链表中 没有重复出现 的数字。
 *
 * 示例 1:
 *
 * 输入: 1->2->3->3->4->4->5
 * 输出: 1->2->5
 * 示例 2:
 *
 * 输入: 1->1->1->2->3
 * 输出: 2->3
 *
 * @author freedom wang
 * @date 2020-01-11 12:29:28
 */
public class Question82 {

    /**
     * 解法一：使用三个指针，一个记录上一个节点，一个记录当前节点，一个记录下一个节点，如果当前节点的值跟下一个节点的值相同，则
     * 则删除当前节点跟
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

        ListNode dummy = new ListNode(-1);
        dummy.next = head;

        ListNode pre = dummy;
        ListNode cur = head;
        ListNode next = head.next;
        boolean flag = false;

        while (next != null) {
            if (cur.val == next.val) {
                flag = true;

                cur = next;
                next = cur.next;
            } else {
                if (flag) {
                    pre.next = next;
                    flag = false;
                } else {
                    pre = cur;
                }

                cur = next;
                next = cur.next;
            }
        }

        // 如果处理结束了，flag还是true，表示最后的n个节点是相同的
        if (flag) {
            pre.next = next;
        }

        return dummy.next;
    }

    public static void main(String[] args) {
        ListNode linkedList = LinkedListUtils.createLinkedList(new int[]{1, 1});
        LinkedListUtils.printLinkedList(linkedList);

        ListNode listNode = deleteDuplicates(linkedList);
        LinkedListUtils.printLinkedList(listNode);
    }
}
