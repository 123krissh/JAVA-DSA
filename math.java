public class math {
    public int[] getNoZeroIntegers(int n) {
        int A = 1, B = 1;
        for(int i=1; i<=n; i++){
            A = i;
            B = n-i;
            if(!isZero(A) && !isZero(B) && A + B == n){
                return new int[]{A,B};
            } 
        }
        return new int[]{};
    }

    public boolean isZero(int A){
        if(A==0) return true;
        while(A>0){
            if(A % 10 == 0) return true;
            A /= 10;
        }
        return false;
    }

    public int[] sumZero(int n) {
        int[] result = new int[n];
        int idx = 0;
        if(n%2 != 0){
            result[idx++] = 0;
        }
        for(int i=1; i<=n/2; i++){
            result[idx++] = i;
            result[idx++] = -i;
        }
        return result;
    }
}
