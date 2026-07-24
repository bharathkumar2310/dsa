package dsa.LinkedListdsa;

import java.util.ArrayList;

public class L19_Find_All_Pairs_With_Given_Sum_In_DLL {
    public static ArrayList<ArrayList<Integer>> findPairsWithGivenSum(int target,
                                                                      Node head) {
        // code here
        Node start = head;
        Node end = head;

        while(end.next != null) {
            end = end.next;
        }

        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();

        while(start.data < end.data) {
            if(start.data + end.data == target) {
                ArrayList<Integer> ans1 = new ArrayList<>();
                ans1.add(start.data);
                ans1.add(end.data);
                ans.add(ans1);
                start = start.next;
                end = end.prev;
            }

            else if(start.data + end.data > target)  {
                end = end.prev;
            }
            else {
                start = start.next;
            }
        }

        return ans;
    }
}
