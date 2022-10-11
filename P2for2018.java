import java.util.ArrayList;

public class P2for2018 {
    public static void main(String [] args){
        String[] wordsAll_1 = {"777", "0000", "999", "6666", "5555"};
        String[] wordsAll_2 = {"the", "red", "fox", "the", "red"};

        WordPairList wpl = new WordPairList(wordsAll_2);

        for(WordPair wp: wpl.getAllPairs()){
            System.out.println(wp);
        }

        System.out.println(wpl.numMatches());

        System.out.println(wpl.countMatch(new WordPair("RED", "Fox")));

    }

}

class WordPair{

    private String first;
    private String second;

    public WordPair(String first, String second) {
        this.first = first;
        this.second = second;
    }

    @Override
    public String toString() {
        return "(" + first + ", " + second + ")";
    }

    @Override
    public boolean equals(Object object){
        String first = ((WordPair)object).getFirst();
        String second = ((WordPair)object).getSecond();
        if (first.equalsIgnoreCase(this.first) && second.equalsIgnoreCase(this.second)){
            return true;
        }
        return false;
    }


    public String getFirst() {
        return first;
    }

    public String getSecond() {
        return second;
    }


}

class WordPairList{
    private ArrayList<WordPair> allPairs;

    public WordPairList(String[] words){
        allPairs = new ArrayList<WordPair>();
        for(int i = 0; i < words.length; i++){
            for(int j = i + 1; j < words.length;j++){
                   allPairs.add(new WordPair(words[i], words[j]));
            }

        }

        return;
    }

    public ArrayList<WordPair> getAllPairs() {
        return allPairs;
    }

    public int numMatches(){
        int numCount = 0;

        for(WordPair wp : allPairs){
            if (wp.getFirst().equals(wp.getSecond())){
                numCount++;
            }
        }


        return numCount;
    }

    public int countMatch(WordPair wordpair){
        int ct = 0;
        for (WordPair wp : allPairs){
            if(wp.equals(wordpair)){
                ct++;
            }
        }
        return ct;
    }
}

