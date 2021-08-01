package no32.最长有效括号;

import java.util.Stack;
//思想是在使用栈的同时用等长数组存储所有括号，配对成功的就变成*，
//最后从头扫描，遇到不是*的，停止自增从0重新开始计算，最后取最大值返回
public class Solution {
    public void changeParentheses(char[] cc,int index){
        cc[index]='*';
        while(cc[index]!='('){
            index--;
        }
        cc[index]='*';
    }
    public int longestValidParentheses(String s) {
        int maxValid=0,temp=0;
        char[] cc=new char[s.length()];
        for(int i=0;i<s.length();i++){
            cc[i]=s.charAt(i);
        }
        Stack<Character> st=new Stack<>();
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='(') {//左括号
                st.push(s.charAt(i));
            }else{//右括号
                if(!st.isEmpty()) {//有可供抵消的左括号
                    st.pop();
                    changeParentheses(cc,i);
                }
            }
        }
        for(char c:cc){
            System.out.print(c+"\t");
            if(c!='*'){
                maxValid=temp>maxValid?temp:maxValid;
                temp=0;
            }else
                temp++;
        }
        maxValid=temp>maxValid?temp:maxValid;
        System.out.println();
        return maxValid;
    }
    public static void main(String[] args) {
        Solution solution = new Solution();
        String s="()(()";
        System.out.println(solution.longestValidParentheses(s));
    }
}


