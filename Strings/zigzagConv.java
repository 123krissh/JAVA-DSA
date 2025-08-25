public class zigzagConv {
    public static String zigzagConvert(String s, int numRows) {
        if(numRows == 1) return s;
        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < numRows; i++){
            int idx = i;
            int down = 2*(numRows - 1 - i);
            int upper = 2*i;
            Boolean goingDown = true;

            while(idx < s.length()){
                sb.append(s.charAt(idx));

                if(i == 0){
                    idx += down;
                } else if(i == numRows - 1){
                    idx += upper;
                } else{
                    if(goingDown){
                        idx += down;
                    } else{
                        idx += upper;
                    }
                    goingDown = !goingDown;
                }
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        String s = "PAYPALISHIRING"; 
        int numRows = 3;

        String res = zigzagConvert(s, numRows);
        System.out.println("String after zigzag conversion: " + res);
    }
}
