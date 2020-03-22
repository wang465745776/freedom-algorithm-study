package com.wanggt.freedom.algorithm.leetcode;

import com.wanggt.freedom.algorithm.leetcode.utils.LinkedListUtils;
import org.junit.Assert;
import org.junit.Test;

public class Question61Test {

    @Test
    public void rotateRight() {
        Assert.assertTrue(LinkedListUtils.compareLinkedList(Question61.rotateRight(LinkedListUtils.createLinkedList(1, 2, 3, 4, 5, 6), 3), 4, 5, 6, 1, 2, 3));
        Assert.assertTrue(LinkedListUtils.compareLinkedList(Question61.rotateRight(LinkedListUtils.createLinkedList(1, 2, 3, 4, 5, 6), 2), 5, 6, 1, 2, 3, 4));
    }
}