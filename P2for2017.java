public class P2for2017 {
}

class MultPractice{
    private int first;
    private int second;
    public MultPractice(int num1, int num2)
    {
        first = num1;
        second = num2;
    }
    public String getProblem()
    {
        return first + " TIMES " + second;
    }
    public void nextProblem()
    {
        second++;
    }
}