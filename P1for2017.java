import java.util.ArrayList;

public class P1for2017 {
    ArrayList<Integer> digitList = new ArrayList<Integer>();
    Digit dgt = new Digit(0);

}
   class Digit {
    private int index;
    ArrayList<Integer> digitList = new ArrayList<Integer>();
        public Digit(int num) {

            digitList.add(0, num % 10);
            double element = num % 10;
            int numRemaining = num / 10;
            while (numRemaining > 0) {
                digitList.add(0, numRemaining % 10);
                numRemaining /= 10;
            }
        }

        public boolean isStrictlyIncreasing()
        {
            for(int i = 1; i < digitList.size(); i++)
                if(digitList.get(i - 1).compareTo(digitList.get(i)) >= 0)
                    return false;

            return true;
        }
    }