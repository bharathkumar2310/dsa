package dsa.LinkedListdsa;

public class L2_f_Insert_At_K {
    public Node insertPos(Node head, int pos, int val) {

        Node newNode = new Node(val);

        if (head == null || pos == 1) {
            newNode.next = head;
            return newNode;
        }

        Node node = head;
        Node prev = null;
        int cnt = 1;

        while (cnt < pos && node != null) {
            prev = node;
            node = node.next;
            cnt++;
        }

        prev.next = newNode;
        newNode.next = node;

        return head;
    }
}

//TC : O(n)