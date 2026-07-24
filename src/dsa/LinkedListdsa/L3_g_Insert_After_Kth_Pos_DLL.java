package dsa.LinkedListdsa;

public class L3_g_Insert_After_Kth_Pos_DLL {
    Node insertAtPos(Node head, int p, int x) {
        // code here
        Node newNode = new Node(x);
        Node node = head;
        int cnt = 0;

        while(cnt != p && node != null) {
            node = node.next;
            cnt++;
        }


        if(node != null) {
            newNode.prev = node;
            newNode.next = node.next;
            if(node.next != null) {
                node.next.prev = newNode;
            }
            node.next = newNode;

        }

        return head;
    }
}
