package no3.无重复字符的最长子串;

public class Solution {
    public int lengthOfLongestSubstring(String s) {
        int flag=0,maxLength=0;
        boolean mark=false;
        String ss="";
        for(int i=0;i<s.length();i++){
            //System.out.println("子串为"+ss+"主串扫描到"+s.charAt(i)+"flag="+flag);
            for(int j=0;j<ss.length();j++){
                if(ss.charAt(j)==s.charAt(i)){
                    mark=true;
                    flag=flag+j+1;System.out.println("flag="+flag);
                    break;
                }
            }
            ss=s.substring(flag,i+1);
            if(!mark){
                //System.out.println("子串为"+ss);
                maxLength=maxLength<ss.length()?ss.length():maxLength;//System.out.println("maxlenth为"+maxLength);

            }
            mark=false;
        }
        return maxLength;
    }
    public static void main(String[] args) {
        String s="dddddddd";
        Solution solution=new Solution();
        System.out.println(solution.lengthOfLongestSubstring(s));
    }
}
