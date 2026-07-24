package dsa.LinkedListdsa;

public class L26_Sort_LL {
    public ListNode sortList(ListNode head) {
        return mergeSort(head);
    }

    ListNode mergeSort(ListNode head) {

        if(head == null || head.next == null) {
            return head;
        }


        ListNode middle = findMiddle(head);
        ListNode next = middle.next;
        middle.next = null;

        ListNode left = mergeSort(head);
        ListNode right = mergeSort(next);
        ListNode newHead = mergeTwoLists(left, right);
        return newHead;

    }

    public ListNode findMiddle(ListNode head) {
        ListNode fast = head.next;
        ListNode slow = head;

        while(fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }

        return slow;
    }


    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode temp1 = list1;
        ListNode temp2 = list2;
        ListNode dummy = new ListNode(-1);
        ListNode temp = dummy;

        while(temp1 != null && temp2!= null) {

            if(temp1.val <= temp2.val) {
                temp.next = temp1;
                temp = temp.next;
                temp1 = temp1.next;
            } else {
                temp.next = temp2;
                temp = temp.next;
                temp2 = temp2.next;

            }
        }

        if(temp1 != null) {
            temp.next = temp1;

        }

        if(temp2 != null) {
            temp.next = temp2;
        }

        return dummy.next;
    }
}
