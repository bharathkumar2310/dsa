package dsa.trees;

import java.util.HashMap;
import java.util.Map;

public class L34_Construct_Binary_Tree_From_PreOrder_InOrder {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        Map<Integer, Integer> inOrderMap = new HashMap<>();
        for(int i=0; i<inorder.length; i++) {
            inOrderMap.put(inorder[i], i);
        }
        return rec(0,preorder.length - 1, preorder, 0, inorder.length -1, inorder, inOrderMap);
    }

    TreeNode rec(int preStart, int preEnd, int[] preOrder, int inStart, int inEnd, int[] inOrder, Map<Integer, Integer> inOrderMap) {
        if(preStart > preEnd || inStart > inEnd) {
            return null;
        }

        TreeNode node = new TreeNode(preOrder[preStart]);

        int index = inOrderMap.get(preOrder[preStart]);
        int diff = index - inStart;
        node.left = rec(preStart + 1, preStart + diff, preOrder, inStart, index -1, inOrder, inOrderMap);
        node.right = rec(preStart + diff + 1, preEnd, preOrder, index + 1, inEnd, inOrder, inOrderMap);

        return node;

    }
}

//TC : O(n)
//SC : O(n)