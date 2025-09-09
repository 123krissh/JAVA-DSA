public class secret {

    public static int peopleAwareOfSecret(int n, int delay, int forget) {
        long mod = 1000000007;
        long[] dp = new long[n+1];
        dp[1] = 1;

        for(int day=1; day<=n; day++){
            long person = dp[day];

            if(person == 0) continue;

            int start = day + delay;
            int end = day + forget - 1;

            for(int i=start; i<=end && i<=n; i++){
                dp[i] = (dp[i] + person) % mod;
            }
        }
        long result = 0;
        for(int day = n - forget + 1; day<=n; day++){
            if(day >= 1){
                result = (result + dp[day]) % mod;
            }
        }
        return (int) result;
    }

    public static void main(String[] args) {
        int n=6, delay=2, forget=4;
        System.out.println(peopleAwareOfSecret(n, delay, forget));
    }
}
