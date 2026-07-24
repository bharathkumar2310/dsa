package dsa.LinkedListdsa;

public class L15_Length_Of_Loop_In_LL {
    public int lengthOfLoop(Node head) {
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

        if(fast==null || fast.next == null) {
            return 0;
        }
        int cnt  = 1;
        fast = fast.next;

        while(fast != slow) {
            fast = fast.next;
            cnt++;
        }

        return cnt;


    }
}
