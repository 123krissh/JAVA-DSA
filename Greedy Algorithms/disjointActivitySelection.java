import java.util.*;

public class disjointActivitySelection {
     
    public static int activitySelection(int[] start, int[] end){
        // sorting
        int activities[][] = new int[start.length][3];
        for(int i=0; i<start.length; i++){
            activities[i][0] = i;
            activities[i][1] = start[i];
            activities[i][2] = end[i];
        }
        // lambda function -> short form of comparator interface for soring java objects
        Arrays.sort(activities, Comparator.comparingDouble(o -> o[2]));
        
        // end time should be sorted
        int maxAct = 0;
        ArrayList<Integer> ans = new ArrayList<>();
        
        // 1st activity
        maxAct = 1;
        ans.add(activities[0][0]);
        int lastEnd = activities[0][2];
        for(int i=1; i<start.length; i++){
            if(activities[i][1] >= lastEnd){
                maxAct++;
                ans.add(activities[i][0]);
                lastEnd = activities[i][2];
            }
        }

        System.out.println("max activities: " + maxAct);
        for(int i=0; i<ans.size(); i++){
            System.out.print("A" + ans.get(i) + ", ");
        }
        System.out.println();
        
        return maxAct;
    }

    // Minimum absolute difference --> O(nlogn)
    public static void minAbsoluteDiff(int[] start, int[] end) {
        Arrays.sort(start);
        Arrays.sort(end);
        int minDiff = 0;

        for (int i = 0; i < end.length; i++) {
            minDiff += Math.abs(start[i] - end[i]);
        }

        System.out.println("Minimum absolute difference: " + minDiff);
    }
    // Leetcode 1200
    public List<List<Integer>> minimumAbsDifference() {
        int[] arr = {4,2,3,1};
        Arrays.sort(arr);
        ArrayList<List<Integer>> result = new ArrayList<>();
        int minDiff = Integer.MAX_VALUE;

        for (int i = 1; i < arr.length; i++) {
            minDiff = Math.min(minDiff, arr[i] - arr[i - 1]);
        }

        for (int i = 1; i < arr.length; i++) {
            if (arr[i] - arr[i - 1] == minDiff) {
                result.add(Arrays.asList(arr[i - 1], arr[i]));
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] start = {1,3,0,5,8,5};
        int[] end = {2,4,6,7,9,9};

        // if end time is sorted -->
        int maxAct = 0;
        ArrayList<Integer> ans = new ArrayList<>();
        
        // 1st activity
        maxAct = 1;
        ans.add(0);
        int lastEnd = end[0];
        for(int i=1; i<start.length; i++){
            if(start[i] >= lastEnd){
                maxAct++;
                ans.add(i);
                lastEnd = end[i];
            }
        }

        System.out.println("max activities: " + maxAct);
        for(int i=0; i<ans.size(); i++){
            System.out.print("A" + ans.get(i) + ", ");
        }
        System.out.println();
        
        // if end time is not sorted -->
        activitySelection(start, end);

        // Minimum absolute difference -->
        minAbsoluteDiff(start, end);
    }
}
