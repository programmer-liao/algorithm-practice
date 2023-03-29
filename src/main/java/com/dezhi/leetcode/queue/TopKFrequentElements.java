package com.dezhi.leetcode.queue;

import java.util.Arrays;
import java.util.HashMap;
import java.util.PriorityQueue;

public class TopKFrequentElements {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        PriorityQueue<Integer> heap = new PriorityQueue<>((num1, num2) -> map.get(num2)  - map.get(num1));
        for (int num : nums) {
            if (map.containsKey(num)) {
                map.put(num, map.get(num) + 1);
            } else {
                map.put(num, 1);
            }
        }
        for (int num : nums) {
            if (!heap.contains(num)) {
                heap.add(num);
            }
        }
        int[] result = new int[k];
        int i = 0;
        while (!heap.isEmpty() && i < k) {
            Integer e = heap.peek();
            result[i++] = e;
            heap.poll();
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new TopKFrequentElements().topKFrequent(new int[]{1, 1, 1, 2, 2, 3}, 2)));
    }
}
