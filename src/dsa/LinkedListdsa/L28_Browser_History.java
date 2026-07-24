package dsa.LinkedListdsa;

public class L28_Browser_History {
    class Node {
        String data;
        Node next;
        Node prev;

        public Node(String data) {
            this.data = data;
            this.next = null;
            this.prev =null;
        }
    }

    Node head;
    Node temp;

    public L28_Browser_History(String homepage) {
        head = new Node(homepage);
        temp = head;
    }

    public void visit(String url) {
        Node newNode = new Node(url);
        Node next = temp.next;
        temp.next = newNode;
        newNode.prev = temp;
        temp = temp.next;

    }

    public String back(int steps) {

        while(temp.prev != null && steps >0) {
            temp = temp.prev;
            steps--;
        }
        return temp.data;
    }

    public String forward(int steps) {
        while(temp.next!= null && steps>0) {
            temp =temp.next;
            steps--;
        }
        return temp.data;
    }
}
