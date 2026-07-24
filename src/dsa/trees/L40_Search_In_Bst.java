package dsa.trees;

public class L40_Search_In_Bst {
    public boolean search(Node root, int key) {
        // code here
        Node temp = root;
        while(temp != null) {
            if(temp.data == key) {
                return true;
            }
            else if(temp.data < key) {
                temp = temp.right;
            } else {
                temp = temp.left;
            }
        }

        return false;
    }
}

//TC : O(logn)   , O(n) --> if skewed BST
//SC : O(1)