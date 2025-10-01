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

    public static void main(String[] args) {
        int numBottles = 15;
        int numExchange = 4;
        System.out.println("Total drunk water bottles: " + numWaterBottles(numBottles, numExchange));
    }
}
