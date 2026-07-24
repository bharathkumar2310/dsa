package dsa.trees;

import java.util.ArrayList;

public class L20_Boundary_Traversal {

    ArrayList<Integer> boundaryTraversal(Node root) {
        // code here

        if(root == null) {
            return new ArrayList<>();
        }

        ArrayList<Integer> ans = new ArrayList<>();
        if(!isLeafNode(root)) {
            ans.add(root.data);
        }

        Node temp = root.left;
        while(temp != null) {
            if(!isLeafNode(temp)) {
                ans.add(temp.data);
            }
            if(temp.left != null) {
                temp = temp.left;
            }
            else {
                temp = temp.right;
            }
        }

        findLeafNode(root, ans);
        temp = root.right;

        ArrayList<Integer> ans1 = new ArrayList<>();
        while(temp != null) {
            if(!isLeafNode(temp)) {
                ans1.add(temp.data);
            }
            if(temp.right != null) {
                temp = temp.right;
            }
            else {
                temp = temp.left;
            }
        }

        for(int i= ans1.size()-1; i>=0; i--) {
            ans.add(ans1.get(i));
        }
        return ans;
    }

    void findLeafNode(Node root, ArrayList<Integer> ans) {

        if(root == null) {
            return;
        }

        if(root.left == null && root.right == null) {
            ans.add(root.data);
            return;
        }

        findLeafNode(root.left, ans);
        findLeafNode(root.right, ans);

    }

    boolean isLeafNode(Node root) {{
        return root.left == null && root.right == null;
    }}
}


//TC : O(2n)
//SC: O(n)