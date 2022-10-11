package com.javaproject;

public class P2for2021 {
    public static void main(String[] args){
        SingleTable t1 = new SingleTable(4,74,60.0);
        SingleTable t2 = new SingleTable(8,74,70.0);
        SingleTable t3 = new SingleTable(12,76,75.0);

        CombinedTable c1 = new CombinedTable(t1,t2);
        CombinedTable c2 = new CombinedTable(t2,t3);

        System.out.println(c2.canSeat(21));
        System.out.println(c2.getDesirability());
    }
}
class SingleTable {
    private int seats;
    private int height;
    private double viewQuality;


    public SingleTable(int s, int h, double v){
        seats = s;
        height = h;
        viewQuality = v;

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

class CombinedTable{

    private SingleTable table1;
    private SingleTable table2;
    public CombinedTable(SingleTable tNum1, SingleTable tNum2){
        table1 = tNum1;
        table2 = tNum2;
    }

    public boolean canSeat(int seatNum){
        int seatNumReal = (table1.getSeats() + table2.getSeats()) - 2;

        if(seatNumReal >= seatNum){
            return true;
        }else {
            return false;
        }
    }

    public double getDesirability(){
        double finalDesirability = 0;

        if(table1.getHeight() == table2.getHeight()){
            finalDesirability = (table1.getViewQuality() + table2.getViewQuality())/2;

        }else {
            finalDesirability = (table1.getViewQuality() + table2.getViewQuality())/2 - 10;

        }

        return finalDesirability;

        }


    }



