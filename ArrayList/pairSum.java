import java.util.ArrayList;
public class pairSum {
    
    public static boolean pairSum(ArrayList<Integer> arr, int targetSum) {
        int lp = 0;
        int rp = arr.size() - 1;

        while (lp != rp) {
            if (arr.get(lp) + arr.get(rp) == targetSum) {
                return true;
            }
            if (arr.get(lp) + arr.get(rp) < targetSum) {
                lp++;
            }
            if (arr.get(lp) + arr.get(rp) > targetSum) {
                rp--;
            }
        }
        return false;
    }

    public static boolean pairSum2(ArrayList<Integer> list, int target) {
        int bp = -1;
        for(int i=0; i<list.size(); i++) {
            if (list.get(i) > list.get(i+1)) {
                bp = i;
                break;
            }
        }
        if (bp == -1) {
            return pairSum(list, target); // If the array is not rotated, use the first method
        }

        int lp = bp + 1;
        int rp = bp;
        int n = list.size();

        while (lp != rp) {
            if (list.get(lp) + list.get(rp) == target) {
                return true;
            }
            if (list.get(lp) + list.get(rp) < target) {
                lp = (lp + 1) % n;
            }
            if (list.get(lp) + list.get(rp) > target) {
                rp = (rp - 1 + n) % n;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        ArrayList<Integer> arr = new ArrayList<>();
        arr.add(1);
        arr.add(2);
        arr.add(3);
        arr.add(4);
        arr.add(5);
        arr.add(6);

        int targetSum = 6;

        System.out.println("Pairs with sum " + targetSum + ":");
        if (pairSum(arr, targetSum)) {
            System.out.println("Yes, there exists a pair with the given sum.");
        } else {
            System.out.println("No, there is no pair with the given sum.");
        }
        
        for (int i = 0; i < arr.size(); i++) {
            for (int j = i + 1; j < arr.size(); j++) {
                if (arr.get(i) + arr.get(j) == targetSum) {
                    System.out.println("(" + arr.get(i) + ", " + arr.get(j) + ")");
                }
            }
        }

        // [11,15,6,8,9,10] -> sorted & rotated list pairSum 2
        ArrayList<Integer> list = new ArrayList<>();
        list.add(11);
        list.add(15);
        list.add(6);
        list.add(8);
        list.add(9);
        list.add(10);
        int target = 16;
        System.out.println("Pair Sum 2: " + pairSum2(list, target));
    } 
}
