package dsa.LinkedListdsa;

public class L3_c_Delete_Kth_Node_DLL {
    public Node delPos(Node head, int x) {
        // code here
        if(head == null ) {
            return null;
        }

        if(x==1) {
            if(head.next != null) {
                head.next.prev = null;
            }

            return head.next;
        }

        int cnt = 1;
        Node node = head;

        while(node != null && cnt != x) {
            node = node.next;
            cnt++;
        }

        if(node != null) {
            Node prev = node.prev;
            Node next = node.next;
            prev.next = next;
            if(next != null) {
                next.prev = prev;
            }
        }

        return head;
    }
}
