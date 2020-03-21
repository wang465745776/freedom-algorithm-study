package com.wanggt.freedom.algorithm.leetcode;

import com.wanggt.freedom.algorithm.leetcode.structure.ListNode;
import com.wanggt.freedom.algorithm.leetcode.utils.LinkedListUtils;

/**
 * 2. 两数相加
 * 给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。
 *
 * 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
 *
 * 您可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 *
 * 示例：
 *
 * 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
 * 输出：7 -> 0 -> 8
 * 原因：342 + 465 = 807
 *
 * @author freedom wang
 * @date 2020-01-11 12:29:28
 */
public class Question2 {

    /**
     * 方法1：暴力解法
     *
     * 步骤：
     * 1.将两个链表还原成数字
     * 2.相加两个数字，得到和
     * 3.取出和中的各个数字，形成新的链表
     *
     * 经过测试，不同通过力扣的执行，原因是：消耗太多时间
     *
     * @author freedom wang
     * @date 2020-02-14 22:31:04
     */
    public static ListNode addTwoNumbers1(ListNode l1, ListNode l2) {
        // 步骤1：还原两个链表成为数字
        long num1 = 0;
        int p1 = 0;
        for (; l1.next != null; p1++) {
            num1 += l1.val * Math.pow(10, p1);
            l1 = l1.next;
        }
        num1 += l1.val * Math.pow(10, p1);

        long num2 = 0;
        int p2 = 0;
        for (; l2.next != null; p2++) {
            num2 += l2.val * Math.pow(10, p2);
            l2 = l2.next;
        }
        num2 += l2.val * Math.pow(10, p2);

        // 步骤2：相加两个数字，得到和
        long num = num1 + num2;

        // 步骤3：取出和中的各个数字，形成新的链表
        ListNode firstNode = null;
        ListNode currentNode = null;
        while (num >= 10) {
            int bitNum = (int) (num % 10);
            num = num / 10;
            ListNode listNode = new ListNode(bitNum);

            if (firstNode == null) {
                firstNode = listNode;
                currentNode = listNode;
            } else {
                currentNode.next = listNode;
                currentNode = listNode;
            }
        }

        ListNode listNode = new ListNode((int) num);
        if (firstNode == null) {
            firstNode = listNode;
        } else {
            currentNode.next = listNode;
        }

        return firstNode;
    }

    /**
     * 方法2：模拟数字的进位
     *
     * @author freedom wang
     * @date 2020-03-14 14:03:02
     */
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode firstNode = l1;
        ListNode secondNode = l2;

        ListNode dummy = new ListNode(-1);
        ListNode currentNode = dummy;
        int sum = 0;
        while (firstNode != null || secondNode != null) {
            if (firstNode != null) {
                sum += firstNode.val;
                firstNode = firstNode.next;
            }

            if (secondNode != null) {
                sum += secondNode.val;
                secondNode = secondNode.next;
            }

            currentNode.next = new ListNode(sum % 10);
            currentNode = currentNode.next;

            sum /= 10;
        }

        if (sum > 0) {
            currentNode.next = new ListNode(sum);
        }

        return dummy.next;
    }

    public static void main(String[] args) {
        ListNode l1 = LinkedListUtils.createLinkedList(new int[]{3, 5, 4});
        ListNode l2 = LinkedListUtils.createLinkedList(new int[]{2, 5, 5});

        ListNode listNode = addTwoNumbers(l1, l2);

        LinkedListUtils.printLinkedList(listNode);
    }


}
