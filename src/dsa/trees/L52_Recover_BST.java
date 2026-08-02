package dsa.trees;

public class L52_Recover_BST {
    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     *     int val;
     *     TreeNode left;
     *     TreeNode right;
     *     TreeNode() {}
     *     TreeNode(int val) { this.val = val; }
     *     TreeNode(int val, TreeNode left, TreeNode right) {
     *         this.val = val;
     *         this.left = left;
     *         this.right = right;
     *     }
     * }
     */
    class Solution {
        TreeNode first = null;
        TreeNode mid = null;
        TreeNode last = null;
        TreeNode prev = null;
        public void recoverTree(TreeNode root) {
            inOrder(root);
            if(last != null) {
                int temp = first.val;
                first.val = last.val;
                last.val = temp;
            } else {
                int temp = first.val;
                first.val = mid.val;
                mid.val = temp;
            }

        }

        void inOrder(TreeNode root) {
            if(root == null) {
                return;
            }

            inOrder(root.left);

            if(prev != null && prev.val > root.val) {
                if(mid == null) {
                    first = prev;
                    mid = root;
                }
                else {
                    last = root;
                }
            }

            prev = root;
            inOrder(root.right);
        }
    }
}


//TC : O(n)
//SC : O(h)

//public void recoverTree(TreeNode root) {
//    ArrayList<TreeNode> list = new ArrayList<>();
//    inOrder(root, list);
//    TreeNode first = null;
//    TreeNode mid = null;
//    TreeNode last = null;
//
//    for(int i=1; i<list.size(); i++) {
//        if(list.get(i).val < list.get(i-1).val) {
//            if(mid == null) {
//                first = list.get(i-1);
//                mid = list.get(i);
//            }
//            else {
//                last = list.get(i);
//            }
//        }
//    }
//
//    if(last != null) {
//        int temp = first.val;
//        first.val = last.val;
//        last.val = temp;
//    } else {
//        int temp = first.val;
//        first.val = mid.val;
//        mid.val = temp;
//    }
//
//
//}
//
//void inOrder(TreeNode root, ArrayList<TreeNode> list) {
//    if(root == null) {
//        return;
//    }
//
//    inOrder(root.left, list);
//    list.add(root);
//    inOrder(root.right, list);
//}


//TC : O(n)
//SC : O(n)