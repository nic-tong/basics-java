/**
 * 
 */
package com.weidai.study.leetcode;

/**
 * @Description: Example:

 * Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
 * Output: 7 -> 0 -> 8
 * Explanation: 342 + 465 = 807.
 * 
 * @ClassName: AddTwoNumbers_2
 * @author nic
 * @date: 2018年8月15日 下午7:20:05
 */
public class A2_AddTwoNumbers {

	private static class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			this.val = x;
		}
	}

	/**
	 * 思路： 同时遍历两个链表，将对应位置上的值进行相加，进位单独保存 在下一个节点上进行相加。
	 * @param l1
	 * @param l2
	 * @return
	 */
	public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		int extra = 0;
		ListNode head = new ListNode(0);
		ListNode l = head;
		while (null != l1 || null != l2 || extra != 0) {
			int a = 0;
			int b = 0;
			if (null != l1) {
				a = l1.val;
				l1 = l1.next;
			}
			if (null != l2) {
				b = l2.val;
				l2 = l2.next;
			}
			int sum = a + b + extra;
			extra = sum / 10;
			l.next = new ListNode(sum % 10);
			l = l.next;
		}
		return head.next;
	}

	public static void main(String[] args) {
		ListNode node1 = new ListNode(9);
		node1.next = new ListNode(9);
		ListNode node2 = new ListNode(1);
		ListNode node3 = addTwoNumbers(node1, node2);
		while(node3 != null) {
			System.out.print(node3.val);
			node3 = node3.next;
		}
	}
}
