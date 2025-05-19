public class TrappingRainWater {
    public static int trap(int[] height) {
        int n = height.length;
        int leftMax[] = new int [n];
        leftMax[0] = height[0];
        for(int i=1; i<n; i++){
            leftMax[i] = Math.max(height[i], leftMax[i-1]);
        }

        int rightMax[] = new int [n];
        rightMax[n-1] = height[n-1];
        for(int i=n-2; i>=0; i--) {
            rightMax[i] = Math.max(height[i], rightMax[i+1]);
        }

        int trap = 0;

        for(int i=0; i<n; i++){
            int waterLevel = Math.min(leftMax[i], rightMax[i]);
            trap += waterLevel - height[i];
        }

        return trap;
    }

     public static void main(String args[]) {
        int height[] = {7, 1, 6, 9, 3, 0};

        System.out.println("Trapped Rain Water is: " + trap(height));
    }
}
