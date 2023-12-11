package com.dezhi.leetcode;

import java.util.Stack;

public class DecodeString {
    public String decodeString(String s) {
        Stack<Integer> numStack = new Stack<>();
        Stack<String> resStack = new Stack<>();
        int num = 0;
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '[') {
                numStack.push(num);
                resStack.push(res.toString());
                num = 0;
                res = new StringBuilder();
            } else if (c == ']') {
                Integer curNum = numStack.pop();
                StringBuilder curRes = new StringBuilder();
                for (int j = 0; j < curNum; j++) {
                    curRes.append(res);
                }
                res = new StringBuilder(resStack.pop() + curRes);
            } else if (c >= '0' && c <= '9') {
                num = num * 10 + (c - '0');
            } else if (c >= 'a' && c <= 'z') {
                res.append(c);
            }
        }
        return res.toString();
    }

    public static void main(String[] args) {
        DecodeString decodeString = new DecodeString();
        System.out.println(decodeString.decodeString("3[a]2[bc]"));
        System.out.println(decodeString.decodeString("3[a2[c]]"));
        System.out.println(decodeString.decodeString("2[abc]3[cd]ef"));
        System.out.println(decodeString.decodeString("abc3[cd]xyz"));
    }
}
