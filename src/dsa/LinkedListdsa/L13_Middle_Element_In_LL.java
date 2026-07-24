package dsa.LinkedListdsa;

public class L13_Middle_Element_In_LL {
    int getMiddle(Node head) {
        // code here
        Node fast = head;
        Node slow = head;

        while(fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }

        return slow.data;
    }
}
