package com.megamind.ds.link;

public class ReverseLink {

    public ListNode reverseList(ListNode head) {
        ListNode pre = null;
        ListNode cur = head;

        while (cur != null) {
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }

    //递归
    public ListNode reverseList2(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode rev = reverseList2(head.next);
        head.next.next = head;
        head.next = null;
        return rev;
    }

}
