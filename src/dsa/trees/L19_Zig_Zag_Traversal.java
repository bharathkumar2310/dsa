package dsa.trees;

import java.util.*;

public class L19_Zig_Zag_Traversal {
    ArrayList<Integer> zigZagTraversal(Node root) {
        // code here
        if(root == null) {
            return new ArrayList<>();
        }
        ArrayList<Integer>ans = new ArrayList<>();
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        int flag = 0;

        while(!q.isEmpty()) {
            int size = q.size();
            List<Integer> ans1 = new ArrayList<>();
            for(int i=0; i<size; i++) {
                Node node = q.poll();
                if(node.left != null) {
                    q.add(node.left);
                }
                if(node.right != null) {
                    q.add(node.right);
                }
                ans1.add(node.data);
            }

            if(flag == -1) {
                Collections.reverse(ans1);
                flag = 0;
            } else {
                flag = -1;
            }

            for(int i: ans1) {
                ans.add(i);
            }
        }
        return ans;
    }
}

//TC : O(n)
//SC : O(n)