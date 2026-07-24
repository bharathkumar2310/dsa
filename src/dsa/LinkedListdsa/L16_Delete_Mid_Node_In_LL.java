package dsa.LinkedListdsa;

public class L16_Delete_Mid_Node_In_LL {
    public Node deleteMid(Node head) {
        // code here
        Node fast = head;
        Node slow = head;
        Node prev = null;

        if(head == null || head.next == null) {
            return null;
        }

        while(fast != null && fast.next != null) {
            fast = fast.next.next;
            prev = slow;
            slow = slow.next;
        }

        prev.next = slow.next;
        return head;

    }
}
