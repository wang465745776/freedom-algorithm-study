package com.wanggt.freedom.algorithm.study.structure;

import javax.swing.tree.TreeNode;

/**
 * AVL树的完整实现
 *
 * @author freedom wang
 * @date 2020-03-01 14:37:31
 */
public class AVLTree {

    private AVLNode root; //  AVL树的根节点

    /**
     * 新增节点
     *
     * @author freedom wang
     * @date 2020-03-01 14:57:11
     */
    public void insert(int value) {
        if (root == null) {
            root = new AVLNode(value);
            return;
        }

        // 如果根节点不为空，则将新增节点加入到合适的位置
        AVLNode parentNode = root;
        while ((parentNode.value > value && parentNode.leftNode == null) || (parentNode.value <= value && parentNode.rightNode != null)) {
            if (parentNode.value > value && parentNode.leftNode == null) {
                parentNode = parentNode.leftNode;
            } else {
                parentNode = parentNode.rightNode;
            }
        }

        if (parentNode.value > value) {
            AVLNode avlNode = new AVLNode(parentNode, value);
            parentNode.leftNode = avlNode;
        } else {
            AVLNode avlNode = new AVLNode(parentNode, value);
            parentNode.rightNode = avlNode;
        }

        // 判断当前树是否平衡，如果不平衡，则需要进行旋转

    }

    /**
     * 判断当前树是否平衡
     *
     * 因为平衡的条件是：左右子树高度差不大于1，所以只要将所有左右节点的高度查出来一次进行判断就可以了
     *
     * @author freedom wang
     * @date 2020-03-01 15:40:32
     */
    public boolean isBalanced(AVLNode node) {
        if (node == null) {
            return true;
        }

        if (Math.abs(height(node.leftNode) - height(node.rightNode)) < 2) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * 获取节点的高度
     *
     * @author freedom wang
     * @date 2020-03-01 22:54:20
     */
    private int height(AVLNode root) {
        // An empty tree has height -1
        if (root == null) {
            return -1;
        }

        return 1 + Math.max(height(root.leftNode), height(root.rightNode));
    }

    /**
     * 删除节点
     *
     * @author freedom wang
     * @date 2020-03-01 14:57:02
     */
    public void delete(int value) {

    }

    /**
     * 获取节点数量
     *
     * @author freedom wang
     * @date 2020-03-01 14:57:44
     */
    public int size() {
        return 0;
    }

    // 三种遍历方式：前序遍历、中序遍历和后序遍历


    /**
     * AVL树上的节点
     *
     * @author freedom wang
     * @date 2020-03-01 14:55:38
     */
    public static class AVLNode {
        private AVLNode leftNode; // 左子节点
        private AVLNode rightNode; // 右子节点
        private AVLNode parentNode;  // 父节点
        private int value; // 当前节点的值

        public AVLNode() {
        }

        public AVLNode(int value) {
            this.value = value;
        }

        public AVLNode(AVLNode parentNode, int value) {
            this.parentNode = parentNode;
            this.value = value;
        }

        public AVLNode getLeftNode() {
            return leftNode;
        }

        public void setLeftNode(AVLNode leftNode) {
            this.leftNode = leftNode;
        }

        public AVLNode getRightNode() {
            return rightNode;
        }

        public void setRightNode(AVLNode rightNode) {
            this.rightNode = rightNode;
        }

        public AVLNode getParentNode() {
            return parentNode;
        }

        public void setParentNode(AVLNode parentNode) {
            this.parentNode = parentNode;
        }

        public int getValue() {
            return value;
        }

        public void setValue(int value) {
            this.value = value;
        }
    }
}
