package dsa.LinkedListdsa;

public class L3_f_Insert_At_Tail {
    public Node insertAtEnd(Node head, int x) {
        // code here
        Node newNode = new Node(x);
        if(head == null) {
            return  newNode;
        }
        Node node = head;
        while(node.next != null) {
            node = node.next;
        }

        newNode.prev = node;
        node.next = newNode;
        return head;
    }
}
