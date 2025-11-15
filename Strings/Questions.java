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

    public static void main(String[] args) {
        int[] nums = {1,2,3,1};
        int k = 3;
        System.out.println(containsNearbyDuplicate(nums, k));

        String s = "(()())(())";
        System.out.println(removeOuterParentheses(s));

        String str = "11001011";
        System.out.println(numberOfSubstrings(str));
    }
}
