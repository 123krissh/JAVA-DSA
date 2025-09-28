import java.util.Arrays;

public class geometry {
    
    // maximum triangle area
    public static double largestTriangleArea(int[][] points) {
        double maxArea = 0;
        for(int i=0; i<points.length; i++){
            for(int j=i+1; j<points.length; j++){
                for(int k=j+1; k<points.length; k++){
                    int x1 = points[i][0];
                    int x2 = points[j][0];
                    int x3 = points[k][0];
                    int y1 = points[i][1];
                    int y2 = points[j][1];
                    int y3 = points[k][1];

                    double area = (x1*(y2 - y3)) + (x2*(y3 - y1)) + (x3*(y1 - y2));
                    area = Math.abs(area/2);
                    if(area >= maxArea){
                        maxArea = area;
                    }
                }
            }
        }
        return maxArea;
    }

    // valid triangle number
    public static int triangleNumber(int[] nums) {
        Arrays.sort(nums);
        int count = 0;

        for(int k = nums.length-1; k>=2; k--){
            int largestLength = nums[k];
            int L = 0;
            int R = k-1;

            while(L < R){
                if(nums[L] + nums[R] > largestLength){
                    count += R-L;
                    R--;
                } else {
                    L++;
                }
            }
        }
        return count;
    }

    // Maximum perimeter of triangle
    public static int MaxPerimeter(int[] nums){
        Arrays.sort(nums);
        for(int k = nums.length-1; k>=2; k--){
            if(nums[k-1] + nums[k-2] > nums[k]) {
                return nums[k-1] + nums[k-2] + nums[k];
            }
        }
        return 0;
    }

    // Polygon with largest perimeter
    public static long largestPerimeter(int[] nums) {
        Arrays.sort(nums);
        long totalSum = 0;
        for (int num : nums) {
            totalSum += num;
        }
        for (int k = nums.length - 1; k >= 2; k--) {
            long largestSide = nums[k];
            long sumOthers = totalSum - largestSide;

            if (sumOthers > largestSide) {
                return sumOthers + largestSide; 
            }
            totalSum = sumOthers;
        }
        return -1;

        // OR---->
        // long perimeter = 0;
        // Arrays.sort(nums);
        // for(int k=nums.length-1; k>=2; k--){
        //     long largestSide = nums[k];
        //     long sum = 0;
        //     for(int i=0; i<k; i++){
        //         sum += nums[i];
        //     }
        //     if(sum > largestSide){
        //         perimeter = sum + largestSide;
        //         return perimeter;
        //     }
        // }
        // return -1;
    }

    public static void main(String[] args) {
        int[][] points = {{0,0},{0,1},{1,0},{0,2},{2,0}};
        System.out.println(largestTriangleArea(points));

        int[] nums = {4,2,3,4};
        System.out.println(triangleNumber(nums));
        System.out.println(largestPerimeter(nums));
        System.out.println(MaxPerimeter(nums));
    }
}
