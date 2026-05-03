package dsa.BinarySearchProg;

public class L5_Search_In_Rotated_Sorted_Array_2 {
    public boolean search(int[] arr, int key) {
        // code here
        int start = 0;
        int end = arr.length -1;

        while(start <= end) {
            int mid = (start + end) / 2;
            if(arr[mid] == key) {
                return true;
            }

            if(arr[start] == arr[mid] && arr[mid] == arr[end]) {
                start++;
                end--;
                continue;
            }

            if(arr[start] <= arr[mid]) {
                if(arr[start] <= key && key < arr[mid]) {
                    end = mid - 1;
                }
                else {
                    start = mid + 1;
                }
            }
            else {
                if(arr[mid] < key && key <= arr[end]) {
                    start = mid + 1;
                }
                else {
                    end = mid - 1;
                }

            }
        }

        return false;
    }
}

//TC : O(logn)
//SC : O(1)