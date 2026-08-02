package dsa.trees;

//Preorder visits Root → Left → Right, so build nodes in the same order.
//Use an upper bound to decide whether the current value belongs to the current subtree.
//Maintain one global index so every preorder element is consumed exactly once.

public class L48_construct_BST_From_Pre_Order {
    int i = 0;
    public TreeNode bstFromPreorder(int[] preorder) {
        return rec(preorder, (int) 1e9);
    }


    TreeNode rec(int[] preorder, int ub) {


        if(i >= preorder.length ||  preorder[i] > ub) {
            return null;
        }

        TreeNode node = new TreeNode(preorder[i++]);

        node.left = rec(preorder, node.val);
        node.right = rec(preorder, ub);

        return node;


    }
}


//TC : O(n)
//SC : O(h)