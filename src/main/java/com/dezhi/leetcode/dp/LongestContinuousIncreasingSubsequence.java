package com.dezhi.leetcode.dp;

import java.util.Arrays;

public class LongestContinuousIncreasingSubsequence {
    public int findLengthOfLCIS(int[] nums) {
        int[] dp = new int[nums.length];
        Arrays.fill(dp, 1);
        int result = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i - 1] < nums[i]) {
                dp[i] = dp[i - 1] + 1;
            }
            if (result < dp[i]) {
                result = dp[i];
            }
        }
        return result;
    }
}
