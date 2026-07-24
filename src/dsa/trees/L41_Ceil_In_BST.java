package dsa.trees;

public class L41_Ceil_In_BST {

    int findCeil(Node root, int x) {
        // code here
        Node temp = root;
        int ans = (int) 1e9;
        while(temp != null) {
            if(temp.data == x) {
                return temp.data;
            }
            else if(temp.data > x) {
                ans = Math.min(ans, temp.data);
                temp = temp.left;
            }
            else {
                temp = temp.right;
            }
        }

        return ans == (int)1e9 ? -1 : ans;
    }
}


//TC : O(logn)   , O(n) --> if skewed BST
//SC : O(1)