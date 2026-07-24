package dsa.trees;

public class L45_a_Kth_Smallest_Element {
    int cnt = 0;
    int ans = -1;
    public int kthSmallest(Node root, int k) {
        // code here
        inOrder(root, k);
        return ans;
    }

    void inOrder(Node root, int k) {
        if(root == null) {
            return;
        }

        inOrder(root.left, k);
        cnt++;
        if(cnt == k) {
            ans =  root.data;
            return;
        }
        inOrder(root.right, k);
    }
}


//TC : O(n)
//SC : O(n)