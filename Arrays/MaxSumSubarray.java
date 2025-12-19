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


    // -----More Optimized approach of maxSubarraySum : Kadane's Algorithm ------- if all the elements are negative then it not work properly
    // This algorithm finds the maximum sum of a contiguous subarray in an array of integers.

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

    // count subarrays with product less than k
    public static int countSubarrayProd(int[] numbers, int k){
        if (k <= 1) return 0;

        int left = 0;
        long product = 1;
        int count = 0;

        for (int right = 0; right < numbers.length; right++) {
            product *= numbers[right];
    
            while (product >= k) {
                product /= nums[left];
                left++;
            }

            count += (right - left + 1);
        }

       return count;
    }

    // maximum product subarray
    public static int maxProduct(int[] numbers) {
        int maxProd = Integer.MIN_VALUE;
        int preProd = 1, suffProd = 1;
        int n = numbers.length;

        for(int i=0; i<n; i++) {
            if(preProd == 0) {
                preProd = 1;
            }
            if(suffProd == 0) {
                suffProd = 1;
            }
            preProd *= numbers[i];
            suffProd *= numbers[n-i-1];

            maxProd = Math.max(maxProd, Math.max(preProd, suffProd));
        }
        
        return maxProd;

        // int maxProd = Integer.MIN_VALUE;
        // for(int i=0; i<nums.length; i++) {
        //     int product = 1;
        //     for(int j=i; j<nums.length; j++) {
        //         product *= nums[j];
        //         maxProd = Math.max(maxProd, product);
        //     }
        // }
        // return maxProd;

        // int ms = Integer.MIN_VALUE;
        // int cp = 1;
        // for(int i=0; i<nums.length; i++){
        //     cp = cp * nums[i];
        //     if (cp == 0) {
        //         cp = 1;
        //     }
        //     ms = Math.max(cp, ms);
        // }
        // return ms;
    }

    
    public static void main(String[] args) {
        int numbers[] = {1, -2, 6, -1, 3};

        maxSubarraySum(numbers);
        Kadanes(numbers);
        countSubarrayProd(numbers, 50);
        maxProduct(numbers);
    }
}
