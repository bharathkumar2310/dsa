package dsa.LinkedListdsa;

public class L4_Reverse_DLL {
    public Node reverse(Node head) {
        // code here
        Node node = head;
        while(node != null) {
            Node next = node.next;
            node.next = node.prev;
            node.prev = next;
            head= node;
            node = next;
        }
        return head;
    }
}
