package dsa.Arrays;

public class L24_Merge_Sorted_Array_Without_Extra_Space {

    public void mergeArrays(int a[], int b[]) {
        // code here
        int n = a.length;
        int m = b.length;

        int len = n + m;

        int gap = len/2 + len %2;


        while(gap > 0) {
            int left = 0;
            int right = gap;
            while(right < len) {

                if(left < n && right <n) {

                    if(a[left] > a[right]) {
                        int temp = a[left];
                        a[left] = a[right];
                        a[right] = temp;
                    }
                }

                else if(left<n && right <len) {

                    if(a[left] > b[right - n]) {
                        int temp = a[left];
                        a[left] = b[right - n];
                        b[right - n] = temp;
                    }
                }

                else {
                    if(b[left - n] > b[right - n]) {
                        int temp = b[left - n];
                        b[left - n] = b[right - n];
                        b[right - n] = temp;
                    }

                }
                left++;
                right++;
            }
            gap = (gap == 1) ? 0 : (gap / 2 + gap % 2);
        }
    }
}

//TC : TC = O((n + m) log(n + m))
//SC : O(1)


//public void mergeArrays(int a[], int b[]) {
//    // code here
//    int i = a.length -1;
//    int j = 0;
//
//    while(j<b.length && i>=0 && a[i] > b[j]) {
//        int temp = a[i];
//        a[i] = b[j];
//        b[j] = temp;
//
//        i--;
//        j++;
//    }
//
//    Arrays.sort(a);
//    Arrays.sort(b);
//}

//TC : TC = O(n log n + m log m)
// SC : O(1)