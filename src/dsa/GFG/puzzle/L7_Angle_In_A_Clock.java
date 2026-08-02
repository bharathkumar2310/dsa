package dsa.GFG.puzzle;

public class L7_Angle_In_A_Clock {
    public double getAngle(String s) {
        // code here
        String[] parts = s.split(":");

        int h = Integer.parseInt(parts[0]);
        int m = Integer.parseInt(parts[1]);

        h = h%12;
        double hourDegree = 30 * h + 0.5 * m;
        double minDegree = 6*m;

        double diff =  Math.abs(hourDegree - minDegree);
        return Math.min(diff, 360-diff);
    }
}

//TC : O(1)
//SC : O(1)

//Total hr in a clock = 12
// so degree of hour hand movement per hour is 360/12 = 30
// but hour hand also moves within 60 mins also which is 30/60 = 0.5 degree every minuite

//so hourDegree = 30h + o.5m

// similarly minuitr hand moves 360/60 = 6m
//so we subract hrhand degree - minhandegree