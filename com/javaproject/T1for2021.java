public class T1for2021 {
    public static void main(String[] args){
        WordMatch wm = new WordMatch("Mississippi");
        wm.findBetterScore("i","iss");
    }
}

class WordMatch{
    private String secret;

    public WordMatch(String secret){
        this.secret = secret;
    }

    public int scoreGuess(String wordGuess){
        int score = 0;
        int index = 0;
        int fromIndex = 0;

        while(index != -1){
            index = secret.indexOf(wordGuess, fromIndex);
            if (index != -1){
                fromIndex = index + 1;
                score++;
            }

        }
        return score;
    }

    public String findBetterScore(String guess1, String guess2) {
        double guessLength1 = Math.pow(guess1.length(), 2);
        double guessLength2 = Math.pow(guess2.length(), 2);
        double finalScore1 = scoreGuess(guess1) * guessLength1;
        double finalScore2 = scoreGuess(guess2) * guessLength2;
        int i = 0;


        if (!guess1.equals(guess2)) {
            char low1 = guess1.charAt(i);
            char low2 = guess2.charAt(i);

            if (Character.isLowerCase(low1) && Character.isLowerCase(low2)) {
                if (finalScore1 > finalScore2) {
                    System.out.println(finalScore1);
                    return guess1;
                } else {
                    System.out.println(finalScore2);
                    return guess2;
                }
            }
        }
            return null;
        }
    }




