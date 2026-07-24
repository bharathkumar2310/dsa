package dsa.LinkedListdsa;

public class L24_Flatten_A_LL {
    public Node flatten(Node root) {
        // code here
        return rec(root);
    }

    Node rec(Node root) {
        if(root.next == null) {
            return root;
        }

        Node prev = rec(root.next);
        Node curr = mergeTwoLists(root, prev);
        return curr;
    }

    public Node mergeTwoLists(Node list1, Node list2) {
        Node temp1 = list1;
        Node temp2 = list2;
        Node dummy = new Node(-1);
        Node temp = dummy;

        while(temp1 != null && temp2!= null) {

            if(temp1.data <= temp2.data) {
                temp.bottom = temp1;
                temp = temp.bottom;
                temp1 = temp1.bottom;
            } else {
                temp.bottom = temp2;
                temp = temp.bottom;
                temp2 = temp2.bottom;

            }
        }

        if(temp1 != null) {
            temp.bottom = temp1;

        }

        if(temp2 != null) {
            temp.bottom = temp2;
        }

        return dummy.bottom;
    }
}
