package com.wanggt.freedom.algorithm.leetcode;

import com.wanggt.freedom.algorithm.leetcode.structure.ListNode;
import com.wanggt.freedom.algorithm.leetcode.utils.LinkedListUtils;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class Question143Test {

    @Test
    public void reorderList() {
        ListNode listNode = LinkedListUtils.createLinkedList(1, 2, 3, 4);
        Question143.reorderList(listNode);
        Assert.assertTrue(LinkedListUtils.compareLinkedList(listNode, 1, 4, 2, 3));
    }
}