package com.wanggt.freedom.algorithm.leetcode;

import com.wanggt.freedom.algorithm.leetcode.structure.ListNode;
import com.wanggt.freedom.algorithm.leetcode.utils.LinkedListUtils;

/**
 * 328. 奇偶链表
 * 给定一个单链表，把所有的奇数节点和偶数节点分别排在一起。请注意，
 * 这里的奇数节点和偶数节点指的是节点编号的奇偶性，而不是节点的值的奇偶性。
 *
 * 请尝试使用原地算法完成。你的算法的空间复杂度应为 O(1)，时间复杂度应为 O(nodes)，nodes 为节点总数。
 *
 * 示例 1:
 *
 * 输入: 1->2->3->4->5->NULL
 * 输出: 1->3->5->2->4->NULL
 * 示例 2:
 *
 * 输入: 2->1->3->5->6->4->7->NULL
 * 输出: 2->3->6->7->1->5->4->NULL
 * 说明:
 *
 * 应当保持奇数节点和偶数节点的相对顺序。
 * 链表的第一个节点视为奇数节点，第二个节点视为偶数节点，以此类推。
 *
 * @author freedom wang
 * @date 2020-01-11 12:29:28
 */
public class Question328 {

    /**
     * 解法一：这一类的链表分隔问题，一般都使用指针来解决。一个指针链接所有奇数节点，一个指针链接所有偶数
     * 节点，然后再把两个子链表链接起来就完成了。
     *
     * 时间复杂度：O(n)
     * 空间复杂度：O(1)
     *
     * @author freedom wang
     * @date 2020-03-20 07:21:32
     */
    public static ListNode oddEvenList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode dummy1 = new ListNode(-1);
        ListNode dummy2 = new ListNode(-1);

        ListNode odd = dummy1;
        ListNode even = dummy2;

        ListNode cur = head;
        int index = 1;
        while (cur != null) {
            if (index % 2 == 0) {
                even.next = cur;
                even = even.next;
            } else {
                odd.next = cur;
                odd = odd.next;
            }

            cur = cur.next;
            index++;
        }

        odd.next = dummy2.next;
        even.next = null;

        return dummy1.next;
    }

    public static void main(String[] args){
        ListNode linkedList = LinkedListUtils.createLinkedList(new int[]{1, 2, 3, 4, 5});
        LinkedListUtils.printLinkedList(linkedList);
        linkedList = oddEvenList(linkedList);
        LinkedListUtils.printLinkedList(linkedList);
    }
}
