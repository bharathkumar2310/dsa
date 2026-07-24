package dsa.trees;

public class L44_Delete_Node_In_Bst {
    public Node delNode(Node root, int x) {
        // code here
        Node temp = root;
        if(temp == null) {
            return null;
        }

        if(temp.data == x) {
            return helper(temp);
        }

        while(temp != null) {
            if(temp.data < x) {
                if(temp.right != null && temp.right.data == x) {
                    Node delete = temp.right;

                    Node right = helper(delete);
                    temp.right = right;
                    break;
                }
                temp = temp.right;
            } else {
                if(temp.left != null && temp.left.data == x) {
                    Node delete = temp.left;
                    Node right = helper(delete);
                    temp.left = right;

                    break;

                }
                temp = temp.left;
            }
        }

        return root;

    }

    Node helper(Node temp) {
        if(temp.left == null){
            return temp.right;
        }
        else if(temp.right == null) {
            return temp.left;
        }
        Node right = findRightLeftMost(temp.right);
        right.left = temp.left;
        return temp.right;

    }

    Node findRightLeftMost(Node temp) {
        while(temp.left != null) {
            temp =temp.left;
        }
        return temp;
    }
}


//TC : O(logn)   , O(n) --> if skewed BST
//SC : O(1)
