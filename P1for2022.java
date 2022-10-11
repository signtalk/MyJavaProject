public class P1for2022 {
    public static void main(String[] args){
        int pointsForLevelOne = 220;
        int pointsForLevelTwo = 110;
        int pointsForLevelThree = 500;


        Level lev1 = new Level(pointsForLevelOne);
        Level lev2 = new Level(pointsForLevelTwo);
        Level lev3 = new Level(pointsForLevelThree);

        System.out.print(lev1.goalReached());
        System.out.print(lev2.goalReached());
        System.out.print(lev3.goalReached());
        
        Game gm = new Game(lev1, lev2, lev3);
        System.out.print(gm.getScore());

    }
}

class Level {
    private int points;
    private boolean isBonus;
    private int successForLevel;


    public Level(int points) {
        this.points = points;
    }

    public int getPoints() {

        return points;

    }


    public boolean goalReached() {
        if (points >= successForLevel) {
            return true;
        } else {
            return false;
        }

    }
}

class Game{
    private Level levelOne;
    private Level levelTwo;
    private Level levelThree;


    public Game(Level levelOne, Level levelTwo, Level levelThree){
        this.levelOne = levelOne;
        this.levelTwo = levelTwo;
        this.levelThree = levelThree;
    }

    public int getScore() {
        int score = 0;

        if(levelOne.goalReached()) {
            score += levelOne.getPoints();

            if(levelTwo.goalReached()) {
                score += levelTwo.getPoints();

                if(levelThree.goalReached()) {
                    score += levelThree.getPoints();
                }
            }
        }

        if(isBonus())
            score *= 3;

        return score;
    }

    public boolean isBonus(){

        return true;
    }
}




