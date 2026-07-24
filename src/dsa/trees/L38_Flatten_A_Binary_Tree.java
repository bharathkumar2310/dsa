package dsa.trees;

public class L38_Flatten_A_Binary_Tree {
    static Node prev;
    public static void flatten(Node root) {
        // code here
        prev = null;
        rec(root);

    }

    static void rec(Node root) {
        if(root == null) {
            return;
        }

        rec(root.right);
        rec(root.left);

        root.right = prev;
        root.left = null;
        prev = root;
    }
}

//TC : O(N)
//SC : O(N)