package dsa.trees;

import java.util.ArrayList;
import java.util.Stack;

public class L11_Iterartive_Post_Order {
    ArrayList<Integer> postOrder(Node node) {
        // code here
        Stack<Node> st = new Stack<>();
        ArrayList<Integer> ans = new ArrayList<>();

        Node curr = node;

        while(curr != null || !st.isEmpty()) {

            if(curr != null) {
                st.add(curr);
                curr= curr.left;
            } else {
                Node temp = st.peek().right;
                if(temp == null) {

                    temp = st.peek();
                    ans.add(st.pop().data);

                    while(!st.isEmpty() && st.peek().right == temp) {
                        temp = st.peek();
                        ans.add(st.pop().data);
                    }

                } else {
                    curr = temp;
                }
            }

        }

        return ans;
    }
}


//ArrayList<Integer> postOrder(Node node) {
//    // code here
//
//    if(node == null) {
//        return new ArrayList<>();
//    }
//    Stack<Node> st = new Stack<>();
//    Stack<Node> st1 = new Stack<>();
//    ArrayList<Integer> ans = new ArrayList<>();
//
//    st.push(node);
//
//    while(!st.isEmpty()) {
//        Node temp = st.pop();
//        if(temp.left != null) {
//            st.push(temp.left);
//        }
//        if(temp.right !=null) {
//            st.push(temp.right);
//        }
//
//        st1.push(temp);
//    }
//
//    while(!st1.isEmpty()) {
//        ans.add(st1.pop().data);
//    }
//    return ans;
//}

//TC : O(2n)
//SC : O(n)