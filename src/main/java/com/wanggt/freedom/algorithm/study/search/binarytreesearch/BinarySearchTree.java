package com.wanggt.freedom.algorithm.study.search.binarytreesearch;

import java.util.LinkedList;

/**
 * 二分查找树，此数据结构用于二叉树查找算法
 *
 * @author freedom wang
 * @date 2019-11-23 22:36:47
 */
public class BinarySearchTree<K extends Comparable, V> {

    private Node<K, V> root; // 二分查找树的根节点
    private int count; // 二分查找树的节点数量

    public int size() {
        return count;
    }

    public boolean isEmpty() {
        return count == 0;
    }

    /**
     * 往二叉树中插入一个节点
     *
     * @param key   节点的键
     * @param value 节点的值
     *
     * @author freedom wang
     * @date 2019-11-23 22:48:07
     */
    public void insert(K key, V value) {
        root = insert(root, key, value);
    }

    /**
     * 判断当前树中是否包含某个键
     *
     * @param key 待查找的键
     *
     * @author freedom wang
     * @date 2019-11-24 09:54:37
     */
    public boolean contain(K key) {
        return contain(root, key);
    }

    /**
     * 获取二叉树中某个键的值
     *
     * @param key 待查找的键
     *
     * @author freedom wang
     * @date 2019-11-24 10:24:14
     */
    public V get(K key) {
        return get(root, key);
    }

    /**
     * 层序遍历
     * 层序遍历使用队列的数据结构可以实现。
     *
     * @author freedom wang
     * @date 2019-11-24 19:14:07
     */
    public void levelOrder() {
        LinkedList<Node<K, V>> queue = new LinkedList<>();

        // 将根节点加入到队列中
        queue.add(root);

        while (!queue.isEmpty()) {
            Node<K, V> node = queue.poll();

            System.out.println(node.key);

            if (node.leftNode != null) {
                queue.offer(node.leftNode);
            }

            if (node.rightNode != null) {
                queue.offer(node.rightNode);
            }
        }
    }

    /**
     * 获取二叉树种某个键的值
     *
     * @param node 待查找的二叉树的根节点
     * @param key  待查找的键
     *
     * @return 查找到的值，若不存在，则返回null
     *
     * @author freedom wang
     * @date 2019-11-24 10:23:04
     */
    private V get(Node<K, V> node, K key) {
        // 递归的基线条件
        if (node == null) {
            return null;
        } else if (node.key.compareTo(key) == 0) {
            return node.value;
        }

        // 递归条件
        if (key.compareTo(node.key) > 0) {
            return get(node.rightNode, key);
        } else {
            return get(node.leftNode, key);
        }
    }

    /**
     * 判断当前树中是否包含某个键
     *
     * @param node 要搜索的根节点
     * @param key  要查找的键
     *
     * @author freedom wang
     * @date 2019-11-24 09:53:33
     */
    private boolean contain(Node<K, V> node, K key) {
        // 递归的基线条件
        if (node == null) {
            return false;
        } else if (node.key.compareTo(key) == 0) {
            return true;
        }

        // 递归条件
        if (node.key.compareTo(key) > 0) {
            return contain(node.leftNode, key);
        } else {
            return contain(node.rightNode, key);
        }
    }

    /**
     * 插入节点
     *
     * @param node  当前的根节点
     * @param key   节点的键
     * @param value 节点的值
     *
     * @author freedom wang
     * @date 2019-11-23 23:02:26
     */
    private Node<K, V> insert(Node<K, V> node, K key, V value) {
        // 递归的基线条件
        if (node == null) {
            count++;
            return new Node<>(key, value);
        } else if (node.key.equals(key)) {
            node.value = value;
            return node;
        }

        // 递归的递归条件
        if (node.key.compareTo(key) > 0) {
            node.leftNode = insert(node.leftNode, key, value);
        } else {
            node.rightNode = insert(node.rightNode, key, value);
        }
        return node;
    }

    /**
     * 二分查找树中的一个节点
     *
     * @author freedom wang
     * @date 2019-11-23 22:36:14
     */
    public class Node<K extends Comparable, V> {
        private K key;
        private V value;

        private Node<K, V> leftNode; // 左子节点
        private Node<K, V> rightNode; // 右子节点

        public Node(K key, V value) {
            this.key = key;
            this.value = value;
        }

        public K getKey() {
            return key;
        }

        public void setKey(K key) {
            this.key = key;
        }

        public V getValue() {
            return value;
        }

        public void setValue(V value) {
            this.value = value;
        }

        public Node<K, V> getLeftNode() {
            return leftNode;
        }

        public void setLeftNode(Node<K, V> leftNode) {
            this.leftNode = leftNode;
        }

        public Node<K, V> getRightNode() {
            return rightNode;
        }

        public void setRightNode(Node<K, V> rightNode) {
            this.rightNode = rightNode;
        }
    }
}
