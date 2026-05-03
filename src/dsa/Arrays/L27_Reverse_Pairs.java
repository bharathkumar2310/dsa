package dsa.Arrays;

public class L27_Reverse_Pairs {
    public int reversePairs(int[] nums) {
        return mergeSort(0, nums.length - 1, nums);
    }

    int mergeSort(int start, int end, int[] arr) {

        int count = 0;
        if (start >= end) {
            return 0;
        }

        int mid = (start + end) / 2;
        count += mergeSort(start, mid, arr);
        count += mergeSort(mid + 1, end, arr);
        count += countPairs(start, end, mid, arr);
        merge(start, mid, end, arr);
        return count;
    }

    int countPairs(int start, int end, int mid, int[] arr) {

        int count = 0;
        int j = mid + 1;
        for (int i = start; i <= mid; i++) {

            while (j <= end && (long) arr[i] > 2L * arr[j]) {
                j++;
            }

            count += (j - (mid + 1));
        }

        return count;
    }

    public void merge(int start, int mid, int end, int[] arr) {

        int[] temp = new int[end - start + 1];
        int i = start;
        int j = mid + 1;

        int k = 0;
        while (i <= mid && j <= end) {
            if (arr[i] <= arr[j]) {
                temp[k++] = arr[i];
                i++;
            } else {

                temp[k++] = arr[j];
                j++;
            }
        }
        while (i <= mid) {
            temp[k++] = arr[i++];
        }
        while (j <= end) {
            temp[k++] = arr[j++];
        }
        int a = start;
        int b = 0;
        while (a <= end && b <= temp.length - 1) {
            arr[a++] = temp[b++];
        }
    }
}

//TC : O(nlogn)
//SC : O(n)