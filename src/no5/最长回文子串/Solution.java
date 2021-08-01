package no5.最长回文子串;
//为什么耗时非常多，感觉这么写不太暴力，比较吃测试用例
//思想是从中间字符往两边扩散，两个字符中间的空位也算中间字符选取
public class Solution {
    public String longestPalindrome(String s) {
        int left,right,cutLength;
        String result="",sub="";
        for(int i=0;i<s.length()*2-1;i++){
            cutLength=2-i%2;
            left=i-cutLength;right=i+cutLength;
            sub=i%2==0?String.valueOf(s.charAt(i/2)):"";
            //System.out.println("cutLength="+cutLength+"\tleft="+left+"\tright="+right+"\tsub="+sub);
            while(left>=0&&right<s.length()*2&&s.charAt(left/2)==s.charAt(right/2)){
                sub=String.valueOf(s.charAt(left/2))+sub+String.valueOf(s.charAt(right/2));
                //System.out.println("===="+"cutLength="+cutLength+"\tleft="+left+"\tright="+right+"\tsub="+sub);
                left-=2;right+=2;
            }
            result=sub.length()>result.length()?sub:result;
        }
        return result;
    }
    public static void main(String[] args) {
        Solution solution=new Solution();
        System.out.println(solution.longestPalindrome("aaaa"));
    }
}
