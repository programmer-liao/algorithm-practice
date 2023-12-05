package com.dezhi.leetcode;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class LargestNumber {

    public String largestNumber(int[] nums) {
        List<Integer> list = Arrays.stream(nums).boxed().sorted(((num1, num2) -> {
            String str1 = String.valueOf(num1);
            String str2 = String.valueOf(num2);
            return (str2 + str1).compareTo(str1 + str2);
        })).collect(Collectors.toList());
        StringBuilder sb = new StringBuilder();
        boolean isZero = true;
        for (Integer e : list) {
            if (e != 0) {
                isZero = false;
            }
            sb.append(e);
        }
        return isZero ? "0" : sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(new LargestNumber().largestNumber(new int[]{3, 30, 34, 5, 9}));
        System.out.println(new LargestNumber().largestNumber(new int[]{10, 2}));
        System.out.println(new LargestNumber().largestNumber(new int[]{0, 0}));

    }
}
