import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeSet;

public class AvoidFlood {
    
    public static int[] avoidFlood(int[] rains) {
        Map<Integer, Integer> lakeMap = new HashMap<>();
        List<Integer> dryDays = new ArrayList<>();
        int[] ans = new int[rains.length];

        for(int i=0; i<rains.length; i++){
            int lake = rains[i];
            if(lake == 0){
                dryDays.add(i);
                ans[i] = 1;
            } else {
                if(lakeMap.containsKey(lake)){
                    int lstFilledLakeIdx = lakeMap.get(lake);
                    int idx = -1;

                    for(int j=0; j<dryDays.size(); j++){
                        if(dryDays.get(j) > lstFilledLakeIdx){
                            idx = dryDays.get(j);
                            dryDays.remove(j);
                            break;
                        }
                    }

                    if(idx == -1){
                        return new int[0];
                    }

                    ans[idx] = lake;
                }
                lakeMap.put(lake, i);
                ans[i] = -1;
            }
        }
        return ans;
    }

    // Optimal Approach using TreeSet or PriorityQueue

    public static int[] avoidFloodTreeSet(int[] rains) {
        Map<Integer, Integer> lakeMap = new HashMap<>();
        TreeSet<Integer> dryDays = new TreeSet<>();
        int[] ans = new int[rains.length];
        
        for(int i=0; i<rains.length; i++){
            int lake = rains[i];
            if(lake == 0){
                dryDays.add(i);
                ans[i] = 1;
            } else {
                if(lakeMap.containsKey(lake)){
                    int lstFilledLakeIdx = lakeMap.get(lake);
                    Integer idx = dryDays.higher(lstFilledLakeIdx);
                    if(idx == null) return new int[0];
                    else {
                        ans[idx] = lake;
                        dryDays.remove(idx);
                    }    
                }
                lakeMap.put(lake, i);
                ans[i] = -1;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] rains = {1,2,0,3,0,0,1,2};
        int[] result = avoidFlood(rains);

        for(int day : result){
            System.out.print(day + " ");
        }
        System.out.println();
    }
}
