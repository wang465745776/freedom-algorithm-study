package com.wanggt.freedom.algorithm.leetcode;

import com.wanggt.freedom.algorithm.leetcode.structure.ListNode;

import java.util.List;

/**
 * 237. 删除链表中的节点
 * 请编写一个函数，使其可以删除某个链表中给定的（非末尾）节点，你将只被给定要求被删除的节点。
 *
 * 现有一个链表 -- head = [4,5,1,9]，它可以表示为:
 *
 * 示例 1:
 *
 * 输入: head = [4,5,1,9], node = 5
 * 输出: [4,1,9]
 * 解释: 给定你链表中值为 5 的第二个节点，那么在调用了你的函数之后，该链表应变为 4 -> 1 -> 9.
 * 示例 2:
 *
 * 输入: head = [4,5,1,9], node = 1
 * 输出: [4,5,9]
 * 解释: 给定你链表中值为 1 的第三个节点，那么在调用了你的函数之后，该链表应变为 4 -> 5 -> 9.
 *
 *
 * 说明:
 *
 * 链表至少包含两个节点。
 * 链表中所有节点的值都是唯一的。
 * 给定的节点为非末尾节点并且一定是链表中的一个有效节点。
 * 不要从你的函数中返回任何结果。
 *
 * @author freedom wang
 * @date 2020-01-11 12:29:28
 */
public class Question237 {

    /**
     * 解法一：将要删除节点的下一个节点的值赋给要删除节点，然后删除要删除节点的下一个节点。这个题目因为没有给出要删除节点的上一个
     * 节点，所以只能通过这种修改节点的值的方式来删除节点。
     *
     * 时间复杂度：O(1)
     * 空间复杂度：O(1)
     *
     * @author freedom wang
     * @date 2020-03-20 07:54:34
     */
    public void deleteNode(ListNode node) {
        ListNode nextNode = node.next;

        node.val = nextNode.val;
        node.next = nextNode.next;
        nextNode.next = null;
    }
}
