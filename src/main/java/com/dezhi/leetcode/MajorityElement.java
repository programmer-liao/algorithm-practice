package com.dezhi.leetcode;

import java.util.Arrays;

public class MajorityElement {

    public int majorityElement(int[] nums) {
        Arrays.sort(nums);
        int cnt = 1;
        if (nums.length == 1) {
            return nums[0];
        }
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] == nums[i + 1]) {
                cnt++;
            } else {
                cnt = 1;
            }
            if (cnt > nums.length / 2) {
                return nums[i];
            }
        }
        return cnt;
    }

    public static void main(String[] args) {
        System.out.println(new MajorityElement().majorityElement(new int[]{2, 2, 1, 1, 1, 2, 2}));
    }
}
