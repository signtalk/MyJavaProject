package com.javaproject;

import java.util.ArrayList;
import java.util.List;

public class P4for2016 {
    public static void main(String[] args){
        List<String> wordList = new ArrayList<>();
        wordList.add("This is my car.");
        StringFormatter sfm = new StringFormatter(wordList, 3);
    }
}

class StringFormatter{
    private List<String> wordList;

    private int formattedLen;

    public StringFormatter(List<String> wordList, int formattedLen){
            this.wordList = wordList;
            this.formattedLen = formattedLen;
    }

    public List<String> getWordList(List<String> wordList){
        return this.wordList;
    }
    public static int totalLetters(List<String> wordList)
    {
        int letters = 0;

        for(String word : wordList)
            letters += word.length();

        return letters;
    }

    public static int basicGapWidth(List<String> wordList, int formattedLen)
    {
        int gaps = wordList.size() - 1;
        int spaces = formattedLen - totalLetters(wordList);
        return spaces / gaps;
    }

    public static String format(List<String> wordList, int formattedLen)
    {
        int width = basicGapWidth(wordList, formattedLen);
        int leftoverRemaining = leftoverSpaces(wordList, formattedLen);

        String formatted = "";
        for(int i = 0; i < wordList.size() - 1; i++)
        {
            formatted += wordList.get(i);

            for(int s = 1; s <= width; s++)
                formatted += " ";

            if(leftoverRemaining > 0)
            {
                formatted += " ";
                leftoverRemaining--;
            }
        }

        formatted += wordList.get(wordList.size() - 1);

        return formatted;
    }

    private static int leftoverSpaces(List<String> wordList, int formattedLen) {
        int gaps = wordList.size() - 1;
        int spaces = formattedLen - totalLetters(wordList);
        return spaces - gaps;

    }


}
