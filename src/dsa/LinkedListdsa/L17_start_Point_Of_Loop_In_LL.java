package dsa.LinkedListdsa;

public class L17_start_Point_Of_Loop_In_LL {
    public int cycleStart(Node head) {
        // code here
        Node fast = head;
        Node slow = head;

        while(fast!=null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if(fast == slow) {
                break;
            }
        }

        if(fast != slow) {
            return -1;
        }

        slow = head;

        while(slow != fast) {
            slow = slow.next;
            fast= fast.next;
        }

        return slow.data;


    }
}
