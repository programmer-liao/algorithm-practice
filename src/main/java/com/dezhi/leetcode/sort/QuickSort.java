package com.dezhi.leetcode.sort;

import java.util.Random;

public class QuickSort {

    public int[] sortArray(int[] nums) {
        quickSort(nums, 0, nums.length - 1);
        return nums;
    }

    void quickSort(int[] nums, int left, int right) {
        if (left < right) {
            int pos = partition(nums, left, right);
            quickSort(nums, left, pos - 1);
            quickSort(nums, pos + 1, right);
        }
    }

    int partition(int[] nums, int left, int right) {
        // 随机选取一个值作为pivot
        int random = new Random().nextInt(right - left + 1) + left;
        int t = nums[random];
        nums[random] = nums[left];
        nums[left] = t;

        int temp = nums[left];
        while (left < right) {
            while (left < right && nums[right] > temp) {
                right--;
            }
            nums[left] = nums[right];
            while (left < right && nums[left] <= temp) {
                left++;
            }
            nums[right] = nums[left];
        }
        nums[left] = temp;
        return left;
    }
}
