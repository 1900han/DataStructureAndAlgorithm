package com.megamind.ds.tree.bst;

import com.megamind.ds.stack.ArrayStack;
import com.megamind.ds.stack.Stack;
import com.megamind.ds.tree.TreeNode;

import javax.xml.soap.Node;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BST<E extends Comparable<E>> {
    private TreeNode<E> root;
    private int size;

    public BST() {
        this.root = null;
        this.size = 0;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void add(E e) {
        root = add(root, e);
    }

    private TreeNode<E> add(TreeNode<E> node, E e) {
        if (node == null) {
            size++;
            return new TreeNode<>(e);
        }

        if (e.compareTo(node.e) < 0) {
            node.left = add(node.left, e);
        } else if (e.compareTo(node.e) > 0) {
            node.right = add(node.right, e);
        }
        return node;
    }

    public boolean contains(E e) {
        return contains(root, e);
    }

    private boolean contains(TreeNode<E> node, E e) {
        if (node == null) {
            return false;
        }
        if (e.compareTo(node.e) == 0) {
            return true;
        } else if (e.compareTo(node.e) < 0) {
            return contains(node.left, e);
        } else
            return contains(node.right, e);
    }

    public void preOrder() {
        preOrder(root);
    }

    private void preOrder(TreeNode<E> node) {
        if (node == null) {
            return;
        }
        System.out.println(node.e);
        preOrder(node.left);
        preOrder(node.right);
    }

    public void inOrder() {
        inOrder(root);
    }

    private void inOrder(TreeNode<E> node) {
        if (node == null) {
            return;
        }
        inOrder(node.left);
        System.out.println(node.e);
        inOrder(node.right);
    }

    public void postOrder() {
        postOrder(root);
    }

    private void postOrder(TreeNode<E> node) {
        if (node == null) {
            return;
        }
        postOrder(node.left);
        postOrder(node.right);
        System.out.println(node.e);
    }

    public List<E> preOrderNR() {
        ArrayList<E> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        ArrayStack<TreeNode<E>> stack = new ArrayStack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode<E> cur = stack.pop();
            res.add(cur.e);
            if (cur.right != null) {
                stack.push(cur.right);
            }
            if (cur.left != null) {
                stack.push(cur.left);
            }
        }
        return res;
    }

    public List<E> inOrderNR() {
        ArrayList<E> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        ArrayStack<TreeNode<E>> stack = new ArrayStack<>();
        TreeNode<E> cur = root;
        while (cur != null || !stack.isEmpty()) {
            while (cur != null) {
                stack.push(cur);
                cur = cur.left;
            }
            cur = stack.pop();
            res.add(cur.e);
            cur = cur.right;
        }
        return res;
    }

    public List<E> postOrderNR() {
        ArrayList<E> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        ArrayStack<TreeNode<E>> stack = new ArrayStack<>();
        ArrayStack<E> output = new ArrayStack<>();
        stack.push(root);

        while ( !stack.isEmpty()) {
            TreeNode<E> cur = stack.pop();
            output.push(cur.e);
            if (cur.left != null) {
                stack.push(cur.left);
            }
            if (cur.right != null) {
                stack.push(cur.right);
            }
        }
        while (!output.isEmpty()) {
            res.add(output.pop());
        }
        return res;
    }

    public void levelOrder() {
        if (root == null) {
            return;
        }
        Queue<TreeNode<E>> q = new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()) {
            TreeNode<E> cur = q.remove();
            System.out.println(cur.e);
            if (cur.left != null) {
                q.add(cur.left);
            }
            if (cur.right != null) {
                q.add(cur.right);
            }
        }
    }
}
