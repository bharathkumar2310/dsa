package dsa.LinkedListdsa;

public class L27_Clone_LL_With_Next_Random_Pointers {
    public Node cloneLinkedList(Node head) {
        // code here
        if (head == null) {
            return null;
        }
        Node temp = head;
        while(temp != null) {
            Node newNode = new Node(temp.data);
            Node next = temp.next;
            temp.next = newNode;
            newNode.next = next;
            temp = next;
        }

        temp = head;

        while(temp != null) {
            Node ran = temp.random;
            Node next = temp.next;
            if(ran != null) {
                next.random = ran.next;
            }
            temp = next.next;
        }

        Node newHead = head.next;

        temp = head;

        while(temp != null) {
            Node next = temp.next;
            temp.next = next.next;
            temp = temp.next;
            if(temp != null) {
                next.next = temp.next;
            }
        }

        return newHead;
    }
}


//public Node cloneLinkedList(Node head) {
//    // code here
//    Node dummy = new Node(-1);
//    Map<Node, Node> map = new HashMap<>();
//    Node temp = head;
//    while(temp != null) {
//        Node newNode = new Node(temp.data);
//        map.put(temp, newNode);
//        temp = temp.next;
//    }
//
//    temp = head;
//    Node temp1 = dummy;
//    temp1.next = map.get(temp);
//    temp1 = temp1.next;
//
//    while(temp != null) {
//
//        temp1.next = map.get(temp.next);
//        temp1.random = map.get(temp.random);
//        temp = temp.next;
//        temp1 = temp1.next;
//    }
//
//    return dummy.next;
//}