package com.megamind.ds.tree;

public class TreeNode<E extends Comparable<E>> {
    public E e;
    public TreeNode<E> left,right;

    public TreeNode(E e) {
        this.e = e;
        this.left = null;
        this.right = null;
    }
}
