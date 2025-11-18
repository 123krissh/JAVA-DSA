import java.util.HashMap;

public class Questions {
    
    // 219. Contains Duplicate II
    public static boolean containsNearbyDuplicate(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i=0; i<nums.length; i++) {
            if(map.containsKey(nums[i])){
                int value = map.get(nums[i]);
                if(Math.abs(i - value) <= k){
                    return true;
                }
            }
            map.put(nums[i], i);
        }
        return false;
    }

    // 1021. Remove Outermost Parentheses
    public static String removeOuterParentheses(String s) {
        StringBuilder sb = new StringBuilder();
        int count = 0;
        for(char c : s.toCharArray()){
            if(c == ')') count--;
            if(count != 0) sb.append(c);
            if(c == '(') count++;
        }
        return sb.toString();
    }

    // 3234. Count the Number of Substrings With Dominant Ones
    // Brute Force Approach O(n^3)
    public static int numberOfSubstrings(String s) {
        char[] c = s.toCharArray();
        int ans = 0;
        for(int i=0; i<c.length; i++){
            for(int j=i; j<c.length; j++){
                int countOne = 0, countZero = 0;
                for(int k=i; k<=j; k++){
                    if(c[k] == '0') countZero += 1;
                    if(c[k] == '1') countOne += 1;
                }
                if(Math.pow(countZero, 2) <= countOne){
                    ans++;
                }
            }
        }
        return ans;
    }
    // optimized approach O(n^2)
    public static int numberOfSubstringsOptimized(String s) {
        char[] c = s.toCharArray();
        int ans = 0;
        for(int i=0; i<c.length; i++){
            int countOne = 0, countZero = 0;
            for(int j=i; j<c.length; j++){
                if(c[j] == '0') countZero += 1;
                if(c[j] == '1') countOne += 1;
                if(Math.pow(countZero, 2) <= countOne){
                    ans++;
                }
            }
        }
        return ans;
    }
    // O(n*sqrt(n))
    public static int numberOfSubstringsO(String s) {
        int n = s.length();
        int[] pre = new int[n+1];
        pre[0] = -1;
        for(int i=0; i<n; i++) {
            if(i == 0 || (i > 0 && s.charAt(i-1) == '0')) {
                pre[i+1] = i;
            } else {
                pre[i+1] = pre[i];
            }
        }
        int ans = 0;
        for(int r=1; r<=n; r++){
            int zero = s.charAt(r-1) == '0' ? 1 : 0;
            int l = r;
            while(l > 0 && zero*zero <= n) {
                int one = (r - pre[l]) - zero;
                if(zero * zero <= one){
                    ans += Math.min(l - pre[l], one - zero * zero + 1);
                }
                l = pre[l];
                zero++;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3,1};
        int k = 3;
        System.out.println(containsNearbyDuplicate(nums, k));

        String s = "(()())(())";
        System.out.println(removeOuterParentheses(s));

        String str = "00011";
        System.out.println(numberOfSubstrings(str));
        System.out.println(numberOfSubstringsOptimized(str));
        System.out.println(numberOfSubstringsO(str));
    }
}
