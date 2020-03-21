package com.wanggt.freedom.algorithm.leetcode;

import org.junit.Assert;
import org.junit.Test;

public class Question20Test {

    @Test
    public void testIsValid(){
        Assert.assertTrue(Question20.isValid(""));
        Assert.assertTrue(Question20.isValid("[]"));
        Assert.assertTrue(Question20.isValid("[]{}()"));
        Assert.assertTrue(Question20.isValid("[]({[]})"));
        Assert.assertFalse(Question20.isValid("[)"));
        Assert.assertFalse(Question20.isValid("[]{)"));
    }
}
