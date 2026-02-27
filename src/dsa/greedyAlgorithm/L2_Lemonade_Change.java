package dsa.greedyAlgorithm;

class L2_Lemonade_Change {
    public boolean lemonadeChange(int[] bills) {
        int five = 0;
        int ten = 0;
        int twenty = 0;

        for(int i=0; i<bills.length; i++) {
            if(bills[i] == 5) {
                five++;
            }
            else if(bills[i] == 10) {
                if(five>0) {
                    five--;
                } else {
                    return false;
                }
                ten++;
            }
            else if(bills[i] == 20) {
                if(ten>0 && five>0) {
                    ten--;
                    five--;
                }
                else if(five>2) {
                    five -= 3;
                }
                else{
                    return false;
                }
                twenty++;
            }
        }
        return true;
    }
}

//TC : O(n)
//SC : O(1)