package com.dezhi.leetcode.twopointers;

import java.util.ArrayList;

public class ReverseWordsInAString {

    public String reverseWords(String s) {
        int slow = 0;
        int fast = 0;
        StringBuilder str = new StringBuilder();
        ArrayList<String> list = new ArrayList<>();
        s = s.trim();
        int len = s.length();
        while (fast < len) {
            if (s.charAt(fast) == ' ') {
                list.add(s.substring(slow, fast));
                if (s.charAt(fast) == ' ') {
                    while (s.charAt(fast) == ' ') {
                        fast++;
                    }
                    slow = fast;
                }
            }
            fast++;
        }
        list.add(s.substring(slow));
        for (int i = list.size() - 1; i >= 0; i--) {
            str.append(list.get(i)).append(" ");
        }
        return str.toString().trim();
    }
}
