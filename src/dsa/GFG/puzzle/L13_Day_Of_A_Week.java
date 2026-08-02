package dsa.GFG.puzzle;

public class L13_Day_Of_A_Week {
    public String getDayOfWeek(int[] date) {
        // code here
        String[] week = {"Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"};
        int[] daysOfMonth = {31, 28,31,30,31,30,31,31,30,31,30,31};
        int totalDays = 0;
        int d = date[0];
        int m = date[1];
        int y = date[2];

        totalDays = (y-1) * 365;
        totalDays += (y-1)/4;
        totalDays -= (y-1)/100;
        totalDays += (y-1)/400;

        for(int i=0; i<m-1; i++) {
            totalDays += daysOfMonth[i];
        }

        totalDays += d;

        if(y%4==0 && (y%400 == 0 || y%100 != 0)) {
            if(m > 2) {
                totalDays++;
            }
        }

        return week[(totalDays) % 7];


    }
}

//TC : O(1)
//SC : O(1)

//Step 1: Calculate total days in all complete years (year - 1).
//Step 2: Add leap days using +/4 -/100 +/400.
//Step 3: Add days in all completed months.
//Step 4: If the current year is a leap year and the month is after February, add one extra day.
//        Step 5: Add the current day.
//Step 6: Map (totalDays - 1) % 7 to the weekday.