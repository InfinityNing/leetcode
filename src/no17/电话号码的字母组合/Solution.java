package no17.电话号码的字母组合;
import java.util.*;

//就是递归，也可以使用动态规划
public class Solution {
    public char[][] button={
            {'a', 'b', 'c'},{'d', 'e', 'f'},{'g', 'h', 'i'}, {'j', 'k', 'l'},
            {'m', 'n', 'o'},{'p', 'q', 'r', 's'}, {'t', 'u', 'v'},{'w', 'x', 'y', 'z'}
    };
    ArrayList<String> result=new ArrayList();
    String digits;
    public void lc(int loc,String each){
        char[] temp=button[digits.charAt(loc)-50];
        for(int i=0;i<temp.length;i++){//位置信息若已经走到最后就初始化开始新一轮循环
            if(loc==digits.length()-1)//最后一个
                result.add(each+temp[i]);
            else//不是最后一个
                lc(loc+1,each+temp[i]);
        }
    }
    public List<String> letterCombinations(String digits) {
        if(digits.length()==0) return result;
        this.digits=digits;
        lc(0,"");
        return result;
    }
    public static void main(String[] args) {
        Solution solution = new Solution();
        String digits="25634";
        System.out.println(solution.letterCombinations(digits));
    }
}


