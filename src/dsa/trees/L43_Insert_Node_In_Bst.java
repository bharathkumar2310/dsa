package dsa.trees;

public class L43_Insert_Node_In_Bst {
    public Node insert(Node root, int key) {
        // code here

        Node temp = root;
        Node newNode = new Node(key);
        if(temp == null) {
            return newNode;
        }
        while(temp!= null) {
            if(temp.data <= key) {
                if(temp.right == null) {
                    temp.right = newNode;
                    break;
                }
                temp = temp.right;
            } else {
                if(temp.left == null) {
                    temp.left = newNode;
                    break;
                }
                temp = temp.left;
            }
        }

        return root;
    }
}


//TC : O(logn)   , O(n) --> if skewed BST
//SC : O(1)
