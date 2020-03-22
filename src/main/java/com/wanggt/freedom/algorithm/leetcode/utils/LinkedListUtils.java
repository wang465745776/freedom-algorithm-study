package com.wanggt.freedom.algorithm.leetcode.utils;

import com.wanggt.freedom.algorithm.leetcode.structure.ListNode;

/**
 * 链表的工具类
 *
 * @author freedom wang
 * @date 2020-03-18 23:05:13
 */
public class LinkedListUtils {

    /**
     * 通过一个数组创建链表
     *
     * @param arr 待创建成链表的数组
     *
     * @author freedom wang
     * @date 2020-03-18 23:11:36
     */
    public static ListNode createLinkedList(int... arr) {
        if (arr == null || arr.length == 0) {
            return null;
        }

        ListNode head = new ListNode(arr[0]);

        ListNode currentNode = head;
        for (int i = 1; i < arr.length; i++) {
            currentNode.next = new ListNode(arr[i]);
            currentNode = currentNode.next;
        }

        return head;
    }

    /**
     * 打印链表
     *
     * @author freedom wang
     * @date 2020-03-18 23:13:03
     */
    public static void printLinkedList(ListNode listNode) {
        ListNode currentNode = listNode;
        while (currentNode != null) {
            System.out.print(currentNode.val + " -> ");
            currentNode = currentNode.next;
        }

        System.out.println("NULL");
    }

    /**
     * 比较两个链表是否相同
     *
     * @author freedom wang
     * @date 2020-03-21 09:02:31
     */
    public static boolean compareLinkedList(ListNode l1, ListNode l2) {
        if (l1 == null && l2 == null) {
            return true;
        }

        while (l1 != null && l2 != null) {
            if (l1.val != l2.val) {
                return false;
            } else {
                l1 = l1.next;
                l2 = l2.next;
            }
        }

        return l1 == null && l2 == null;
    }

    /**
     * 比较两个链表是否相同
     *
     * @author freedom wang
     * @date 2020-03-21 09:02:31
     */
    public static boolean compareLinkedList(ListNode l1, int... l2) {
        return compareLinkedList(l1, createLinkedList(l2));
    }
}
