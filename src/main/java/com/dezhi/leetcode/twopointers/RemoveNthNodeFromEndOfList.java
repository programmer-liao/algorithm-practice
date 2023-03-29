package com.dezhi.leetcode.twopointers;

public class RemoveNthNodeFromEndOfList {
    static class ListNode {
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

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode pre = head;
        ListNode cur = head.next;
        ListNode temp = head;
        int len = 1;
        while (temp.next != null) {
            len++;
            temp = temp.next;
        }
        int pos = len - n + 1;
        if (pos == 1) {
            head = head.next;
        } else {
            int i = 2;
            while (cur != null && i < pos) {
                pre = cur;
                cur = cur.next;
                i++;
            }
            if (cur != null) {
                pre.next = cur.next;
            }
        }
        return head;
    }
}
