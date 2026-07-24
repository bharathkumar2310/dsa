package dsa.BinarySearchProg;

public class L21_Minimize_Max_Dis_Ben_Gas_Station {
    public double minMaxDist(int[] stations, int K) {
        // code here

        double start = 0;
        double end = 0;
        int n = stations.length;
        for(int i=0; i<n - 1; i++) {
            end = Math.max(end, stations[i+1]- stations[i]);
        }

        double min = 1e-6;
        while(end - start > min ) {
            double mid = (start + end) / 2;
            if(func(mid, stations) <= K) {
                end = mid;
            }
            else {
                start = mid;
            }
        }
        return end;
    }


    int func(double mid, int[] arr) {
        int cnt = 0;
        for(int i=0; i< arr.length - 1; i++) {
            double space = (double)(arr[i+1] - arr[i]);
            double div = space/ mid;
            if(space ==  (int)div * mid) {
                cnt += (int)div -1;
            }
            else {
                cnt+= (int)div;
            }

        }
        return cnt;
    }
}

//TC :O(log(maxGap / 1e-6))
//SC : O(1)






//BETTER
//class Data {
//    double gap;
//    int index;
//    public Data(double gap, int index) {
//        this.gap = gap;
//        this.index = index;
//    }
//}
//public double minMaxDist(int[] stations, int K) {
//    // code here
//    int n = stations.length;
//    if(n==1) {
//        return 0.0;
//    }
//    int[] gap = new int[n-1];
//    Arrays.fill(gap, 1);
//    PriorityQueue<Data>pq = new PriorityQueue<>((a,b)-> Double.compare(b.gap, a.gap));
//    for(int i=0; i<n-1; i++) {
//        pq.add(new Data((double)stations[i+1] - stations[i], i));
//    }
//
//    for(int i=0; i<K; i++) {
//        Data data = pq.poll();
//        int index = data.index;
//        gap[index]++;
//        double space = (stations[index+1] - stations[index])/(double)gap[index];
//        pq.add(new Data(space, index));
//    }
//    return pq.peek().gap;
//}


//TC : O(nlogn + k logn)
//SC : O(n + n)





//WORST CASE(BRUTE FORCE)
//public double minMaxDist(int[] stations, int K) {
//    // code here
//    int n = stations.length;
//    if(n==1) {
//        return 0.00;
//    }
//    int[] gap = new int[n-1];
//
//    for(int i=0; i<K; i++) {
//        double max = 0;
//        int maxIndex = 0;
//        for(int j=0; j<n-1; j++) {
//            int dis = stations[j + 1] - stations[j];
//            double currDis = dis/(double)(gap[j] + 1);
//            if(currDis > max) {
//                max = currDis;
//                maxIndex = j;
//            }
//        }
//        gap[maxIndex]++;
//    }
//
//    double max = 0;
//    for(int i=0; i<n-1; i++) {
//        int dis1 = stations[i + 1] - stations[i];
//        double currDis1 = dis1/(double)(gap[i] + 1);
//        max= Math.max(max,currDis1);
//    }
//
//    return max;
//}

//TC : O(n*k) + O(n)
//SC : O(n)



