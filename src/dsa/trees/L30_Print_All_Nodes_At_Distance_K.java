package dsa.trees;

import java.util.*;

public class L30_Print_All_Nodes_At_Distance_K {
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        List<Integer> ans = new ArrayList<>();
        Map<TreeNode, TreeNode> parent = new HashMap<>();
        Map<TreeNode, Integer> visited = new HashMap<>();

        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        parent.put(root, null);

        while(!q.isEmpty()) {
            int size = q.size();
            for(int i=0; i<size; i++) {
                TreeNode node = q.poll();
                if(node.left != null) {
                    q.add(node.left);
                    parent.put(node.left, node);
                }
                if(node.right != null) {
                    q.add(node.right);
                    parent.put(node.right, node);
                }
            }
        }

        q.clear();

        q.add(target);
        visited.put(target, 1);
        while(!q.isEmpty()) {
            if(k == 0) {
                break;
            }

            int size = q.size();
            k--;
            for(int i=0; i<size; i++) {
                TreeNode node = q.poll();
                if(node.left != null && visited.get(node.left) == null) {
                    q.add(node.left);
                    visited.put(node.left, 1);

                }
                if(node.right != null && visited.get(node.right) == null) {
                    q.add(node.right);
                    visited.put(node.right, 1);

                }
                if(parent.get(node) != null && visited.get(parent.get(node)) == null) {
                    q.add(parent.get(node));
                    visited.put(parent.get(node) , 1);

                }
            }
        }

        while(!q.isEmpty()) {
            ans.add(q.poll().val);
        }

        return ans;


    }
}

//can use hashset instead of hashmap for visited

//TC :O(2n)
//SC : O(3n)