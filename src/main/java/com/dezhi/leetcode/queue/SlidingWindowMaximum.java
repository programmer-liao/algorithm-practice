package com.dezhi.leetcode.queue;

import java.util.ArrayDeque;
import java.util.Deque;

public class SlidingWindowMaximum {

    // 单调队列
    class MyDeque {
        Deque<Integer> deque = new ArrayDeque<>();
        void pop(int value) {
            if (!deque.isEmpty() && deque.peek() == value) {
                deque.poll();
            }
        }

        void push(int value) {
            while (!deque.isEmpty() && value > deque.getLast()) {
                deque.removeLast();
            }
            deque.add(value);
        }
        int front() {
            return deque.peek();
        }
    }

    public int[] maxSlidingWindow(int[] nums, int k) {
        MyDeque queue = new MyDeque();
        int n = nums.length;
        int m = 0;
        int[] result = new int[n - k + 1];
        for (int i = 0; i < k; i++) {
            queue.push(nums[i]);
        }
        result[m++] = queue.front();
        for (int i = k; i < n; i++) {
            queue.pop(nums[i - k]);
            queue.push(nums[i]);
            result[m++] = queue.front();
        }
        return result;
    }

    // 暴力模拟, 超时代码
    public int[] method1(int[] nums, int k) {
        int n = nums.length;
        int[] result = new int[n - k + 1];
        for (int i = 0; i <= n - k; i++) {
            int max = nums[i];
            for (int j = 1; j < k; j++) {
                if (max < nums[i + j]) {
                    max = nums[i + j];
                }
            }
            result[i] = max;
        }
        return result;
    }
}
