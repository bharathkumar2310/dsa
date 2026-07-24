package dsa.LinkedListdsa;

public class L2_a_Delete_Head {
    public Node deleteHead(Node head) {
        // code here
        if(head == null) {
            return null;
        }
        return head.next;
    }
}

//TC : O(1)
//SC : O(1)