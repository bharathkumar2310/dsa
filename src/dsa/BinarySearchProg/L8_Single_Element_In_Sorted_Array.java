package dsa.BinarySearchProg;

public class L8_Single_Element_In_Sorted_Array {
    public int singleNonDuplicate(int[] arr) {
        int start = 0;
        int end = arr.length - 1;

        if(arr.length == 1 || arr[0] != arr[1]) {
            return arr[0];
        }
        if(arr[arr.length - 1] != arr[arr.length -2]) {
            return arr[arr.length -1];
        }

        while(start <= end) {
            int mid  = (start + end) / 2;
            if(mid >0 && mid < arr.length -1 &&arr[mid - 1] != arr[mid] && arr[mid] != arr[mid + 1]) {
                return arr[mid];
            }
            if(mid % 2 == 0) {
                if(arr[mid] == arr[mid + 1]) {
                    start = mid + 1;

                }
                else{
                    end = mid - 1;
                }
            }
            else {
                if(arr[mid] == arr[mid - 1]) {
                    start = mid + 1;
                }
                else {
                    end = mid -1;
                }
            }

        }

        return -1;
    }
}

//TC : O(logn)
//SC : O(1)