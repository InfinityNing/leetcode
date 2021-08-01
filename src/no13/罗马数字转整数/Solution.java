package no13.罗马数字转整数;
//题目输入数字小于4000
public class Solution {
    char list[][]={
            {'I','V'},{'X','L'},{'C','D'},{'M','&'},{'&','&'}
    };
    public int[] find(char num){//根据list返回数字和指数
        int result[]=new int[2];
        for(int i=0;i<4;i++){
            for(int j=0;j<2;j++){
                if(list[i][j]==num) {
                    result[0]=j==0?1:5;//数字
                    result[1]=i;        //指数
                    return result;
                }
            }
        }
        return null;
    }
    public int romanToInt(String s) {
        int result=0;
        int temp[];
        for(int i=0;i<s.length();i++){
            temp=find(s.charAt(i));
            if(temp[0]==1){//扫描到I/X/C/M
                if(i+1<s.length()){
                    if(list[temp[1]][1]==s.charAt(i+1)){//下一个为5
                        result+=4*Math.pow(10,temp[1]);i++;continue;
                    }
                    if(list[temp[1]+1][0]==s.charAt(i+1)){//下一个为10
                        result+=9*Math.pow(10,temp[1]);i++;continue;
                    }
                }
            }
            result+=temp[0]*Math.pow(10,temp[1]);
        }
        return result;
    }
    public static void main(String[] args) {
        Solution solution = new Solution();
        String s="MCMXCIV";
        System.out.println(solution.romanToInt(s));
    }
}

