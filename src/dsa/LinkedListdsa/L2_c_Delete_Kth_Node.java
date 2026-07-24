package dsa.LinkedListdsa;

public class L2_c_Delete_Kth_Node {
    Node deleteK(Node head, int k) {
        Node prev = null;
        Node curr = head;
        int cnt = 1;

        while(curr != null && cnt < k) {
            prev = curr;
            curr = curr.next;
            cnt++;
        }

        if(curr == null) return head;

        if(prev == null) { // k == 1
            return head.next;
        }

        prev.next = curr.next;
        return head;
    }
}

//TC : O(n)
//SC : O(1)