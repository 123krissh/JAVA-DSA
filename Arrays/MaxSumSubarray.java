public class MaxSumSubarray {
    
    public static void maxSubarraySum(int numbers[]){
        int currSum = 0;
        int maxSum = Integer.MIN_VALUE;
        
        //----- basic approach -------

        for(int i=0; i<numbers.length; i++){
            int start = i;
            for(int j=i; j<numbers.length; j++){
                int end = j;
                currSum = 0;
                for(int k=start; k<=end; k++){
                    // print subarray
                    System.out.print(numbers[k]+" ");
                    // Subarray Sum
                    currSum += numbers[k];
                }
                System.out.println();
                System.out.println("sum: "+ currSum);
                if (maxSum < currSum) {
                    maxSum = currSum;
                }
            }
            System.out.println();
        }
        System.out.println("maximum sum of subarray: "+ maxSum);

        // ----- Optimized approach of maxSubarraySum -------

        int prefix[] = new int [numbers.length];
        prefix[0] = numbers[0];
        // calculate prefix array
        for(int i=1; i<prefix.length; i++){
            prefix[i] = prefix[i-1] + numbers[i];
        }

        for(int i=0; i<numbers.length; i++){
            int start = i;
            for(int j=i; j<numbers.length; j++){
                int end = j;
                currSum = start == 0 ? prefix[end] : prefix[end] - prefix[start-1];  
                // System.out.println(currSum);
                if (maxSum < currSum) {
                    maxSum = currSum;
                }
            }
        }
        System.out.println("maximum sum of subarray: "+ maxSum);
    }


    // -----More Optimized approach of maxSubarraySum : Kadane's Algorithm -------

    public static void Kadanes(int numbers[]){
        int ms = Integer.MIN_VALUE;
        int cs = 0;

        for(int i=0; i<numbers.length; i++){
            cs = cs + numbers[i];
            // System.out.println(cs);
            if (cs < 0) {
                cs = 0;
            }
            ms = Math.max(cs, ms);
        }
        System.out.println("max sum of subarray: "+ ms);
    }

    
    public static void main(String[] args) {
        int numbers[] = {1, -2, 6, -1, 3};

        maxSubarraySum(numbers);
        Kadanes(numbers);
    }
}
