package com.javaproject;

import java.util.ArrayList;

public class P1for2020 {
    public static void main(String[] args){
        Gizmo gm1 = new Gizmo("SmartPhone","AA", true, 599.99);
        Gizmo gm2 = new Gizmo("Beaf","AA",false, 9.99);
        Gizmo gm3 = new Gizmo("SmartPhone2","BB", true, 499.99);
        Gizmo gm4 = new Gizmo("Pork", "CC",false, 5.99);
        Gizmo gm5 = new Gizmo("SmartPhone", "AA",true, 599.99);
        //Gizmo gm6 = new Gizmo("SmartPhone","AA", true, 599.99);

        onlinePurchaseManager opm = new onlinePurchaseManager();

        opm.addToList(gm1);
        opm.addToList(gm2);
        opm.addToList(gm3);
        opm.addToList(gm4);
        opm.addToList(gm5);
        //opm.addToList(gm6);

        System.out.println(opm.countElectronicsByMaker("AA"));
        System.out.println(opm.hasAdjacentEqualPair());

        Gizmo g = opm.leastExpensiveGizmo("AA");
        System.out.println(g.getName() +  " " + g.getPrice());



    }
}

class Gizmo{
    private String name;
    private String maker;
    private boolean isElectronic;
    private double price;

    public Gizmo(String n, String m, boolean ie, double p){
        name = n;
        maker = m;
        isElectronic = ie;
        price = p;
    }
    public String getName(){
        return name;
    }

    public String getMaker(){
        return maker;
    }

    public boolean isElectronic(){
        return isElectronic;
    }

    public double getPrice(){
        return price;
    }

    public boolean equals(Object others){
        Gizmo gm = (Gizmo)others;
        if(name == gm.getName() && maker == gm.getMaker() && price == gm.getPrice()){
            return true;
        }else{
            return false;
        }

    }

}

class onlinePurchaseManager{
    private ArrayList<Gizmo>purchases;

    public onlinePurchaseManager(){
        purchases = new ArrayList<Gizmo>();
    }

    public void addToList(Gizmo gm){
        purchases.add(gm);
    }

    public int countElectronicsByMaker(String makerWant){
        int counter = 0;

        for(Gizmo gmo : purchases){
            if(gmo.getMaker() == makerWant && gmo.isElectronic() == true){
                counter++;
            }
        }
        return counter;
    }

    public boolean hasAdjacentEqualPair(){
        for (int i = 0; i < purchases.size() - 1; i++){
            if(purchases.get(i).equals(purchases.get(i + 1))){
                return true;
            }
            }
        return false;
    }

    public Gizmo leastExpensiveGizmo(String gizmoMakerWant){

        double priceLeast = 1000.0;

        Gizmo objectLeast = null;

        for (Gizmo gmo : purchases){
            if(gmo.getMaker() == gizmoMakerWant){
                if(gmo.getPrice() < priceLeast){
                    priceLeast = gmo.getPrice();
                    objectLeast = gmo;
                }
            }
        }
        return objectLeast;
    }
}