package com.weidai.study.leetcode;

import java.util.Stack;

import com.weidai.study.leetcode.A2_AddTwoNumbers.ListNode;

/**
 * @author lianghong.tlh
 * @date 2020/03/19
 */
public class A19_RemoveNthNodeFromEndOfList {

    public ListNode removeNthFromEnd(ListNode head, int n) {
        Stack<ListNode> stack = new Stack<>();
        ListNode keepHead = head;
        while(head != null) {
            stack.add(head);
            head = head.next;
        }
        if(stack.size() < n) {
            return keepHead;
        }
        if(stack.size() == n) {
            return keepHead.next;
        }
        stack.pop();
        while (!stack.isEmpty()) {
            ListNode node = stack.pop();
            if(n == 1) {
                node.next = node.next.next;
                return keepHead;
            } else {
                n--;
            }
        }
        return null;
    }

    public ListNode removeNthFromEnd2(ListNode head, int n) {

        ListNode keepHead = head;
        int length = 0;
        while(head != null) {
            length++;
            head = head.next;
        }

        if(length < n) {
            return keepHead;
        }
        if(length == n) {
            return keepHead.next;
        }
        int point = length -n;
        head = keepHead;
        while(point > 1) {
            point --;
            head = head.next;
        }
        head.next = head.next.next;
        return keepHead;
    }

}
