package no6.Z字形变换;
/*
LEETCODEISHIRING               LEET
                                 C
竖着一列一列遍历                   O
                               DEIS
                                 H
                                I
                               RING
*/
public class Solution {
    public String convert(String s, int numRows) {
        String result="";
        int tempIndex;
        char temp;
        for(int i=0;i<numRows;i++){
            //System.out.println("第"+i+"排");
            if(numRows==1) return result=s;//行数为1直接返回
            for(int j=0;j<=s.length()/(2*numRows-2)+1;j++){
                tempIndex=j*(2*numRows-2)-i%numRows;
                result=i%(numRows-1)!=0&&tempIndex>0&&tempIndex<s.length()//不是长横线上的元素
                        ? result.concat(String.valueOf(s.charAt(tempIndex)))
                        : result;
                //System.out.println("==="+result);
                if(j*(2*numRows-2)+i<s.length()){//长横线上的元素
                    temp=s.charAt(j*(2*numRows-2)+i);
                    result=result.concat(String.valueOf(temp));
                    //System.out.println(temp);
                }
            }
        }
        return result;
    }
    public static void main(String[] args) {
        Solution solution = new Solution();
        String s="PAYPALISHIRING";
        int numRows=10;
        System.out.println(solution.convert(s,numRows));
    }
}
