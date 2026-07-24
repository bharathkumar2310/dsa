package dsa.trees;

import java.util.ArrayList;
import java.util.Stack;

public class L10_Iterative_In_Order {
    public ArrayList<Integer> inOrder(Node root) {
        // code here
        ArrayList<Integer> ans = new ArrayList<>();
        Stack<Node> st = new Stack<>();
        Node node = root;

        while(true) {
            if(node != null) {
                st.push(node);
                node = node.left;
            }
            else {
                if(st.isEmpty()) {
                    break;
                }
                Node temp = st.pop();
                ans.add(temp.data);
                if(temp.right != null) {
                    node = temp.right;
                }
            }

        }
        return ans;
    }
}


//TC : O(n)
//SC : O(n)