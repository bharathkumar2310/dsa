package dsa.trees;

import java.util.Stack;



//
//Create two iterators: one gives the next smallest value, the other the next largest value.
//Treat them like two pointers on a sorted array and compare their sum with the target.
//If the sum is small, move the left iterator; if large, move the right iterator.

public class L51_Two_Sum_In_BST {
    class BSTIterator {

        Stack<Node> stack;
        Node node;
        boolean reverse;
        public BSTIterator(Node root, boolean reverse) {
            stack = new Stack<>();
            node = root;
            this.reverse = reverse;
            while(node != null) {
                stack.add(node);
                if(reverse) {
                    node = node.right;
                } else {
                    node = node.left;
                }
            }
        }



        public int next() {
            Node node = stack.pop();
            int ans = node.data;

            if(reverse) {
                node = node.left;
            } else {
                node = node.right;

            }
            while(node != null) {
                stack.add(node);
                if(reverse) {
                    node = node.right;
                } else {
                    node = node.left;

                }

            }
            return ans;
        }

        public boolean hasNext() {
            if(!stack.isEmpty()) {
                return true;
            }
            return false;
        }
    }



    boolean findTarget(Node root, int target) {
        // Write your code here
        BSTIterator iterator1 = new BSTIterator(root, false);
        BSTIterator iterator2 = new BSTIterator(root, true);

        int a = iterator1.next();
        int b= iterator2.next();
        while(a<b) {
            int sum = a + b;
            if(sum == target) {
                return true;
            }
            else if(sum > target) {
                b= iterator2.next();
            }
            else {
                a = iterator1.next();
            }
        }
        return false;

    }
}

//TC : O(n)
//SC : O(h)


//boolean findTarget(Node root, int target) {
//    // Write your code here
//    List<Integer> list = new ArrayList<>();
//    inOrder(root, list);
//    int i=0;
//    int j = list.size() -1;
//
//    while(i<j) {
//        int sum = list.get(i) + list.get(j);
//        if( sum == target) {
//            return true;
//        }
//        else if(sum > target) {
//            j--;
//        } else {
//            i++;
//        }
//    }
//
//    return false;
//
//}
//
//void inOrder(Node root, List<Integer> list) {
//    if(root == null) {
//        return;
//    }
//
//    inOrder(root.left, list);
//    list.add(root.data);
//    inOrder(root.right, list);
//}

//TC : O(n)
//SC : O(N)