package dsa.Arrays;

public class L26_Count_Inversion {

    static int inversionCount(int arr[]) {
        // Code Here
        return mergeSort(0, arr.length - 1, arr);

    }

    static int mergeSort(int start, int end, int[] arr) {

        int count = 0;
        if(start >= end) {
            return 0;
        }

        int mid = (start + end) / 2;
        count +=  mergeSort(start, mid, arr);
        count += mergeSort(mid + 1, end, arr);
        count += merge(start, mid, end, arr);
        return count;
    }

    static public int merge(int start, int mid, int end, int[] arr) {


        int[] temp = new int[end - start + 1];
        int i= start;
        int j=mid + 1;

        int k = 0;
        int count = 0;
        while(i<= mid && j<= end) {
            if(arr[i] <= arr[j]) {
                temp[k++] = arr[i];
                i++;
            }
            else {
                count += mid - i + 1;
                temp[k++] = arr[j];
                j++;
            }
        }
        while(i<= mid) {
            temp[k++] = arr[i++];
        }
        while(j<= end) {
            temp[k++] = arr[j++];
        }
        int a = start;
        int b = 0;
        while(a<= end && b <= temp.length - 1) {
            arr[a++] = temp[b++];
        }
        return count;
    }
}

//TC : O(nlogn)
//SC : O(n)