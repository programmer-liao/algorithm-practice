package com.dezhi.leetcode.linkedlist;

import java.util.LinkedList;
import java.util.Stack;

public class ReverseNodesInKGroup {

    public static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public ListNode reverseKGroup(ListNode head, int k) {
        Stack<ListNode> stack = new Stack<>();
        ListNode p = head;
        int step = 0;
        ListNode front = null;
        boolean isHead = true;
        while (p != null) {
            stack.push(p);
            step++;
            if (step == k) {
                ListNode next = p.next;
                ListNode temp = null;
                ListNode h = null;
                ListNode newFront = null;
                while (!stack.isEmpty()) {
                    ListNode u = stack.pop();
                    if (temp == null) {
                        temp = u;
                        h = u;
                    } else {
                        temp.next = u;
                        temp = u;
                    }
                    if (stack.empty()) {
                        newFront = u;
                        newFront.next = next;
                        p = newFront;
                    }
                }
                if (isHead) {
                    head = h;
                    isHead = false;
                } else {
                    front.next = h;
                }
                front = newFront;
                step = 0;
            }
            p = p.next;
        }
        return head;
    }

    public static void main(String[] args) {
        ListNode listNode1 = new ListNode(1);
        ListNode listNode2 = new ListNode(2);
        ListNode listNode3 = new ListNode(3);
        ListNode listNode4 = new ListNode(4);
        ListNode listNode5 = new ListNode(5);
        listNode1.next = listNode2;
        listNode2.next = listNode3;
        listNode3.next = listNode4;
        listNode4.next = listNode5;
        ListNode listNode = new ReverseNodesInKGroup().reverseKGroup(listNode1, 2);
        System.out.println(listNode);
        System.out.println(listNode1);
        while (listNode != null) {
            System.out.println(listNode.val);
            listNode = listNode.next;
        }
    }
}
