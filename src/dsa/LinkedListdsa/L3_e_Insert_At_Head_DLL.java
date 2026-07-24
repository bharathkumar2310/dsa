package dsa.LinkedListdsa;

public class L3_e_Insert_At_Head_DLL {
    public Node insertAtFront(Node head, int x) {
        // code here
        Node newNode = new Node(x);

        if (head == null) {
            return newNode;
        }
        newNode.next = head;
        head.prev = newNode;
        return newNode;

    }
}
