package com.dezhi.leetcode.greedy;

public class LemonadeChange {
    public boolean lemonadeChange(int[] bills) {
        int[] change = new int[21];
        for (int bill : bills) {
            if (bill == 5) {
                change[5]++;
            } else if (bill == 10) {
                if (change[5] > 0) {
                    change[5]--;
                    change[10]++;
                } else {
                    return false;
                }
            } else if (bill == 20) {
                if (change[5] > 0 && change[10] > 0) {
                    change[5]--;
                    change[10]--;
                    change[20]++;
                } else if (change[5] >= 3) {
                    change[5] -= 3;
                    change[20]++;
                } else {
                    return false;
                }
            }
        }
        return true;
    }
}
