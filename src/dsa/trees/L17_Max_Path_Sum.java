package dsa.trees;

public class L17_Max_Path_Sum {
    int ans = Integer.MIN_VALUE;
    int findMaxSum(Node root) {
        rec(root);
        return ans;
    }

    int rec(Node root) {
        if(root == null) {
            return 0;
        }
        int left = Math.max(0,rec(root.left));
        int right = Math.max(0,rec(root.right));

        ans = Math.max(left + right + root.data, ans);

        return  root.data +  Math.max(left, right);

    }
}


//TC : O(n)
//SC : O(h)