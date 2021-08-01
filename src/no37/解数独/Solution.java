package no37.解数独;

public class Solution {
    boolean[][] horizontal={
            {false,false,false,false,false,false,false,false,false,},
            {false,false,false,false,false,false,false,false,false,},
            {false,false,false,false,false,false,false,false,false,},
            {false,false,false,false,false,false,false,false,false,},
            {false,false,false,false,false,false,false,false,false,},
            {false,false,false,false,false,false,false,false,false,},
            {false,false,false,false,false,false,false,false,false,},
            {false,false,false,false,false,false,false,false,false,},
            {false,false,false,false,false,false,false,false,false,},
    },vertical={
            {false,false,false,false,false,false,false,false,false,},
            {false,false,false,false,false,false,false,false,false,},
            {false,false,false,false,false,false,false,false,false,},
            {false,false,false,false,false,false,false,false,false,},
            {false,false,false,false,false,false,false,false,false,},
            {false,false,false,false,false,false,false,false,false,},
            {false,false,false,false,false,false,false,false,false,},
            {false,false,false,false,false,false,false,false,false,},
            {false,false,false,false,false,false,false,false,false,},
    },square={
            {false,false,false,false,false,false,false,false,false,},
            {false,false,false,false,false,false,false,false,false,},
            {false,false,false,false,false,false,false,false,false,},
            {false,false,false,false,false,false,false,false,false,},
            {false,false,false,false,false,false,false,false,false,},
            {false,false,false,false,false,false,false,false,false,},
            {false,false,false,false,false,false,false,false,false,},
            {false,false,false,false,false,false,false,false,false,},
            {false,false,false,false,false,false,false,false,false,},
    };
    public void out(boolean[][] board){
        for(int i=0;i<9;i++){
            for(int j=0;j<9;j++){
                System.out.print(board[i][j]+"\t");
            }
            System.out.println();
        }System.out.println();
    }
    public void solveSudoku(char[][] board) {
        for(int i=0;i<9;i++){//初始化存储行、列、矩阵的三个二维数组
            for(int j=0;j<9;j++){
                if(board[i][j]!='.'){
                    horizontal[i][board[i][j]-49]=true;
                    square[i/3+j/3][board[i][j]-49]=true;
                }
                if(board[j][i]!='.'){
                    vertical[i][board[j][i]-49]=true;
                }
            }
        }
        out(horizontal);
        out(vertical);
        out(square);
    }
    public static void main(String[] args) {
        char[][] board={
                {'5','3','.','.','7','.','.','.','.'},
                {'6','.','.','1','9','5','.','.','.'},
                {'.','9','8','.','.','.','.','6','.'},
                {'8','.','.','.','6','.','.','.','3'},
                {'4','.','.','8','.','3','.','.','1'},
                {'7','.','.','.','2','.','.','.','6'},
                {'.','6','.','.','.','.','2','8','.'},
                {'.','.','.','4','1','9','.','.','5'},
                {'.','.','.','.','8','.','.','7','9'}
        };
        Solution solution = new Solution();
        solution.solveSudoku(board);
        for(char[] cArray:board){
            for(char c:cArray){
                System.out.print(c+"\t");
            }
            System.out.println();
        }
    }
}
