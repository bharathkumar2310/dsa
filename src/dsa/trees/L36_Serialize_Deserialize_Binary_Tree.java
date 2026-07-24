package dsa.trees;

import java.util.*;

public class L36_Serialize_Deserialize_Binary_Tree {
    public String serialize(TreeNode root) {
        StringBuilder ans = new StringBuilder();
        Queue<TreeNode> q = new LinkedList<>();
        if (root == null) {
            return "null";
        }
        q.add(root);

        while(!q.isEmpty()) {
            TreeNode node = q.poll();
            if (node == null) {
                ans.append("null,");
                continue;
            }
            ans.append(Integer.valueOf(node.val));
            ans.append(",");

            q.add(node.left);
            q.add(node.right);

        }

        ans.deleteCharAt(ans.length() -1);
        return ans.toString();


    }




    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {

        if (data.equals("null")) {
            return null;
        }


        String[] postOrder = data.split(",");
        Queue<TreeNode> q = new LinkedList<>();

        TreeNode root = new TreeNode(Integer.valueOf(postOrder[0]));
        q.add(root);
        int j = 0;

        while(!q.isEmpty()) {
            TreeNode node = q.poll();

            if(j+1 < postOrder.length) {
                j++;
                if(postOrder[j].equals("null")) {
                    node.left = null;
                } else {
                    TreeNode left = new TreeNode(Integer.valueOf(postOrder[j]));
                    q.add(left);
                    node.left = left;
                }
            }

            if(j+1 < postOrder.length) {
                j++;
                if(postOrder[j].equals("null")) {
                    node.right = null;
                } else {
                    TreeNode right = new TreeNode(Integer.valueOf(postOrder[j]));
                    q.add(right);
                    node.right = right;
                }

            }


        }
        return root;

    }
}
