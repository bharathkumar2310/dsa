package dsa.LinkedListdsa;

public class L2_b_Delete_Tail {
    public Node removeLastNode(Node head) {
        // code here

        if (head == null || head.next == null) {
            return null;
        }
        Node node = head;
        Node prev = null;
        while(node != null && node.next != null) {
            prev =node;
            node = node.next;
        }

        prev.next = null;
        return head;

    }
}

//TC : O(n)
//SC : O(1)