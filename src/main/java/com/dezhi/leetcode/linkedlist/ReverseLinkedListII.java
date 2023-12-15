package com.dezhi.leetcode.linkedlist;

import org.junit.jupiter.api.Test;

import java.util.Stack;

public class ReverseLinkedListII {
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

    public ListNode reverseBetween(ListNode head, int left, int right) {
        if (left == right) {
            return head;
        }
        ListNode p = head;
        ListNode leftFront = null;
        ListNode rightBack = null;
        int cur = 1;
        Stack<ListNode> stack = new Stack<>();
        boolean flag = false;
        while (p != null) {
            if (cur == left) {
                flag = true;
            }
            if (flag) {
                stack.push(p);
            }
            if (cur == right) {
                flag = false;
                rightBack = p.next;
                break;
            }
            if (!flag) {
                leftFront = p;
            }
            p = p.next;
            cur++;
        }
        cur = 0;
        ListNode last = null;
        ListNode reverseHead = null;
        while (!stack.empty()) {
            ListNode u = stack.pop();
            cur++;
            if (cur == 1) {
                reverseHead = u;
            } else if (cur == right - left + 1) {
                u.next = rightBack;
                last.next = u;
            } else {
                last.next = u;
            }
            last = u;
        }
        if (leftFront == null) {
            head = reverseHead;
        } else {
            leftFront.next = reverseHead;
        }
        return head;
    }

    @Test
    public void test01() {
        ListNode listNode1 = new ListNode(1);
        ListNode listNode2 = new ListNode(2);
        ListNode listNode3 = new ListNode(3);
        ListNode listNode4 = new ListNode(4);
        ListNode listNode5 = new ListNode(5);
        listNode1.next = listNode2;
        listNode2.next = listNode3;
        listNode3.next = listNode4;
        listNode4.next = listNode5;
        ListNode listNode = new ReverseLinkedListII().reverseBetween(listNode1, 2, 4);
        while (listNode != null) {
            System.out.println(listNode.val);
            listNode = listNode.next;
        }
    }
    @Test
    public void test02() {
        ListNode listNode1 = new ListNode(3);
        listNode1.next = new ListNode(5);
        ListNode listNode = new ReverseLinkedListII().reverseBetween(listNode1, 1, 2);
        while (listNode != null) {
            System.out.println(listNode.val);
            listNode = listNode.next;
        }
    }
}
