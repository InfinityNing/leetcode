package no20.有效的括号;

import java.util.Stack;

public class Solution {
    public boolean isLeft(char c){
        return c=='('||c=='['||c=='{';
    }
    public boolean pairs(char a,char b){
        return a=='('&&b==')'||a=='['&&b==']'||a=='{'&&b=='}';
    }
    public boolean isValid(String s) {
        if(s.length()==0) return true;
        Stack<Character> stack=new Stack<>();
        for(int i=0;i<s.length();i++){
            if(isLeft(s.charAt(i))) {//左括号
                stack.push(s.charAt(i));continue;
            }
            if(stack.isEmpty()||!pairs(stack.pop(),s.charAt(i))) return false;
        }
        return stack.isEmpty();
    }
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.isValid("[)"));
    }
}


