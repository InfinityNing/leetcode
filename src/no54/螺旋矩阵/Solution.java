package no54.螺旋矩阵;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    int[][] status;
    int x=0,y=0;
    int direction=0;
    public boolean changeDirection(){
        direction=(direction+1)%4;
        switch(direction){
            case 0:
                return status[x][y-1]==0;
            case 1:
                return status[x+1][y]==0;
            case 2:
                return status[x][y+1]==0;
            case 3:
                return status[x-1][y]==0;
        }
        return true;
    }
    public boolean getNext(){
        int tx=x,ty=y;
        switch(direction){
            case 0:
                ty--;break;
            case 1:
                tx++;break;
            case 2:
                ty++;break;
            case 3:
                tx--;break;
        }
        if(tx<0||tx>=status.length||ty<0||ty>=status[0].length||status[tx][ty]==1){
            if(!changeDirection()){
                return false;
            }
            tx=x;
            ty=y;
        }
        x=tx;y=ty;
        return true;
    }
    public List<Integer> spiralOrder(int[][] matrix) {
        status=new int[matrix.length][matrix[0].length];
        ArrayList list=new ArrayList();
        do{
            list.add(matrix[x][y]);
        }while(getNext());
        return list;
    }

    public static void main(String[] args) {

    }
}
