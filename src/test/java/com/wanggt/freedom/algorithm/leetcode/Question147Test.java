package com.wanggt.freedom.algorithm.leetcode;

import com.wanggt.freedom.algorithm.leetcode.structure.ListNode;
import com.wanggt.freedom.algorithm.leetcode.utils.LinkedListUtils;
import org.junit.Assert;
import org.junit.Test;

public class Question147Test {

    @Test
    public void testAddTwoNumbers() {
        ListNode listNode = Question147.insertionSortList(LinkedListUtils.createLinkedList(3, 1, 7, 5, 2));
        LinkedListUtils.printLinkedList(listNode);
        Assert.assertTrue(LinkedListUtils.compareLinkedList(listNode, 1, 2, 3, 5, 7));
    }
}
