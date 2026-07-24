package dsa.trees;

import java.util.ArrayList;
import java.util.Stack;

public class L9_Iterative_PreOrder {
    ArrayList<Integer> preOrder(Node root) {
        // code here
        if(root == null) {
            return new ArrayList<>();
        }

        ArrayList<Integer> ans = new ArrayList<>();
        Stack<Node> st = new Stack<>();
        st.add(root);

        while(!st.isEmpty()) {

            Node node = st.pop();
            ans.add(node.data);

            if(node.right != null)  {
                st.add(node.right);
            }

            if(node.left != null) {
                st.add(node.left);
            }

        }

        return ans;
    }
}

//TC : O(n)
//SC : O(n)