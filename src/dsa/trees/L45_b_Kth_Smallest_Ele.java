package dsa.trees;

public class L45_b_Kth_Smallest_Ele {
    int cnt = 0;
    int ans = -1;
    public int kthLargest(Node root, int k) {
        // code here
        ReverseinOrder(root, k);
        return ans;
    }

    void ReverseinOrder(Node root, int k) {
        if(root == null) {
            return;
        }

        ReverseinOrder(root.right, k);
        cnt++;
        if(cnt == k) {
            ans =  root.data;
            return;
        }
        ReverseinOrder(root.left, k);
    }
}

//TC : O(n)
//SC : O(n)