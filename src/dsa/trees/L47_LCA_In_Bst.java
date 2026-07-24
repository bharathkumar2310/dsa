package dsa.trees;

public class L47_LCA_In_Bst {
    public Node LCA(Node root, Node n1, Node n2) {
        // code here
        Node temp = root;
        while(temp != null) {

            if(temp.data < n1.data && temp.data < n2.data) {
                temp = temp.right;
            }
            else if(temp.data > n1.data && temp.data > n2.data) {
                temp = temp.left;
            }
            else {
                return temp;
            }
        }

        return null;
    }
}

//TC : O(logn) will be O(n) if skewed can say O(h)
//SC : O(1)

