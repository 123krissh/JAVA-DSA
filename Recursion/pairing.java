public class pairing {
    
    public static int pairFriends(int n) {
        // Base case
        if(n == 1 || n == 2){
            return n;
        }
        // Recursive case choice
        // single
        int fnm1 = pairFriends(n-1);
        // pair
        int fnm2 = pairFriends(n-1);
        int pairWays = (n-1) * fnm2;

        return fnm1 + pairWays;
        // or alternatively we can write it as:
        // return pairFriends(n-1) + (n-1) * pairFriends(n-2);
    }

    public static void main(String[] args) {
        System.out.println("Number of ways to pair with friends: " + pairFriends(4));
    }
}
