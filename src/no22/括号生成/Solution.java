package no22.括号生成;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    int pairs;//栈中左括号的数量
    ArrayList<String> result=new ArrayList<>();
    public void gp(boolean isLeft,String s,int left,int right){
        if(isLeft){//左括号，左括号数量加一
            left++;
            s+=String.valueOf('(');
        } else {//右括号，右括号数量加一
            right++;
            s+=String.valueOf(')');
        }
        if(s.length()==pairs*2) result.add(s);//递归出口，写入list
        if(left<pairs) gp(true,s,left,right);
        if(left!=right) gp(false,s,left,right);
    }
    public List<String> generateParenthesis(int n) {
        pairs=n;
        gp(true,"",0,0);
        return result;
    }
    public static void main(String[] args) {
        Solution solution = new Solution();
        int i=4;//生成的括号对数
        System.out.println(solution.generateParenthesis(i));
    }
}


