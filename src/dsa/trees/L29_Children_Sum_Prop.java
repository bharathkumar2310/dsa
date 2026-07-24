package dsa.trees;

public class L29_Children_Sum_Prop {

    public TreeNode childSumProp(TreeNode root) {
        rec(root);
        return root;

    }

    void rec(TreeNode root) {
        if(root == null) {
            return;
        }
        int sum = 0;
        if(root.left != null) {
            sum += root.left.val;
        }
        if(root.right != null) {
            sum += root.right.val;
        }

        if(sum > root.val) {
            root.val = sum;
        } else {
            if(root.left != null) {
                root.left.val = root.val;
            }
            if(root.right != null) {
                root.right.val = root.val;
            }
        }

        rec(root.left);
        rec(root.right);

        int sum1 = 0;
        if(root.left != null) {
            sum1 += root.left.val;
        }
        if(root.right != null) {
            sum1 += root.right.val;
        }

        if(root.left != null || root.right != null) {
            root.val = sum1;
        }

    }


}

//TC : O(n)
//SC :O(n)