package dsa.LinkedListdsa;

public class L21_Reverse_Node_In_K_Group_LL {
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode temp = head;
        ListNode prevNode = null;
        while(temp != null) {
            ListNode kthNode = findKthNode(temp, k);

            if (kthNode == null) {
                if (prevNode != null) {
                    prevNode.next = temp;
                }
                break;
            }
            ListNode next = kthNode.next;
            kthNode.next = null;

            ListNode newHead = reverse(temp);
            if(temp == head) {
                head = newHead;
            }
            if(prevNode != null) {
                prevNode.next = newHead;
            }
            prevNode = temp;
            temp = next;
        }

        return head;
    }

    ListNode findKthNode(ListNode temp, int k) {
        int cnt = 0;
        ListNode temp1 = temp;
        while(temp1 != null && cnt != k - 1) {
            cnt++;
            temp1 = temp1.next;
        }
        return temp1;
    }

    ListNode reverse(ListNode temp) {
        ListNode prev =null;
        while(temp != null) {
            ListNode next = temp.next;
            temp.next = prev;
            prev = temp;
            temp = next;
        }
        return prev;
    }
}
