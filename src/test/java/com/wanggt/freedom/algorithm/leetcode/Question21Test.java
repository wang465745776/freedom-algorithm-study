package com.wanggt.freedom.algorithm.leetcode;

import com.wanggt.freedom.algorithm.leetcode.structure.ListNode;
import com.wanggt.freedom.algorithm.leetcode.utils.LinkedListUtils;
import org.junit.Assert;
import org.junit.Test;

public class Question21Test {

    @Test
    public void testMergeTwoLists() {
        ListNode listNode = Question21.mergeTwoLists(LinkedListUtils.createLinkedList(1, 2, 3),
            LinkedListUtils.createLinkedList(2, 5, 7));
        LinkedListUtils.printLinkedList(listNode);
        boolean compareLinkedList = LinkedListUtils.compareLinkedList(LinkedListUtils.createLinkedList(1, 2, 2, 3, 5, 7), listNode);
        Assert.assertTrue(compareLinkedList);
    }
}
