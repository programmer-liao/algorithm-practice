package com.dezhi.leetcode.tree;

public class SearchInABinarySearchTree {
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

    TreeNode ans = null;

    public TreeNode searchBST(TreeNode root, int val) {
        search(root, val);
        return ans;
    }

    void search(TreeNode root, int val) {
        if (root == null) {
            return;
        }
        if (val == root.val) {
            ans = root;
            return;
        }
        if (val < root.val) {
            search(root.left, val);
        }
        if (val > root.val) {
            search(root.right, val);
        }
    }
}
