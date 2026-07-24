package dsa.LinkedListdsa;

public class L18_Delete_All_Occurance_Of_Key_In_DLL {
    static Node deleteAllOccurOfX(Node head, int x) {
        // code here
        Node temp = head;
        while(temp != null) {
            if(temp.data == x) {
                Node prev = temp.prev;
                Node next = temp.next;

                if(prev != null) {
                    prev.next = next;
                }

                if(next != null) {
                    next.prev = prev;
                }
                if(temp == head) {
                    head = next;
                }

                temp = next;
            } else {
                temp = temp.next;
            }

        }

        return head;
    }
}
