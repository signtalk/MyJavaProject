package com.javaproject;

public class P1for2019 {
    public static void main(String[] args) {
        int year = 2022;
        int year1 = 2020;
        int year2 = 2022;
        int month = 12;
        int day = 31;
        APCalender apc = new APCalender(year, year1, year2, month, day);
    }


}

class APCalender {
    private int year;
    private int year1;
    private int year2;
    private int month;
    private int day;

    private static int Day_Of_WeekNum[] = {0, 1, 2, 3, 4, 5, 6};
    private static int Day_Of_MonthNum[] = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
    private static int firstDay2020 = Day_Of_WeekNum[5];

    public APCalender(int year, int year1, int year2, int month, int day) {
        this.year = year;
        this.year1 = year1;
        this.year2 = year2;
        this.month = month;
        this.day = day;
    }

    public int getYear() {
        return year;
    }

    public int getYear1() {
        return year1;
    }

    public int getYear2() {
        return year2;
    }

    public int getMonth() {
        return month;
    }

    public int getDay() {
        return day;
    }

    private static boolean isLeapYear(int year) {
        if (year % 4 == 0) {
            return true;
        }
        return false;
    }

    public static int numberOfLeapYear(int year1, int year2) {
        int yearDistance = Math.abs(year1 - year2);
        int num = 0;
        for (int i = 0; i <= yearDistance; i++) {
            if (year1 % 400 == 0 || year1 % 4 == 0 && year1 % 100 != 0 && year1 > year2) {
                num++;
                System.out.println(year1);
            } else {

            }
            num++;
        }
        return num;
    }



        private static int dayOff(int month, int day, int year){
            int totalDays = 0;
            for(int i = 0; i <= month - 1; i++){
                totalDays += Day_Of_MonthNum[i];
            }
            totalDays += firstDay2020 + day - 2;
            return totalDays;
        }

    public int normalYears(int num, int yearDistance, int totalDays){
        int totalNormalYears = yearDistance + totalDays + firstDay2020;

        return totalNormalYears;
    }

    public int weekDayNum(int totalNormalYears){
        int dayNum = (totalNormalYears) % 7;
        System.out.println("The number of a day is: " + dayNum);
        return dayNum;
    }

    

}
