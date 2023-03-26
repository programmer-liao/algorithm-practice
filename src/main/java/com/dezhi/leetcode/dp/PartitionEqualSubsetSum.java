package com.dezhi.leetcode.dp;

public class PartitionEqualSubsetSum {
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if (sum % 2 != 0) {
            return false;
        }
        int target = sum / 2;
        int len = nums.length;
        int[][] dp = new int[len][target + 1];
        if (nums[0] == target) {
            return true;
        }
        for (int j = nums[0]; j <= target; j++) {
            dp[0][j] = nums[0];
        }
        for (int i = 1; i < len; i++) {
            for (int j = 0; j <= target; j++) {
                if (j < nums[i]) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - nums[i]] + nums[i]);
                }
                if (dp[i][j] == target) {
                    return true;
                }
            }
        }
        return false;
    }
}
