package com.dezhi.leetcode.tree;


import java.util.Arrays;

public class ConvertBSTToGreaterTree {

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    static int[] nums = new int[10001];
    static int len = 0;

    public TreeNode convertBST(TreeNode root) {
        len = 0;
        if (root == null) {
            return null;
        }
        getNums(root);
        Arrays.sort(nums, 0, len);
        traversal(root);
        return root;
    }

    void traversal(TreeNode root) {
        if (root == null) {
            return;
        }
        int pos = Arrays.binarySearch(nums, 0, len, root.val);
        int sum = 0;
        for (int i = pos; i < len; i++) {
            sum += nums[i];
        }
        root.val = sum;
        traversal(root.left);
        traversal(root.right);
    }

    void getNums(TreeNode root) {
        if (root == null) {
            return;
        }
        nums[len++] = root.val;
        getNums(root.left);
        getNums(root.right);
    }
}
