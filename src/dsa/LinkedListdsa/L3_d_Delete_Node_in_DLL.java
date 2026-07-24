package dsa.LinkedListdsa;

public class L3_d_Delete_Node_in_DLL {
    public void deleteNode(Node node) {

        if (node == null) return;

        // If it is not the first node
        if (node.prev != null) {
            node.prev.next = node.next;
        }

        // If it is not the last node
        if (node.next != null) {
            node.next.prev = node.prev;
        }

        // Optional cleanup
        node.next = null;
        node.prev = null;
    }
}
