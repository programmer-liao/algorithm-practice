package com.dezhi.leetcode.dp;

public class TargetSum {
    public int findTargetSumWays(int[] nums, int target) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        // 无解
        if (Math.abs(target) > sum || (target + sum) % 2 == 1) {
            return 0;
        }
        int target0 = (target + sum) / 2;
        if (target0 < 0) {
            target0 = -target0;
        }
        int n = nums.length;
        int[][] dp = new int[n + 1][target0 + 1];
        for (int i = 0; i <= n; i++) {
            dp[i][0] = 1;
        }
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j <= target0; j++) {
                if (j < nums[i - 1]) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    dp[i][j] =  dp[i - 1][j] + dp[i - 1][j - nums[i - 1]];
                }
            }
        }
        return dp[n][target0];
    }
}
