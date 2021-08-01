package no9.回文数;
//弱智题目
public class Solution {
    public boolean isPalindrome(int x) {
        if(x<0)return false;
        int num=0,temp=x;
        while(temp>0){
            num=num*10+temp%10;
            temp/=10;
        }
        return num==x;
    }
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.isPalindrome(-1212));
    }
}
