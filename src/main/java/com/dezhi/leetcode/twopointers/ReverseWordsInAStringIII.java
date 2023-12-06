package com.dezhi.leetcode.twopointers;


public class ReverseWordsInAStringIII {


    public String reverseWords(String s) {
        int left = 0;
        int right = 0;
        StringBuilder sb = new StringBuilder();
        while (left < s.length() && right < s.length()) {
            if (s.charAt(right) == ' ') {
                String substr = s.substring(left, right);
                sb.append(reverse(substr)).append(" ");
                left = right + 1;
            } else if (right == s.length() - 1) {
                String substr = s.substring(left, right + 1);
                sb.append(reverse(substr));
                left = right + 1;
            }
            right++;
        }
        return sb.toString();
    }

    String reverse(String str) {
        StringBuilder sb = new StringBuilder(str);
        int left = 0;
        int right = str.length() - 1;
        while (left <= right) {
            char t = sb.charAt(left);
            sb.setCharAt(left, sb.charAt(right));
            sb.setCharAt(right, t);
            left++;
            right--;
        }
        return sb.toString();
    }


    public static void main(String[] args) {
        System.out.println(new ReverseWordsInAStringIII().reverseWords("Let's take LeetCode contest"));
    }
}
