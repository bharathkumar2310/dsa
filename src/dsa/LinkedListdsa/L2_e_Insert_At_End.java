package dsa.LinkedListdsa;

public class L2_e_Insert_At_End {
    public Node insertAtEnd(Node head, int x) {
        // code here
        Node newNode = new Node(x);
        Node node = head;
        while(node != null && node.next != null) {
            node = node.next;
        }

        if(node == null) {
            return newNode;
        }
        node.next = newNode;
        return head;
    }
}
