public class P3for2017 {
    public static void main(String[] args){
        Phrase phr = new Phrase("A cat ate late.");
        phr.replaceNthOccurrence("ct",2, "att");
        phr.findLastOccurrence("at");
        phr.findNthOccurrence("at", 2);

    }


}

class Phrase{
    private String currentPhrase;


    public Phrase(String p){
        currentPhrase = p;
    }

    public String getCurrentPhrase(){
        return getCurrentPhrase();
    }

    public void replaceNthOccurrence(String str, int n, String repl) {

        int index = 0;


        for(int i = 0; i < currentPhrase.length(); i++) {
            if (!str.equals(currentPhrase.substring(i, i + str.length()))) {
                index = -1;
                continue;
            } else {
                index = i;
                break;
            }
        }

            if (index != -1) {
                currentPhrase = currentPhrase.substring(0, index) + repl + currentPhrase.substring(index + str.length());
            }

        System.out.println(currentPhrase);

        }


    public int findLastOccurrence(String str)
    {
        int n = 1;
        int index = -1;
        int nextIndex = findNthOccurrence(str, n);
        while(nextIndex != -1)
        {
            index = nextIndex;
            n++;
            nextIndex = findNthOccurrence(str, n);
            System.out.println(index);
        }


        return index;
    }




    public int findNthOccurrence(String str, int n) {

        int index = 0;

        for(int i = 0; i < currentPhrase.length(); i++) {
            if (str.equals(currentPhrase.substring(i, i + str.length()))) {
                index = -1;
                continue;

            } else {
                index = i;
                break;
            }
        }

        if (index == -1){
            System.out.println(index);
        }

        return index;
    }

}