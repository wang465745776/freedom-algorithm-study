package com.wanggt.freedom.algorithm.leetcode;

import com.wanggt.freedom.algorithm.leetcode.structure.ListNode;

/**
 * 147. 对链表进行插入排序
 * 对链表进行插入排序。
 * <img src="https://upload.wikimedia.org/wikipedia/commons/0/0f/Insertion-sort-example-300px.gif">
 *
 *
 * 插入排序的动画演示如上。从第一个元素开始，该链表可以被认为已经部分排序（用黑色表示）。
 * 每次迭代时，从输入数据中移除一个元素（用红色表示），并原地将其插入到已排好序的链表中。
 *
 *
 *
 * 插入排序算法：
 *
 * 插入排序是迭代的，每次只移动一个元素，直到所有元素可以形成一个有序的输出列表。
 * 每次迭代中，插入排序只从输入数据中移除一个待排序的元素，找到它在序列中适当的位置，并将其插入。
 * 重复直到所有输入数据插入完为止。
 *
 *
 * 示例 1：
 *
 * 输入: 4->2->1->3
 * 输出: 1->2->3->4
 * 示例 2：
 *
 * 输入: -1->5->3->4->0
 * 输出: -1->0->3->4->5
 *
 * @author freedom wang
 * @date 2020-01-11 12:29:28
 */
public class Question147 {

    /**
     * 解法一：使用传统插入排序的思想，但是有所修改，因为链表的遍历只能从左到右，所以将一个元素插入到已排序的链表的时候，要从左
     * 向右遍历。
     *
     * @author freedom wang
     * @date 2020-03-22 09:31:23
     */
    public static ListNode insertionSortList(ListNode head) {
        // 1 极端条件判断
        if (head == null || head.next == null) {
            return head;
        }

        // 辅助参数指定
        int sortedIndex = 1; // 表示排序好的节点数

        // 开始遍历排序
        ListNode cur = head.next;
        ListNode next;
        while (cur != null) {
            next = cur.next;
            cur.next = null;

            head = insertOne(head, sortedIndex++, cur);

            cur = next;
        }

        cur = head;
        for (int i = 1; i <= sortedIndex; i++) {
            if (i == sortedIndex) {
                cur.next = null;
            } else {
                cur = cur.next;
            }
        }

        return head;
    }

    /**
     * 新增一个节点到有序链表链表
     *
     * @author freedom wang
     * @date 2020-03-22 09:43:01
     */
    private static ListNode insertOne(ListNode sortedNode, int sortedIndex, ListNode node) {
        // 1 设置一个虚拟节点
        ListNode dummy = new ListNode(Integer.MIN_VALUE);
        dummy.next = sortedNode;

        // 2 设置辅助指针
        ListNode pre = dummy;
        ListNode cur = sortedNode;
        int index = 1;

        // 3 开始遍历链表
        while (cur != null && index <= sortedIndex + 1) {
            if ((pre.val <= node.val && cur.val >= node.val) || index > sortedIndex) {
                node.next = pre.next;
                pre.next = node;
                break;
            } else {
                pre = cur;
                cur = pre.next;
                index++;
            }
        }

        return dummy.next;
    }
}
