package com.wanggt.freedom.algorithm.leetcode;

import com.wanggt.freedom.algorithm.leetcode.structure.ListNode;
import com.wanggt.freedom.algorithm.leetcode.utils.LinkedListUtils;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class Question237Test {

    Question237 question237;

    @Before
    public void setUp() throws Exception {
        question237 = new Question237();
    }

    @Test
    public void deleteNode() {
        ListNode listNode = LinkedListUtils.createLinkedList(1, 2, 3, 4, 5);
        question237.deleteNode(listNode.next.next);

        Assert.assertTrue(LinkedListUtils.compareLinkedList(listNode, 1, 2, 4, 5));
    }
}