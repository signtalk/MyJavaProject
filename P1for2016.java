public class P1for2016 {
    public static void main(String[] args){
        String str[] = new String[]{"2","3","4"};
        RandomStringChooser rsc = new RandomStringChooser(str);
    }

}



class RandomStringChooser {

    private String[] values;
    private int valuesRemaining;

    public RandomStringChooser(String[] str)
    {
        values = new String[str.length];

        for(int i = 0; i < values.length; i++)
            values[i] = str[i];

        valuesRemaining = values.length;
    }

    public String getNext()
    {
        if(valuesRemaining == 0) {
            return "NONE";
        }

        int index = (int) (Math.random() * valuesRemaining);

        String selected = values[index];
        values[index] = values[valuesRemaining - 1];

        valuesRemaining--;

        return selected;
    }
}