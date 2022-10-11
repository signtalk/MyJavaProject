public class P4for2017 {
    public static void main(String[] args){
        Position ps = new Position(5,6);
    }
}

class Position{
    private int role;
    private int column;
    public Position(int r, int c) {
        this.role = r;
        this.column = c;
    }

    public static Position findPosition(int num, int[][] intArr)
    {
        for(int r = 0; r < intArr.length; r++) {
            for (int c = 0; c < intArr[0].length; c++) {
                if (intArr[r][c] == num) {
                    return new Position(r, c);
                }
            }
        }
        return null;
    }

    public static Position[][] getSuccessorArray(int[][] intArr)
    {
        Position[][] successors = new Position[intArr.length][intArr[0].length];

        for(int r = 0; r < successors.length; r++) {
            for (int c = 0; c < successors[0].length; c++) {
                successors[r][c] = findPosition(intArr[r][c] + 1, intArr);
            }
        }

        return successors;
    }

}
