package com.dezhi.leetcode.tree;

import java.util.Arrays;

public class MinimumAbsoluteDifferenceInBST {
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

    int[] nums = new int[10010];
    int len = 0;

    public int getMinimumDifference(TreeNode root) {
        traversal(root);
        Arrays.sort(nums, 0, len);
        int minDiff = Integer.MAX_VALUE;
        for (int i = 1; i < len; i++) {
            int diff = nums[i] - nums[i - 1];
            if (minDiff > diff) {
                minDiff = diff;
            }
        }
        return minDiff;
    }

    void traversal(TreeNode root) {
        if (root == null) {
            return;
        }
        nums[len++] = root.val;
        traversal(root.left);
        traversal(root.right);
    }
}
