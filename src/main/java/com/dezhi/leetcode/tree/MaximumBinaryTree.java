package com.dezhi.leetcode.tree;

public class MaximumBinaryTree {
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

    public TreeNode constructMaximumBinaryTree(int[] nums) {
        return createTree(nums, 0, nums.length);
    }

    TreeNode createTree(int[] nums, int begin, int end) {
        if (begin >= end) {
            return null;
        }
        int idx = begin;
        for (int i = begin + 1; i < end; i++) {
            if (nums[idx] < nums[i]) {
                idx = i;
            }
        }
        TreeNode root = new TreeNode(nums[idx]);
        root.left = createTree(nums, begin, idx);
        root.right = createTree(nums, idx + 1, end);
        return root;
    }
}
