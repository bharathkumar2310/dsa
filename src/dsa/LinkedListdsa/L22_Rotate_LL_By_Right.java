package dsa.LinkedListdsa;

public class L22_Rotate_LL_By_Right {
    public ListNode rotateRight(ListNode head, int k) {

        if(head == null || head.next == null) {
            return head;
        }
        int cnt = 0;
        ListNode temp = head;
        while(temp.next != null) {
            temp = temp.next;
            cnt++;
        }
        cnt++;
        int k1 = k% cnt;

        if(k1 % cnt == 0) {
            return head;
        }

        temp.next = head;

        ListNode temp1 = head;
        int cnt1 = 0;

        while(cnt1 != cnt - k1 -1) {
            temp1 = temp1.next;
            cnt1++;
        }

        head = temp1.next;
        temp1.next = null;
        return head;
    }
}
