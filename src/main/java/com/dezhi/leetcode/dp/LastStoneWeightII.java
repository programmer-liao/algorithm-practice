package com.dezhi.leetcode.dp;

public class LastStoneWeightII {

    public int lastStoneWeightII(int[] stones) {
        int n = stones.length;
        int sum = 0;
        for (int stone : stones) {
            sum += stone;
        }
        int target = sum / 2;
        int[][] dp = new int[n][target + 1];
        for (int j = stones[0]; j <= target; j++) {
            dp[0][j] = stones[0];
        }
        for (int i = 1; i < n; i++) {
            for (int j = 0; j <= target; j++) {
                if (j < stones[i]) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - stones[i]] + stones[i]);
                }
            }
        }
        return (sum - dp[stones.length - 1][target]) - dp[stones.length - 1][target];
    }

}
