public class sudokuSolver {

    public static boolean isSafe(int sudoku[][], int row, int col, int digit) {
        // column
        for(int i=0; i<=8; i++) {
            if(sudoku[i][col] == digit){
                return false;
            }
        }

        // Row
        for (int j = 0; j <= 8; j++) {
            if(sudoku[row][j] == digit){
                return false;
            }
        }

        // grid
        int sr = (row/3)*3;
        int sc = (col/3)*3;

        for (int i = sr; i < sr+3; i++) {
            for (int j = sc; j < sc+3; j++) {
                if(sudoku[i][j] == digit) {
                    return false;
                }
            }
        }
        return true;
    }

    public static boolean sudokuSolver(int sudoku[][], int row, int col) {
        // base case
        if(row == 9) {
            return true;
        }
        // recursion
        int nextRow = row;
        int nextCol = col+1;
        if(col + 1 == 9) {
            nextRow = row+1;
            nextCol = 0;
        }

        if(sudoku[row][col] != 0){
            return sudokuSolver(sudoku, nextRow, nextCol);
        }

        for (int digit = 1; digit<=9; digit++) {
            if(isSafe(sudoku, row, col, digit)){
                sudoku[row][col] = digit;
                if(sudokuSolver(sudoku, nextRow, nextCol)) {
                    return true;
                }
                sudoku[row][col] = 0;
            }
        }
        return false;
    }

    public static void printSudoku(int sudoku[][]) {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                System.out.print(sudoku[i][j]+" ");
            }
            System.out.println();
        }
    }
    
    public static void main(String[] args) {
        int sudoku[][] = {
    {5, 3, 0, 0, 7, 0, 0, 0, 0},
    {6, 0, 0, 1, 9, 5, 0, 0, 0},
    {0, 9, 8, 0, 0, 0, 0, 6, 0},
    {8, 0, 0, 0, 6, 0, 0, 0, 3},
    {4, 0, 0, 8, 0, 3, 0, 0, 1},
    {7, 0, 0, 0, 2, 0, 0, 0, 6},
    {0, 6, 0, 0, 0, 0, 2, 8, 0},
    {0, 0, 0, 4, 1, 9, 0, 0, 5},
    {0, 0, 0, 0, 8, 0, 0, 7, 9} };

        if(sudokuSolver(sudoku, 0, 0)) {
            System.out.println("Solution Exists");
            printSudoku(sudoku);
        } else {
            System.out.println("Solution dose not exist");
        }
    }

    // leetcode ----->
    public boolean isValidSudoku(char[][] board) {
        boolean[][] rows = new boolean[9][9];  
        boolean[][] cols = new boolean[9][9];   
        boolean[][] boxes = new boolean[9][9];

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                char c = board[i][j];
                if (c != '.') {
                    int num = c - '1'; 
                    int boxIndex = (i / 3) * 3 + (j / 3); 

                    if (rows[i][num] || cols[j][num] || boxes[boxIndex][num]) {
                        return false;
                    }
                    rows[i][num] = true;
                    cols[j][num] = true;
                    boxes[boxIndex][num] = true;
                }
            }
        }

    return true;

    // HashSet<String> seen = new HashSet<>();
    // for (int i = 0; i < 9; i++) {
    //     for (int j = 0; j < 9; j++) {
    //         char num = board[i][j];
    //         if (num != '.') {
    //             String rowKey = num + " in row " + i;
    //             String colKey = num + " in col " + j;
    //             String boxKey = num + " in box " + (i / 3) + "-" + (j / 3);

    //             if (!seen.add(rowKey) || !seen.add(colKey) || !seen.add(boxKey)) {
    //                 return false;
    //             }
    //         }
    //     }
    // }
    // return true;
    }
}
