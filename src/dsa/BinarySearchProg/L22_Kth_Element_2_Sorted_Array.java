package dsa.BinarySearchProg;

public class L22_Kth_Element_2_Sorted_Array {
    public int kthElement(int a[], int b[], int k) {
        // code here
        int n = a.length;
        int m = b.length;

        if(n> m) {
            return kthElement(b,a,k);
        }

        int start = Math.max(0,k-m);
        int end = Math.min(k, n);
        while(start <= end) {
            int mid1 = (start + end) / 2;
            int mid2 = k - mid1;

            int l1 = mid1 -1 >=0   ? a[mid1 - 1]: -1;
            int l2 = mid2 -1 >=0    ? b[mid2 - 1]: -1;
            int r1 = mid1 <n     ? a[mid1] : (int)1e9;
            int r2 = mid2 < m      ? b[mid2] : (int)1e9;

            if(l1<= r2 && l2 <= r1 ) {
                return Math.max(l1, l2);
            }
            else if(l1 > r2) {
                end = mid1 -1;
            }
            else {
                start = mid1 + 1;
            }
        }

        return -1;
    }
}

// TC : O(log(end - start))
//SC : O(1)