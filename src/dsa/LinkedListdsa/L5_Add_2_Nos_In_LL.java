package dsa.LinkedListdsa;

public class L5_Add_2_Nos_In_LL {
    public Node addTwoLists(Node head1, Node head2) {
        // code here

        Node newHead1 = reverse(head1);
        Node temp1 = newHead1;
        Node newHead2 = reverse(head2);
        Node temp2 = newHead2;
        int carry = 0;
        Node head = new Node(-1);
        Node temp = head;

        while(temp1!= null && temp2!= null) {
            int ele = temp1.data + temp2.data + carry;
            int eleInsert = (ele ) % 10;
            Node newNode = new Node(eleInsert);

            temp.next = newNode;
            temp = newNode;

            carry = ele/10;
            temp1 = temp1.next;
            temp2 = temp2.next;

        }

        while(temp1 != null) {
            int ele = temp1.data + carry;
            int eleInsert = ele % 10;
            Node newNode = new Node(eleInsert);

            temp.next = newNode;
            temp = newNode;

            carry = ele/10;
            temp1 = temp1.next;
        }

        while(temp2 != null) {
            int ele = temp2.data + carry;
            int eleInsert = ele % 10;
            Node newNode = new Node(eleInsert);

            temp.next = newNode;
            temp = newNode;

            carry = ele/10;
            temp2 = temp2.next;
        }

        head = head.next;


        if(carry != 0) {
            Node newNode = new Node(carry);

            if(head == null) {
                head = newNode;
            } else {
                temp.next = newNode;
            }
        }

        Node newHead = reverse(head);
        while(newHead != null && newHead.data == 0 && newHead.next != null) {
            newHead = newHead.next;
        }
        return newHead;

    }

    public Node reverse(Node head) {
        // code here
        Node node = head;
        Node prev = null;
        while(node != null) {
            Node next = node.next;
            node.next = prev;
            prev = node;
            node = next;
        }
        return prev;
    }
}

//TC : O(n +m + max(n, m) + max(n,m) == O(n + m)
//SC : O(1)

// If asked not to reverse the original ll ise stack for that