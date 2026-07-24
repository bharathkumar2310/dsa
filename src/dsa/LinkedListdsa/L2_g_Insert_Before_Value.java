package dsa.LinkedListdsa;

public class L2_g_Insert_Before_Value {
    public Node insertBeforeVal(Node head, int val, int newVal) {

        Node newNode = new Node(newVal);

        if (head == null ) {
            return null;
        }

        if(head.data == val) {
            newNode.next = head;
            return newNode;
        }

        Node node = head;
        Node prev = null;
        int cnt = 1;

        while (node != null && node.data != val) {
            prev = node;
            node = node.next;
            cnt++;
        }

        if(node == null) {
            return head;
        }

        prev.next = newNode;
        newNode.next = node;

        return head;
    }
}

//TC : O(n)
