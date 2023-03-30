package com.dezhi.leetcode.dp;

public class PalindromicSubstrings {
    public int countSubstrings(String s) {
        int size = s.length();
        boolean[][] dp = new boolean[size][size];
        int result = 0;
        for (int i = size - 1; i >= 0; i--) {
            for (int j = i; j < size; j++) {
                if (s.charAt(i) == s.charAt(j)) {
                    if (j - i <= 1) {
                        result++;
                        dp[i][j] = true;
                    } else if (dp[i + 1][j - 1]) {
                        result++;
                        dp[i][j] = true;
                    }
                }
            }
        }
        return result;
    }
}
