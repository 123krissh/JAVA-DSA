import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class damage_minTime {
    // Find the Minimum Amount of Time to Brew Potions ---->
    public static long minTime(int[] skill, int[] mana) {
        int n = skill.length;
        int m = mana.length;
        long[] time = new long[n+1];

        for(int j=0; j<m; j++){
            for(int i=0; i<n; i++){
                time[i+1] = Math.max(time[i+1], time[i]) + (long)skill[i] * mana[j];
            }

            for(int i = n-1; i > 0; i--){
                time[i] = time[i+1] - (long)skill[i] * mana[j];
            }
        }
        return time[n];
    }

    // Maximum Total Damage With Spell Casting ---->
    private HashMap<Integer, Integer> freq = new HashMap<>();
    private List<Integer> values;
    private Long[] dp;
    public static long maximumTotalDamage(int[] power) {
        for(int p : power){
            freq.put(p, freq.getOrDefault(p,0) + 1);
        }
        values = new ArrayList<>(freq.keySet());
        Collections.sort(values);
        dp = new Long[values.size()];

        return helper(0);
    }

    private static long helper(int i){
        if(i >= values.size()) return 0;
        if(dp[i] != null) return dp[i];

        long pick = (long) values.get(i) * freq.get(values.get(i));
        int index = getIndex(values.get(i) + 2);
        pick += helper(index);

        long skip = helper(i+1);
        dp[i] = Math.max(pick, skip);
        return dp[i];
    }

    private static int getIndex(int target){
        int l = 0, r = values.size();
        while(l < r){
            int mid = (l+r)/2;
            if(values.get(mid) <= target) l = mid + 1;
            else r = mid;
        }
        return l;
    }

    public static void main(String[] args) {
        int[] skill = {1,5,2,4}, mana = {5,1,4,2};
        System.out.println(minTime(skill, mana));

        int[] power = {2,2,3,3,3,4};
        System.out.println(maximumTotalDamage(power));
    }
}
