package com.wanggt.freedom.algorithm.leetcode;

import com.wanggt.freedom.algorithm.leetcode.structure.ListNode;
import com.wanggt.freedom.algorithm.leetcode.utils.LinkedListUtils;

import java.lang.reflect.Array;
import java.util.ArrayDeque;

/**
 * 445. 两数相加 II
 * 给定两个非空链表来代表两个非负整数。数字最高位位于链表开始位置。
 * 它们的每个节点只存储单个数字。将这两数相加会返回一个新的链表。
 *
 *
 *
 * 你可以假设除了数字 0 之外，这两个数字都不会以零开头。
 *
 * 进阶:
 *
 * 如果输入链表不能修改该如何处理？换句话说，你不能对列表中的节点进行翻转。
 *
 * 示例:
 *
 * 输入: (7 -> 2 -> 4 -> 3) + (5 -> 6 -> 4)
 * 输出: 7 -> 8 -> 0 -> 7
 *
 * @author freedom wang
 * @date 2020-01-11 12:29:28
 */
public class Question445 {

    /**
     * 解法一：分别求出两个链表表示的数，然后相加这两个数，在将这个数转换成链表
     *
     * 这种解法在leetcode上运行失败，原因是：有一些极端情况不能转化成数字，如下所示:
     * [2,4,3,2,4,3,2,4,3,2,4,3,2,4,3,2,4,3,2,4,3,2,4,3,2,4,3,2,4,3,2,4,3,2,4,3,2,4,3,2,4,3,2,4,3,2,4,3,2,4,3,2,4,3,2,4,3,2,4,3,9]
     * [5,6,4,2,4,3,2,4,3,2,4,3,2,4,3,2,4,3,2,4,3,2,4,3,2,4,3,2,4,3,2,4,3,2,4,3,2,4,3,2,4,3,2,4,3,2,4,3,2,4,3,2,4,3,2,4,3,9,9,9,9]
     *
     * 时间复杂度：O(n + m)
     * 空间复杂度：O(1)
     *
     * @author freedom wang
     * @date 2020-03-20 23:31:49
     */
    public static ListNode addTwoNumbers1(ListNode l1, ListNode l2) {
        long num1 = 0;
        ListNode cur1 = l1;
        while (cur1 != null) {
            num1 = num1 * 10 + cur1.val;
            cur1 = cur1.next;
        }

        ListNode cur2 = l2;
        long num2 = 0;
        while (cur2 != null) {
            num2 = num2 * 10 + cur2.val;
            cur2 = cur2.next;
        }

        long total = num1 + num2;

        // 将total解析成链表
        ListNode dummy = new ListNode(-1);
        while (total >= 10) {
            int val = (int) (total % 10);
            ListNode listNode = new ListNode(val);

            listNode.next = dummy.next;
            dummy.next = listNode;

            total = total / 10;
        }

        if (total > 0 || dummy.next == null) {
            ListNode listNode = new ListNode((int) total);
            listNode.next = dummy.next;
            dummy.next = listNode;
        }

        return dummy.next;
    }

    /**
     * 解法二：使用栈的先进后出特性，调转链表的顺序，进而可以模拟数字进阶操作数据
     *
     * 时间复杂度：O(n+m)
     * 空间复杂度：O(n+m)
     *
     * @author freedom wang
     * @date 2020-03-21 08:41:27
     */
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ArrayDeque<ListNode> l1Deque = new ArrayDeque<>();
        while (l1 != null) {
            l1Deque.offerLast(l1);
            l1 = l1.next;
        }

        ArrayDeque<ListNode> l2Deque = new ArrayDeque<>();
        while (l2 != null) {
            l2Deque.offerLast(l2);
            l2 = l2.next;
        }

        int num = 0;
        ListNode dummy = new ListNode(-1);
        while (l1Deque.size() > 0 || l2Deque.size() > 0) {
            ListNode l1Node = l1Deque.pollLast();
            if (l1Node != null) {
                num += l1Node.val;
            }

            ListNode l2Node = l2Deque.pollLast();
            if (l2Node != null) {
                num += l2Node.val;
            }

            ListNode listNode = new ListNode(num % 10);
            listNode.next = dummy.next;
            dummy.next = listNode;

            num /= 10;
        }

        if (num > 0) {
            ListNode listNode = new ListNode(num);
            listNode.next = dummy.next;
            dummy.next = listNode;
        }

        return dummy.next;
    }

    public static void main(String[] args) {
        ListNode l1 = LinkedListUtils.createLinkedList(new int[]{3, 9, 9, 9, 9, 9, 9, 9, 9, 9});
        ListNode l2 = LinkedListUtils.createLinkedList(new int[]{7});
        ListNode listNode = addTwoNumbers(l1, l2);
        LinkedListUtils.printLinkedList(listNode);
    }
}
