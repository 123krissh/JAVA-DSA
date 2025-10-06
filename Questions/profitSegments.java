import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class profitSegments {
    
    public static int countProfitableSegments(int[] rideList, int targetPremiums) {
        Map<Integer, Integer> prefixCount = new HashMap<>();
        prefixCount.put(0, 1); // base case
        
        int prefixSum = 0;
        int result = 0;
        
        for (int ride : rideList) {
            // convert ride to 1 if premium (odd), else 0
            int isPremium = (ride % 2 != 0) ? 1 : 0;
            prefixSum += isPremium;
            
            // check if there exists prefixSum - targetPremiums
            if (prefixCount.containsKey(prefixSum - targetPremiums)) {
                result += prefixCount.get(prefixSum - targetPremiums);
            }
            
            // update prefix sum count
            prefixCount.put(prefixSum, prefixCount.getOrDefault(prefixSum, 0) + 1);
        }
        
        return result;
    }

    // Brute Force Approch ---->
    public static int countProfitableSegments(int[] rideList, int targetPremiums) {
        int n = rideList.length;
        int totalSegments = 0;

        // try all possible start points
        for (int i = 0; i < n; i++) {
            int premiumCount = 0;

            // expand subarray to the right
            for (int j = i; j < n; j++) {
                // check if current ride is premium
                if (rideList[j] % 2 != 0) {
                    premiumCount++;
                }

                // if premium count matches target, count this subarray
                if (premiumCount == targetPremiums) {
                    totalSegments++;
                }
            }
        }
        return totalSegments;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] rideList = new int[n];
        for (int i = 0; i < n; i++) {
            rideList[i] = sc.nextInt();
        }
        int targetPremiums = sc.nextInt();
        
        System.out.println(countProfitableSegments(rideList, targetPremiums));
    }
}
