package dsa.LinkedListdsa;

public class L8_Remove_Nth_From_End_In_LL {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode fast = head;
        ListNode slow = head;

        int k = n;

        while (k!= 0 && fast != null) {
            fast = fast.next;
            k--;
        }
        if(fast == null) {
            return head.next;
        }

        while(fast != null && fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }

        slow.next = slow.next.next;
        return head;


    }
}


//public ListNode removeNthFromEnd(ListNode head, int n) {
//    int totalCount  = 0;
//
//    if(head == null) {
//        return null;
//    }
//
//    ListNode node = head;
//    while(node != null) {
//        node = node.next;
//        totalCount++;
//    }
//    int k = totalCount - n ;
//    if(k==0) {
//        return head.next;
//    }
//    node = head;
//    ListNode prev = null;
//    while(node!= null && k != 0) {
//        prev = node;
//        node = node.next;
//        k--;
//    }
//
//    prev.next = node.next;
//
//    return head;
//}