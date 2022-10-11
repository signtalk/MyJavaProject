package com.javaproject;

import java.util.ArrayList;

public class P4for2021 {
    public static void main(String[] args) {

        ArrayResizer arrayResizer = new ArrayResizer();
        System.out.println(arrayResizer.isNonZero(1));
        System.out.println(arrayResizer.numNonZeroRows());
        int[][] arr2D = arrayResizer.resize();
        for (int i = 0; i < arr2D.length; i++) {

                System.out.println(arr2D[i][0]+"-"+arr2D[i][1]+"-"+arr2D[i][2]);

        }

    }

    static class ArrayResizer {

        private int[][] array2D;
        private int rowWant;
        private int rowNumTrue;

        public ArrayResizer(){
            array2D= new int[][]{{2,1,0}, {1,3,2}, {0,0,0},{4,5,6}};
        }

        public int getRowWant() {
            return rowWant;
        }

        public boolean isNonZero(int r) {
            rowWant = r;

            if(r >= array2D.length){
                return false;
            }

            for (int i = 0; i < array2D.length; i++ ){
                if(i != r )
                    continue;
                for (int j = 0; j < array2D[i].length; j++) {
                        if (array2D[i][j] == 0) {
                            return false;
                    }
                }
            }
            return true;
        }

    public int numNonZeroRows() {
        for (int i = 0; i < array2D.length; i++) {
            for (int j = 0; j < array2D[i].length; j++) {
                if (array2D[i][j] == 0) {
                    rowNumTrue++;
                    break;
                }
            }
        }
        return rowNumTrue;
    }

    public int[][] resize(){
       int reRowNum = rowNumTrue;
       int[][] resizeArray = new int[reRowNum][3];
        ArrayList<int []> reArrayList = new ArrayList<>();

       for (int i = 0; i < array2D.length; i++){
           boolean isZero = false;
           for (int j = 0; j < array2D[i].length; j++){
               if(array2D[i][j] == 0){
                   isZero = true;
                   break;
               }

           }
           if (isZero == false) {
               reArrayList.add(array2D[i]);
           }

       }

        int[][] reArray2D = new int[reArrayList.size()][3];
        reArrayList.toArray(reArray2D);
       return reArray2D;

    }

    }

}


