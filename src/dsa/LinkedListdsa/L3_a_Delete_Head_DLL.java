package dsa.LinkedListdsa;

public class L3_a_Delete_Head_DLL {
    public static Node deleteHead(Node head) {
        // your code here
        if(head == null || head.next == null) {
            return null;
        }

        Node newHead = head.next;
        newHead.prev = null;
        head.next = null;
        return newHead;
    }
}
