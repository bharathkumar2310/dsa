package dsa.LinkedListdsa;

public class L3_b_Delete_Tail_DLL {
    public static Node deleteHead(Node head) {
        if(head == null || head.next == null) {
            return null;
        }

        Node node = head;
        while(node.next != null) {
            node = node.next;
        }

        node.prev.next = null;
        return head;
    }

}
