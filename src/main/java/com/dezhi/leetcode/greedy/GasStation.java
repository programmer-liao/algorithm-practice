package com.dezhi.leetcode.greedy;

public class GasStation {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int n = gas.length;
        int curSum = 0;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            int rest = gas[i] - cost[i];
            curSum += rest;
            if (curSum < min) {
                min = curSum;
            }
        }
        if (curSum < 0) {
            return -1;
        }
        if (min >= 0) {
            return 0;
        }
        for (int i = n - 1; i >= 0; i--) {
            int rest = gas[i] - cost[i];
            min += rest;
            if (min >= 0) {
                return i;
            }
        }
        return -1;
    }
}
