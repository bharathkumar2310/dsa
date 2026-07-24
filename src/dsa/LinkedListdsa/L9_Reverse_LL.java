package dsa.LinkedListdsa;

public class L9_Reverse_LL {
    public ListNode reverseList(ListNode head) {
        ListNode node = head;
        ListNode prev = null;
        while(node != null) {
            ListNode next = node.next;
            node.next = prev;
            prev = node;
            node = next;
        }
        return prev;
    }
}


//public ListNode reverseList(ListNode head) {
//    return rec(head, null);
//}
//
//ListNode rec(ListNode node, ListNode prev) {
//    if(node == null) {
//        return prev;
//    }
//
//    ListNode next = node.next;
//    node.next = prev;
//    return rec(next, node);
//}