public class kokoQ {
    public int minEatingSpeed(int[] piles, int h) {
        int L = 1;
        int H = findMax(piles);

        while (L <= H) {
            int mid = L + (H - L) / 2;
            int totalH = calTotalH(piles, mid);

            if (totalH <= h) {
                H = mid - 1;
            } else {
                L = mid + 1;
            }
        }
        return L;
    }

    public int findMax(int[] piles) {
        int maxEle = 0;
        for (int i=0; i<piles.length; i++) {
            maxEle = Math.max(maxEle, piles[i]);
        }
        return maxEle;
    }

    public int calTotalH(int[] piles, int k) {
        long totalH = 0;
        for (int i=0; i<piles.length; i++) {
            totalH += (piles[i] + k - 1) / k; // ceil value(pile / k)
        }
        return totalH > Integer.MAX_VALUE ? Integer.MAX_VALUE : (int)totalH;
    }

    public static void main(String[] args) {
        kokoQ solution = new kokoQ();
        int[] piles = {805306368,805306368,805306368};
        int h = 1000000000;
        int result = solution.minEatingSpeed(piles, h);
        System.out.println("Minimum eating speed: " + result);
    }
}
