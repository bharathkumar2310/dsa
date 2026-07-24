package dsa.trees;

import java.util.HashMap;
import java.util.Map;

public class L35_Construct_Binary_Tree_From_Post_Order_In_Order {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        Map<Integer, Integer> inMap = new HashMap<>();
        for(int i=0; i< inorder.length; i++) {
            inMap.put(inorder[i] , i);
        }
        return rec(0, inorder.length -1 , inorder, 0 , postorder.length - 1, postorder, inMap);
    }

    TreeNode rec(int inStart, int inEnd, int[] inOrder , int postStart , int postEnd, int[] postOrder, Map<Integer, Integer> inMap) {

        if (inStart > inEnd || postStart > postEnd) {
            return null;
        }



        TreeNode node = new TreeNode(postOrder[postEnd]);
        int inContains = inMap.get(postOrder[postEnd]);

        int diff = inContains - inStart;

        node.left = rec(inStart, inContains -1, inOrder, postStart,  postStart + diff - 1, postOrder, inMap);
        node.right = rec(inContains + 1, inEnd, inOrder, postStart + diff, postEnd -1, postOrder, inMap);

        return node;


    }
}

// TC : O(n)
//SC : O(n)