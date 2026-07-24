package dsa.trees;
import java.util.*;

//same as L30_Print_All_Nodes_At_Distance_K
public class L31_Min_Time_Taken_To_Burn_Binary_Tree {
    public int minTime(Node root, int target) {
        // code here
        return distanceK(root, target);
    }

    public int distanceK(Node root, int target) {
        int ans = 0;
        Map<Node, Node> parent = new HashMap<>();
        Map<Node, Integer> visited = new HashMap<>();

        Queue<Node> q = new LinkedList<>();
        q.add(root);
        parent.put(root, null);

        Node targetNode = null;

        while(!q.isEmpty()) {
            int size = q.size();
            for(int i=0; i<size; i++) {
                Node node = q.poll();
                if(node.data == target) {
                    targetNode = node;
                }
                if(node.left != null) {
                    q.add(node.left);
                    parent.put(node.left, node);
                }
                if(node.right != null) {
                    q.add(node.right);
                    parent.put(node.right, node);
                }
            }
        }

        q.clear();

        q.add(targetNode);
        visited.put(targetNode, 1);
        while(!q.isEmpty()) {
            boolean burned = false;
            int size = q.size();
            for(int i=0; i<size; i++) {
                Node node = q.poll();
                if(node.left != null && visited.get(node.left) == null) {
                    q.add(node.left);
                    visited.put(node.left, 1);
                    burned = true;

                }
                if(node.right != null && visited.get(node.right) == null) {
                    q.add(node.right);
                    visited.put(node.right, 1);
                    burned = true;

                }
                if(parent.get(node) != null && visited.get(parent.get(node)) == null) {
                    q.add(parent.get(node));
                    visited.put(parent.get(node) , 1);
                    burned = true;


                }
            }

            if(burned) {
                ans++;
            }
        }


        return ans;


    }
}


//TC :O(2n)
//SC : O(3n)