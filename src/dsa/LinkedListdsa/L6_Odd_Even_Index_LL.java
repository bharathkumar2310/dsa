package dsa.LinkedListdsa;

public class L6_Odd_Even_Index_LL {
    public ListNode oddEvenList(ListNode head) {

        if(head == null || head.next == null) {
            return head;
        }
        ListNode evenHead = head.next;
        ListNode oddHead = head;


        int cnt  = 0;
        ListNode odd = head;
        ListNode even = head.next;

        while(odd.next != null && even.next != null) {
            odd.next = even.next;
            even.next = odd.next.next;


            odd= odd.next;
            even = even.next;
        }

        odd.next = evenHead;
        return oddHead;

    }
}
