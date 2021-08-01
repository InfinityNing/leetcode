package no36.有效的数独;

import java.util.HashMap;
//这题真尼玛毫无技术含量，四层循环我都傻了
public class Solution {
    public boolean isValidSudoku(char[][] board) {
        HashMap hMap,vMap,sMap;
        for(int i=0;i<9;i++){//检查行列是否有重复
            hMap=new HashMap();vMap=new HashMap();
            for(int j=0;j<9;j++){
                if(board[i][j]!='.'){//检查行是否有重复
                    if(hMap.containsKey(board[i][j]))
                        return false;
                    else hMap.put(board[i][j],1);
                }
                if(board[j][i]!='.'){//检查列是否有重复
                    if(vMap.containsKey(board[j][i]))
                        return false;
                    else vMap.put(board[j][i],1);
                }
            }
        }
        for(int i=0;i<9;i+=3){
            for(int j=0;j<9;j+=3){
                sMap=new HashMap();
                for(int k=0;k<3;k++){
                    for(int l=0;l<3;l++){
                        if(board[i+k][j+l]!='.'){
                            if(sMap.containsKey(board[i+k][j+l]))
                                return false;
                            else sMap.put(board[i+k][j+l],1);
                        }
                    }
                }
            }
        }
        return true;
    }
    public static void main(String[] args) {
        char[][] b1={
                {'5','3','.','.','7','.','.','.','.'},
                {'6','.','.','1','9','5','.','.','.'},
                {'.','9','8','.','.','.','.','6','.'},
                {'8','.','.','.','6','.','.','.','3'},
                {'4','.','.','8','.','3','.','.','1'},
                {'7','.','.','.','2','.','.','.','6'},
                {'.','6','.','.','.','.','2','8','.'},
                {'.','.','.','4','1','9','.','.','5'},
                {'.','.','.','.','8','.','.','7','9'}
        },b2={
                {'8','3','.','.','7','.','.','.','.'},
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
        System.out.println(solution.isValidSudoku(b1));
        System.out.println(solution.isValidSudoku(b2));
    }
}


