public class waterBottle {
    
    public static int numWaterBottles(int numBottles, int numExchange) {
        int currFullBottles = numBottles;
        int currEmptyBottles = 0;
        int totalDrink = 0;

        while(currFullBottles > 0){
            totalDrink += currFullBottles;
            currEmptyBottles += currFullBottles;
            int newFullBottle = currEmptyBottles/numExchange;
            int remEmptyBottles = currEmptyBottles % numExchange;
            currFullBottles = newFullBottle;
            currEmptyBottles = remEmptyBottles;
        }
        return totalDrink; 
    }

    public static int maxBottlesDrunk(int numBottles, int numExchange) {
        int totalDrunk = 0;
        int currEmptyBottle = 0;
        int currFullBottle = numBottles;

        while(currFullBottle > 0){
            totalDrunk += currFullBottle;
            currEmptyBottle += currFullBottle;
            currFullBottle = 0;

            if(currEmptyBottle >= numExchange){
                currEmptyBottle -= numExchange;
                numExchange++;
                currFullBottle++;
            }
        }
        return totalDrunk;
    }

    public static void main(String[] args) {
        int numBottles = 15;
        int numExchange = 4;
        System.out.println("Total drunk water bottles: " + numWaterBottles(numBottles, numExchange));
        System.out.println("Max Bottles Drunk: " + maxBottlesDrunk(numBottles, numExchange));
    }
}
