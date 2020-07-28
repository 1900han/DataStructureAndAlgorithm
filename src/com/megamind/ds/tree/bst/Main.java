package com.megamind.ds.tree.bst;

public class Main {
    public static void main(String[] args) {
        BST<Integer> bst = new BST<>();
        int[] nums = {5, 3, 6, 8, 4, 2};
        for (int num : nums) {
            bst.add(num);
        }
        System.out.println("=============前序遍历递归===================");
        bst.preOrder();
        System.out.println("=============前序遍历非递归===================");
        System.out.println(bst.preOrderNR());
        System.out.println("=============中序遍历递归===================");
        bst.inOrder();
        System.out.println("=============中序遍历非递归===================");
        System.out.println(bst.inOrderNR());
        System.out.println("=============后序遍历递归===================");
        bst.postOrder();
        System.out.println("=============后序遍历非递归===================");
        System.out.println(bst.postOrderNR());
        System.out.println("=============层序遍历递归===================");
        bst.levelOrder();
    }
}
