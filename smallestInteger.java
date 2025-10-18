public class smallestInteger {

    public static int findSmallestInteger(int[] nums, int value) {
        int[] cnt = new int[value];

        for (int n : nums){
            int remainder = ((n % value) + value) % value;
            cnt[remainder]++;
        }

        int mex = 0;
        while (true){
            int r = mex % value;
            if (cnt[r] > 0) {
                cnt[r]--;
                mex++;
            }else {
                return mex;
            }
        }
    }

    public static void main(String[] args) {
        int[] nums = {1, -10, 7, 13, 6, 8};
        int value = 5;
        System.out.println(findSmallestInteger(nums, value));
    }
}    