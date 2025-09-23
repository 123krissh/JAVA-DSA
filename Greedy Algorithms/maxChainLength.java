import java.util.*;

public class maxChainLength {

    public static void maxChianLength(int pairs[][]){ //O(nlogn)
        Arrays.sort(pairs, Comparator.comparingDouble(o -> o[1]));
        int chainLen = 1;
        int chainEnd = pairs[0][1];

        for (int i = 0; i < pairs.length; i++) {
            if(pairs[i][0] > chainEnd){
                chainLen++;
                chainEnd = pairs[i][1];
            }
        }
        System.out.println("Max length of chain pairs = " + chainLen);
    }

    public static void indianCoins(Integer coins[], int amount){
        Arrays.sort(coins, Comparator.reverseOrder());

        int countofCoins = 0;
        ArrayList<Integer> ans = new ArrayList<>();

        for (int i = 0; i < coins.length; i++) {
            if(coins[i] <= amount){
                while (coins[i] <= amount) {
                    countofCoins++;
                    ans.add(coins[i]);
                    amount -= coins[i];
                }
            }
        }
        System.out.println("Total min coins used = " + countofCoins);

        for (int i = 0; i < ans.size(); i++) {
            System.out.print(ans.get(i) + " ");
        }
        System.out.println();
    }
    
    public static void main(String[] args) { 
        int pairs[][] = {{5, 24}, {39, 60}, {5, 28}, {27, 40}, {50, 90}};
        maxChianLength(pairs);
        
        Integer coins[] = {1,2,5,10,20,50,100,500,2000};
        int amount = 590;
        indianCoins(coins, amount);
    }
}
