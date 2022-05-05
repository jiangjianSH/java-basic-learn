package com.jiangjian.study.java.datastruction.tree;

public class Node {
    int item;
    Node left, right;

    public Node(int item) {
        this.item = item;
        left = null;
        right = null;
    }

    public int getItem() {
        return item;
    }

    public void setItem(int item) {
        this.item = item;
    }

    public Node getLeft() {
        return left;
    }

    public void setLeft(Node left) {
        this.left = left;
    }

    public Node getRight() {
        return right;
    }

    public void setRight(Node right) {
        this.right = right;
    }
}
