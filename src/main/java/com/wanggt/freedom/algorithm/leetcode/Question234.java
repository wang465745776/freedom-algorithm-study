package com.wanggt.freedom.algorithm.leetcode;

import com.sun.jmx.remote.internal.ArrayQueue;
import com.wanggt.freedom.algorithm.leetcode.structure.ListNode;

import java.util.ArrayDeque;

/**
 * 234. 回文链表
 * 请判断一个链表是否为回文链表。
 *
 * 示例 1:
 *
 * 输入: 1->2
 * 输出: false
 * 示例 2:
 *
 * 输入: 1->2->2->1
 * 输出: true
 * 进阶：
 * 你能否用 O(n) 时间复杂度和 O(1) 空间复杂度解决此题？
 *
 * @author freedom wang
 * @date 2020-01-11 12:29:28
 */
public class Question234 {

    /**
     * 解法一：双向队列来判断是否
     *
     * @author freedom wang
     * @date 2020-03-22 20:24:40
     */
    public static boolean isPalindrome(ListNode head) {
        // 1 特殊情况判断
        if (head == null || head.next == null) {
            return true;
        }

        // 2 使用一个双向队列保存所有的节点
        ListNode cur = head;
        ArrayDeque<ListNode> queue = new ArrayDeque<>();
        while (cur != null) {
            queue.add(cur);
            cur = cur.next;
        }

        // 3 判断是否回文
        while (queue.size() > 1) {
            if (queue.pollFirst().val != queue.pollLast().val) {
                return false;
            }
        }

        return true;
    }

    /**
     * 解法二：如果考虑使用空间复杂度为O(1)，则不能使用额外的数据结构来辅助。
     * 可以使用快慢指针找出链表的终点
     *
     * @author freedom wang
     * @date 2020-03-22 21:16:56
     */
    public static boolean isPalindrome1(ListNode head) {
        // 1 特殊情况判断
        if (head == null || head.next == null) {
            return true;
        }

        // 2 找出链表的中点，时间复杂度：O(n)
        ListNode fast = head;
        ListNode slow = head;
        while (fast.next != null) {
            fast = fast.next;
            if (fast.next != null) {
                fast = fast.next;
            }

            slow = slow.next;
        }

        // 3 判断后半部分的链表
        ListNode reverse = reverse(slow);

        // 4 判断是否相同
        ListNode cur = head;
        while (reverse != null) {
            if (reverse.val != cur.val) {
                return false;
            } else {
                reverse = reverse.next;
                cur = cur.next;
            }
        }

        return true;
    }

    private static ListNode reverse(ListNode node) {
        if (node == null || node.next == null) {
            return node;
        }

        ListNode pre = null;
        ListNode cur = node;
        while (cur != null) {
            ListNode next = cur.next;

            cur.next = pre;

            pre = cur;
            cur = next;
        }

        return pre;
    }
}
