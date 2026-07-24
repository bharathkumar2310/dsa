package dsa.LinkedListdsa;

public class L14_Detect_Loop_In_LL {
    public boolean detectLoop(Node head) {
        // code here
        Node fast = head;
        Node slow = head;

        while(fast!=null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if(fast == slow) {
                return true;
            }
        }


        return false;
    }
}
