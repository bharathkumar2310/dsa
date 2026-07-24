package dsa.LinkedListdsa;

import java.util.PriorityQueue;

public class L25_Merge_K_Sorted_List {
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists.length == 0) {
            return null;
        }
        ListNode dummy = new ListNode(-1);
        ListNode temp = dummy;
        PriorityQueue<ListNode> pq = new PriorityQueue<>((x, y) -> x.val - y.val);

        for(int i=0; i<lists.length; i++) {
            if(lists[i] != null) {
                pq.add(lists[i]);
            }
        }


        while(!pq.isEmpty()) {
            ListNode node = pq.poll();
            temp.next = node;
            if(node.next != null) {
                pq.add(node.next);
            }
            temp = temp.next;
        }

        return dummy.next;
    }
}


//public ListNode mergeKLists(ListNode[] lists) {
//    if(lists.length == 0) {
//        return null;
//    }
//
//    ListNode newHead = lists[0];
//    for(int i=1; i<lists.length; i++) {
//
//        newHead = mergeTwoLists(newHead, lists[i]);
//    }
//
//    return newHead;
//}
//
//public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
//    ListNode temp1 = list1;
//    ListNode temp2 = list2;
//    ListNode dummy = new ListNode(-1);
//    ListNode temp = dummy;
//
//    while(temp1 != null && temp2!= null) {
//
//        if(temp1.val <= temp2.val) {
//            temp.next = temp1;
//            temp = temp.next;
//            temp1 = temp1.next;
//        } else {
//            temp.next = temp2;
//            temp = temp.next;
//            temp2 = temp2.next;
//
//        }
//    }
//
//    if(temp1 != null) {
//        temp.next = temp1;
//
//    }
//
//    if(temp2 != null) {
//        temp.next = temp2;
//    }
//
//    return dummy.next;
//}