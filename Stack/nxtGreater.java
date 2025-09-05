import java.util.HashMap;
import java.util.Stack;

public class nxtGreater {

    public static int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Stack<Integer> s = new Stack<>();
        int nxtGreater[] = new int[nums2.length];
        int nxtGreater1[] = new int[nums1.length];

        for(int i=nums2.length-1; i>=0; i--){
            while(!s.isEmpty() && s.peek() <= nums2[i]){
                s.pop();
            }
            if(s.isEmpty()){
                nxtGreater[i] = -1;
            } else {
                nxtGreater[i] = s.peek();
            }
            s.push(nums2[i]);
        }

        // for(int i=0; i<nums1.length; i++){
        //     for(int j=0; j<nums2.length; j++){
        //         if(nums1[i] == nums2[j]){
        //             nxtGreater1[i] = nxtGreater[j];
        //         }
        //     }
        // }

        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums2.length; i++) {
            map.put(nums2[i], nxtGreater[i]);
            }
        for (int i = 0; i < nums1.length; i++) {
            nxtGreater1[i] = map.get(nums1[i]);
        }
        return nxtGreater1;
    }

    // Optimized approch:---->
    public static int[] nextGreaterElement1(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int m = nums2.length;
        int[] ans = new int[n];

        for (int i = 0; i < n; i++) {
            int key = -1;
            for (int j = 0; j < m; j++) {
                if (nums1[i] == nums2[j]) {
                    key = j;
                    break;
                }
            }
            int greater = -1;
            for (int j = key+1; j < m; j++) {
                if (nums2[j] > nums2[key]){
                    greater = nums2[j];
                    break;
                }
            }
            ans[i] = greater;
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] nums1 = {4, 1, 2};
        int[] nums2 = {1, 3, 4, 2};
        int[] result = nextGreaterElement(nums1, nums2);
        for (int i : result) {
            System.out.print(i + " ");
        }
    }
}
