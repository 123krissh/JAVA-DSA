public class AliceBobFlowerGame {

    public static long flowerGame(int n, int m) {
        // Brute force approch O(nm) ---->

        // long result = 0;
        // for(int i=1; i<=n; i++){
        //     for(int j=1; j<=m; j++){
        //         if((i+j)%2 != 0){
        //             result++;
        //         }
        //     }
        // }
        // return result;

        // optimized approch O(1)---->
        return ((n+1)/2) * (long)(m/2) + ((m+1)/2) * (long)(n/2);
    }

    public static void main(String[] args) {
        System.out.println(flowerGame(2,3));
    }
}
