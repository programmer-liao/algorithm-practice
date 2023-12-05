package com.dezhi.leetcode.backtracking;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class PalindromePartitioning {

    List<List<String>> res = new ArrayList<>();

    LinkedList<String> path = new LinkedList<>();

    public List<List<String>> partition(String s) {
        backtracking(s, 0);
        return res;
    }

    void backtracking(String s, int startIndex) {
        if (startIndex >= s.length()) {
            boolean flag = true;
            for (String str : path) {
                if (!isPalindrome(str)) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                res.add(new ArrayList<>(path));
            }
            return;
        }
        for (int i = startIndex; i < s.length(); i++) {
            String substr = s.substring(startIndex, i + 1);
            path.add(substr);
            System.out.println(substr + " " + isPalindrome(substr));
            backtracking(s, i + 1);
            path.removeLast();
        }
    }

    boolean isPalindrome(String s) {
        int left = 0;
        int right = s.length() - 1;
        while (left <= right) {
            if (!(s.charAt(left) == s.charAt(right))) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    public static void main(String[] args) {
        List<List<String>> partition = new PalindromePartitioning().partition("aab");
        System.out.println(partition);
    }


}
