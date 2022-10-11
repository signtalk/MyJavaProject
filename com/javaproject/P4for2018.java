package com.javaproject;

public class P4for2018 {

    public static void main(String[] args){
        ArrayTester at = new ArrayTester();

    }

}

class ArrayTester{
    public static int[] getColumn(int[][] arr2D, int c)
    {
        int[] column = new int[arr2D.length];

        for(int i = 0; i < column.length; i++)
            column[i] = arr2D[i][c];

        return column;
    }

    public static boolean isLatin(int[][] square) {
        if(containsDuplicates(square[0]))
            return false;

        for(int r = 1; r < square.length; r++)
            if( ! hasAllValues(square[0], square[r]) )
                return false;

        for(int c = 0; c < square[0].length; c++)
            if( ! hasAllValues(square[0], getColumn(square, c)))
                return false;

        return true;
    }

    public static boolean hasAllValues(int[] arr1, int[] arr2) {
        for(int arr1Index = 0; arr1Index < arr1.length; arr1Index++) {
            boolean contains = false;
            for(int arr2Index = 0; arr2Index < arr2.length; arr2Index++) {
                if(arr1[arr1Index] == arr2[arr2Index])
                    contains = true;
            }

            if( ! contains )
                return false;
        }

        return true;
    }

    public static boolean containsDuplicates(int[] arr) {
        for(int i = 0; i < arr.length; i++)
            for(int j = i + 1; j < arr.length; j++)
                if(arr[i] == arr[j])
                    return true;

        return false;
    }
}

