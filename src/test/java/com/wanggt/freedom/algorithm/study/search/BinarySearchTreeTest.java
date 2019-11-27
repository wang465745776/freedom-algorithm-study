package com.wanggt.freedom.algorithm.study.search;

import com.wanggt.freedom.algorithm.study.search.binarytreesearch.BinarySearchTree;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * 二叉查找树的测试
 *
 * @author freedom wang
 * @date 2019-11-24 10:11:52
 */
public class BinarySearchTreeTest {
    private BinarySearchTree<Integer, String> binarySearchTree;

    private int initCount = 100;

    @Before
    public void before() {
        binarySearchTree = new BinarySearchTree<>();

        for (int i = 0; i < initCount; i++) {
            binarySearchTree.insert(i, "" + i);
        }
    }

    @Test
    public void testBigData() {
        int bigDataLength = 20000;
        for (int i = initCount; i < bigDataLength; i++) {
            binarySearchTree.insert(i, i + "");
        }

        long startTime = System.currentTimeMillis();
        Assert.assertEquals("二叉树的值获取失败", binarySearchTree.get(500), "500");
        Assert.assertTrue(bigDataLength + "条数据的查找时，查找数据大于1S", (System.currentTimeMillis() - startTime) < 1000);
    }

    @Test
    public void testIsEmpty() {
        Assert.assertFalse("二叉树判断是否未空失败", binarySearchTree.isEmpty());
    }

    @Test
    public void testSize() {
        Assert.assertEquals("二叉树数量获取失败", initCount, binarySearchTree.size());
    }

    @Test
    public void testInsert() {
        Assert.assertEquals("二叉树数量获取失败", initCount, binarySearchTree.size());
        binarySearchTree.insert(initCount, initCount + "");
        Assert.assertEquals("二叉树插入失败", initCount + 1, binarySearchTree.size());
    }

    @Test
    public void testSearch() {
        Assert.assertEquals("二叉树获取失败", "8", binarySearchTree.get(8));
    }

    @Test
    public void testContain() {
        Assert.assertTrue("二叉树Contain方法测试失败", binarySearchTree.contain(5));
        Assert.assertFalse("二叉树Contain方法测试失败", binarySearchTree.contain(100));
    }

    @Test
    public void testLevelOrder(){
        binarySearchTree.levelOrder();
    }
}
