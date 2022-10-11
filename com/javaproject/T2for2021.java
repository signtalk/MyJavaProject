package com.javaproject;

public class T2for2021 {
    public static void main(String[] args){

        SingleTable1 st1 = new SingleTable1(4,74,60.0);
        SingleTable1 st2 = new SingleTable1(8,74,70.0);
        SingleTable1 st3 = new SingleTable1(12,76,75.0);

        CombinedTable1 c10 = new CombinedTable1(st1,st2);
        CombinedTable1 c20 = new CombinedTable1(st2,st3);

        System.out.println(c20.canSeatReal(21));
        System.out.println(c20.getDesirability());
    }
}

class SingleTable1{
    private int seats;
    private int height;
    private double viewQuality;


    public SingleTable1(int seats, int height, double viewQuality){
        this.seats = seats;
        this.height = height;
        this.viewQuality = viewQuality;

    }

    public int getSeats(){
        return seats;
    }

    public int getHeight(){
        return height;
    }

    public double getViewQuality(){
        return viewQuality;
    }

    public void setViewQuality(double vq) {

        this.viewQuality = vq;
    }
}

class CombinedTable1{

    private SingleTable1 tableGet1;
    private SingleTable1 tableGet2;
    public CombinedTable1(SingleTable1 tableGet1, SingleTable1 tableGet2){
        this.tableGet1 = tableGet1;
        this.tableGet2 = tableGet2;
    }


    public boolean canSeatReal(int seatNum1){
        int seatNumTrue = (tableGet1.getSeats() + tableGet2.getSeats()) - 2;

        if(seatNumTrue >= seatNum1){
            return true;
        }else {
            return false;
        }
    }

    public double getDesirability(){
        double finalDesirability = 0;

        if(tableGet1.getHeight() == tableGet2.getHeight()){
            finalDesirability = (tableGet1.getViewQuality() + tableGet2.getViewQuality())/2;

        }else {
            finalDesirability = (tableGet1.getViewQuality() + tableGet2.getViewQuality())/2 - 10;

        }

        return finalDesirability;

    }

}
