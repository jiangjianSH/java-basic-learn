package com.jiangjian.study.java.datastruction.tree;

public class BinarySearchTree {
    Node root;

    void insert(int val) {
        root = insertKey(root, val);
    }

    Node insertKey(Node root, int val) {
        if (root == null) {
            return new Node(val);
        }
        if (root.getItem() > val) {
            root.left = insertKey(root.left, val);
        }

        if (root.getItem() < val) {
            root.right = insertKey(root.right, val);
        }
        return root;
    }

    Node find(int val) {
        return findNode(root, val);
    }

    Node findNode(Node root, int val){
        if (root == null) {
            return null;
        }
        if (root.getItem() == val) {
            return root;
        }
        if (root.getItem() > val) {
            return findNode(root.left, val);
        }

        if (root.getItem() < val) {
            return findNode(root.right, val);
        }
        return null;
    }


    void inorder() {
        inorderRec(root);
    }

    void inorderRec(Node root) {
        if (root != null) {
            inorderRec(root.left);
            System.out.print(root.getItem() + " -> ");
            inorderRec(root.right);
        }
    }

    void delete(int val) {
        root = deleteRec(root, val);
    }

    Node deleteRec(Node root, int val) {
        if (root == null) {
            return null;
        }

        if (root.getItem() > val) {
            root.left = deleteRec(root.left, val);
            return root;
        }

        if (root.getItem() < val) {
            root.right = deleteRec(root.right, val);
            return root;
        }

        if (root.left == null) {
            return root.right;
        } else if (root.right == null) {
            return root.left;
        }
        root.setItem(getMinVal(root));
        root.right = deleteRec(root.right, root.getItem());
        return root;
    }

    int getMinVal(Node root) {
        int min = root.getItem();
        while(root.left != null) {
            min = root.left.getItem();
            root = root.left;
        }
        return min;
    }

    public static void main(String[] args) {
        BinarySearchTree tree = new BinarySearchTree();
        tree.insert(8);
        tree.insert(1);
        tree.insert(9);
        tree.insert(3);
        tree.insert(7);
        tree.insert(15);
        tree.inorder();

        System.out.println();
        tree.delete(15);
        tree.inorder();


        System.out.println();
        tree.delete(8);
        tree.inorder();
    }
}
