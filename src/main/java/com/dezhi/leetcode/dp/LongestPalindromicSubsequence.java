package com.dezhi.leetcode.dp;

public class LongestPalindromicSubsequence {

    public int longestPalindromeSubseq(String s) {
        int size = s.length();
        int[][] dp = new int[size][size];
        for (int i = 0; i < size; i++) {
            dp[i][i] = 1;
        }
        for (int i = size - 1; i >= 0; i--) {
            for (int j = i + 1; j < size; j++) {
                if (s.charAt(i) == s.charAt(j)) {
                    dp[i][j] = dp[i + 1][j - 1] + 2;
                } else {
                    dp[i][j] = Math.max(dp[i + 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[0][size - 1];
    }
}
