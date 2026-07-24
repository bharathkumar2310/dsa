package dsa.LinkedListdsa;

public class L2_d_Insert_At_Front {
    public Node insertAtFront(Node head, int x) {
        // code here
        Node newNode = new Node(x);
        newNode.next = head;
        return newNode;

    }
}

//TC : O(1)
//SC : O(1)