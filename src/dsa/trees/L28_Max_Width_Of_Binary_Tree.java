package dsa.trees;

import java.util.LinkedList;
import java.util.Queue;

public class L28_Max_Width_Of_Binary_Tree {
    class Pair {
        TreeNode node;
        Long index;

        Pair(TreeNode node, Long index) {
            this.node = node;
            this.index = index;
        }
    }
    public int widthOfBinaryTree(TreeNode root) {
        if(root == null) {
            return 0;
        }
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(root, 0L));
        int ans = 0;

        while(!q.isEmpty()) {
            int size = q.size();
            long min = 0;
            long max = 0;
            for(int i=0; i<size; i++) {

                Pair  pair = q.poll();
                TreeNode node = pair.node;
                long index = pair.index;
                if(i==0) {
                    min = index;
                }
                if(i==size -1) {
                    max = index;
                }


                if(node.left != null ) {
                    q.add(new Pair(node.left, 2 * index));
                }
                if(node.right != null ) {
                    q.add(new Pair(node.right, 2 * index + 1));
                }
            }

            ans = (int) Math.max(ans, max - min + 1);;

        }

        return ans;
    }
}

//TC : O(n)
//SC : O(n)