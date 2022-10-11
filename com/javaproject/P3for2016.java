package com.javaproject;

import java.util.List;

public class P3for2016 {
    public static void main(String[] args){
        Square sq = new Square(true, 8);

    }
}

class Square{
    private boolean isBlack;
    private int num;

    public Square(boolean isBlack, int num){
        this.isBlack = isBlack;
        this.num = num;
    }

    public boolean getIsBlack(){
        return isBlack;
    }

    public int getNum(){
        return num;
    }
}

class Crossword{
    public Crossword(boolean[][] blackSquares)
    {

        Square[][] puzzle;
        puzzle = new Square[blackSquares.length][blackSquares[0].length];

        int num = 1;

        for(int r = 0; r < puzzle.length; r++)
        {
            for(int c = 0; c < puzzle[0].length; c++)
            {
                if(toBeLabeled(r, c, blackSquares))
                {
                    puzzle[r][c] = new Square(false, num);
                    num++;
                }
                else
                    puzzle[r][c] = new Square(blackSquares[r][c], 0);
            }
        }
    }

    private boolean toBeLabeled(int r, int c, boolean[][] blackSquares)
    {
        if(blackSquares[r][c])
            return false;

        if(r == 0 || blackSquares[r - 1][c])
            return true;

        if(c == 0 || blackSquares[r][c - 1])
            return true;

        return false;
    }
}
