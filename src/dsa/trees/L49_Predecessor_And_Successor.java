package dsa.trees;

import java.util.ArrayList;

public class L49_Predecessor_And_Successor {
    public ArrayList<Node> findPreSuc(Node root, int key) {
        // code here
        ArrayList<Node> ans = new ArrayList<>();

        ans.add(inOrderPre(root, key));
        ans.add(inOrderSucc(root, key));
        return ans;
    }

    Node inOrderPre(Node root, int key) {
        Node pre = null;
        while(root != null) {
            if(root.data < key) {
                pre = root;
                root = root.right;
            }
            else  {
                root = root.left;
            }
        }
        return pre;
    }

    Node inOrderSucc(Node root, int key) {
        Node succ = null;
        while(root != null) {
            if(root.data <= key) {
                root = root.right;
            }
            else  {
                succ =root;
                root = root.left;
            }
        }
        return succ;
    }
}

//TC : O(h)

//SC : O(2)