package dsa.trees;

public class L32_Count_Total_Nodes_In_Complete_Binary_Tree {
    public int countNodes(TreeNode root) {
        if(root == null) {
            return 0;
        }
        int left = findLeft(root);
        int right = findRight(root);
        if(left == right) {
            return (1<<left) - 1 ;
        }
        return countNodes(root.left) + countNodes(root.right) + 1;
    }

    int findLeft(TreeNode node) {
        if(node == null) {
            return 0;
        }

        int ans  = 1 + findLeft(node.left);
        return ans;
    }

    int findRight(TreeNode node) {
        if(node == null) {
            return 0;
        }

        int ans  = 1 + findRight(node.right);
        return ans;
    }
}

//TC : O(logn)^2
//SC : O(logn)