package dsa.LinkedListdsa;

public class L7_Sort_LL_Of_0_1_2 {
    public Node segregate(Node head) {
        // code here
        Node zeroHead = new Node(-1);
        Node zeroTemp = zeroHead;
        Node oneHead = new Node (-1);
        Node oneTemp = oneHead;
        Node twoHead = new Node (-1);
        Node twoTemp = twoHead;

        Node temp = head;
        while(temp != null) {
            if(temp.data == 0) {
                zeroTemp.next = temp;
                zeroTemp = temp;
            }
            if(temp.data == 1) {
                oneTemp.next = temp;
                oneTemp = temp;
            }
            if(temp.data == 2) {
                twoTemp.next = temp;
                twoTemp = temp;
            }
            temp = temp.next;
        }
        twoTemp.next = null;

        oneTemp.next = twoHead.next;
        zeroTemp.next = oneHead.next;


        return zeroHead.next;

    }
}
