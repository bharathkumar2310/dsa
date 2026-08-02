package dsa.trees;

import java.util.Stack;

//Always keep the leftmost path in the stack.
//next() pops the top (smallest node), then pushes the leftmost path of its right subtree.
//Each node is pushed and popped exactly once, so next() is amortized O(1).

class L50_BSTIterator {

    Stack<TreeNode> stack;
    TreeNode node;
    //TC : O(h)
    public L50_BSTIterator(TreeNode root) {
        stack = new Stack<>();
        node = root;
        while(node != null) {
            stack.add(node);
            node = node.left;
        }
    }


//TC : O(h)
    public int next() {
        TreeNode node = stack.pop();
        int ans = node.val;
        node = node.right;
        while(node != null) {
            stack.add(node);
            node = node.left;
        }
        return ans;
    }

    //TC : O(1)
    public boolean hasNext() {
        if(!stack.isEmpty()) {
            return true;
        }
        return false;
    }
}

//SC : O(h)


