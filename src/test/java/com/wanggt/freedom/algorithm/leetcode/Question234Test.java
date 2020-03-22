package com.wanggt.freedom.algorithm.leetcode;

import com.wanggt.freedom.algorithm.leetcode.utils.LinkedListUtils;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class Question234Test {

    @Test
    public void isPalindrome() {
        Assert.assertTrue(Question234.isPalindrome(LinkedListUtils.createLinkedList(1,2,1)));
        Assert.assertFalse(Question234.isPalindrome(LinkedListUtils.createLinkedList(1,2,2)));
        Assert.assertTrue(Question234.isPalindrome(LinkedListUtils.createLinkedList()));
    }

    @Test
    public void isPalindrome1() {
        Assert.assertTrue(Question234.isPalindrome1(LinkedListUtils.createLinkedList(1,2,1)));
        Assert.assertFalse(Question234.isPalindrome1(LinkedListUtils.createLinkedList(1,2,2)));
        Assert.assertTrue(Question234.isPalindrome1(LinkedListUtils.createLinkedList()));
    }
}