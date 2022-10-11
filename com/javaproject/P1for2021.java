package com.javaproject;

public class P1for2021 {
    public static void main(String[] args) {
        WordMatch wm = new WordMatch("Mississippi");
        System.out.print(wm.findBetterGuess("i", "iss"));

    }

}

class WordMatch {

    private String secret;

    public WordMatch(String word) {
        secret = word;
    }


    private int scoreGuess(String guess) {
        int index = 0;
        int fromIndex = 0;
        int score = 0;

        while(index != -1){
            index = secret.indexOf(guess, fromIndex);
            if(index != -1){
                fromIndex = index + 1;
                score ++;
            }
        }
        return score;
    }


    public String findBetterGuess(String guess1, String guess2) {
        double guessLength1 = Math.pow(guess1.length(), 2);
        double guessLength2 = Math.pow(guess2.length(), 2);
        double finalScore1 = scoreGuess(guess1) * guessLength1;
        double finalScore2 = scoreGuess(guess2) * guessLength2;

        if(finalScore1 > finalScore2){
            System.out.println(finalScore1);
            return guess1;
        } else{
            System.out.println(finalScore2);
            return guess2;
        }
    }

}
