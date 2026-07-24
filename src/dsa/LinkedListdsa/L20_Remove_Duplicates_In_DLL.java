package dsa.LinkedListdsa;

public class L20_Remove_Duplicates_In_DLL {
    Node removeDuplicates(Node headRef) {
        // code here
        Node temp = headRef;

        while(temp != null) {
            Node prev = temp.prev;
            if(prev != null && prev.data == temp.data) {
                Node next = temp.next;
                if(next != null) {
                    next.prev = prev;
                }

                prev.next = next;
                temp = next;

            }
            else {
                temp = temp.next;
            }
        }

        return headRef;
    }
}
