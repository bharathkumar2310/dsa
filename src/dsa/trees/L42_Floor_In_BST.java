package dsa.trees;

public class L42_Floor_In_BST {
    public int findMaxFork(Node root, int k) {
        // code here.

        int ans = -1;
        Node temp = root;
        while(temp != null) {
            if(temp.data == k) {
                return temp.data;
            }
            else if(temp.data < k) {
                ans = temp.data;
                temp = temp.right;
            } else {
                temp = temp.left;
            }
        }

        return ans;
    }
}


//TC : O(logn)   , O(n) --> if skewed BST
//SC : O(1)
