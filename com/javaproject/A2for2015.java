package com.javaproject;

public class A2for2015 {
    public A2for2015(){}
    public static void main(String[] args) {
        int[] array = new int[]{1,2,3,4,5};
        DiverseArray aS = new DiverseArray(array);
        aS.ArraySum();
    }

}

class DiverseArray {
    private int[] array;


    public DiverseArray(int[] array){
        this.array = array;
    }

    public int ArraySum(){
        int sum = 0;
        for(int i = 0; i < array.length; i++){
            sum += array[i];
        }
        System.out.println(sum);
        return sum;
    }

        }