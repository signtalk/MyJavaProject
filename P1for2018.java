public class P1for2018{
    public static void main(String [] args){
        FrogSimulation sim = new FrogSimulation(24, 5);
        int totalSteps = sim.hopDistance();
        boolean result = sim.simulate(totalSteps);
        System.out.println(result);
        int num = (int)(Math.random() * (totalSteps + 1));
        sim.runSimulation(num, totalSteps, result);
    }
}

class FrogSimulation {
    private int goalDistance;
    private int maxHops;
    private int[] steps;

    public FrogSimulation(int goalDistance, int maxHops) {
        this.goalDistance = goalDistance;
        this.maxHops = maxHops;
        this.steps = new int[]{5, 7, -15, 8, 60};
    }

    public int hopDistance() {
        int totalSteps = 0;
        for (int i = 0; i < steps.length; i++) {
            totalSteps += steps[i];
        }
        return totalSteps;
    }

    public boolean simulate(int totalSteps) {
        int hops = 0;
        for (int i = 0; i < steps.length; i++) {
            hops++;
            for (int j = 0; j <= i; j++) {
                if (totalSteps < goalDistance || hops == maxHops || totalSteps < 0) {
                    return false;
                }
            }
        }
        return true;
    }

    public double runSimulation(int num, int totalSteps, boolean result) {
        double k = 0;
        if (result == true) {
            double proportion = (double) num / (double) totalSteps;
            System.out.println(proportion);
        }
        return k;
    }
}
