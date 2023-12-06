package com.dezhi.leetcode.stack;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class MinStack {


    LinkedList<Integer> node;

    List<Integer> sorted;

    public MinStack() {
        node = new LinkedList<>();
        sorted = new ArrayList<>();
    }

    public void push(int val) {
        node.add(val);
        sorted.add(val);
        Collections.sort(sorted);
    }

    public void pop() {
        Integer val = node.removeLast();
        sorted.remove(val);
    }

    public int top() {
        return node.getLast();
    }

    public int getMin() {
        return sorted.get(0);
    }
}
