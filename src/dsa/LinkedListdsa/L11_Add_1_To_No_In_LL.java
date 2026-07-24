package dsa.LinkedListdsa;

public class L11_Add_1_To_No_In_LL {
    public Node addOne(Node head) {
        // code here.
        int carry = 1;
        Node temp = head;
        Node reverseHead = reverse(temp);
        Node node = reverseHead;
        Node prev = null;

        while(node != null && carry != 0) {
            int ele = node.data + carry;
            node.data = ele %10;
            carry = ele/10;
            prev = node;
            node = node.next;
        }

        if(carry != 0) {
            prev.next = new Node(carry);
        }

        return reverse(reverseHead);


    }


    Node reverse(Node head) {
        Node prev  = null;
        Node node = head;

        while(node != null) {
            Node next = node.next;
            node.next = prev;
            prev = node;
            node = next;
        }

        return prev;
    }
}

//public Node addOne(Node head) {
//    // code here.
//    int carry = 1;
//    Stack<Node> st = new Stack<>();
//    Node temp = head;
//    while(temp != null) {
//        st.push(temp);
//        temp = temp.next;
//    }
//
//    Node dummy = new Node(-1);
//    Node temp1 = dummy;
//
//    while(!st.isEmpty()) {
//
//        Node node = st.pop();
//        int ele = node.data + carry;
//        temp1.next = new Node(ele%10);
//        temp1 = temp1.next;
//        carry = ele/10;
//    }
//
//    if(carry != 0) {
//        temp1.next = new Node(carry);
//    }
//
//    return reverse(dummy.next);
//}
//
//
//Node reverse(Node head) {
//    Node prev  = null;
//    Node node = head;
//
//    while(node != null) {
//        Node next = node.next;
//        node.next = prev;
//        prev = node;
//        node = next;
//    }
//
//    return prev;
//}