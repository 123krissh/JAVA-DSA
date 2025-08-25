public class matrixDiagonalTravrs {
    public static int[] findDiagonalOrder(int[][] mat) {
        if(mat == null || mat.length == 0) return new int[0];

        int m = mat.length;
        int n = mat[0].length;
        int[] result = new int[m*n];
        int row = 0;
        int col = 0;

        for(int i=0; i<m*n; i++){
            result[i] = mat[row][col];

            if((row+col)%2 == 0){
                if(col == n-1){
                    row++;
                }else if(row == 0){
                    col++;
                } else{
                    row--;
                    col++;
                }
            } else{
                if(row == m-1){
                    col++;
                } else if(col == 0){
                    row++;
                } else{
                    row++;
                    col--;
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[][] mat = {
            {1, 2, 3},
            {4, 5, 6},
            {7, 8, 9}
        };

        int[] res = findDiagonalOrder(mat);
        System.out.println("Diagonal Traversal Order: ");
        for (int i = 0; i < res.length; i++) {
            System.out.print(res[i] + " ");   
        }
    }
}
