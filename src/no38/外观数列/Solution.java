package no38.外观数列;

public class Solution {
    public String describe(String n){
        String input=String.valueOf(n),result="";
        int count=0;
        char mark=' ';
        for(int i=0;i<input.length();i++){
            if(mark!=input.charAt(i)&&count!=0){
                result=result+count+mark;
                count=0;
            }
            mark=input.charAt(i);
            count++;
        }
        result=result+count+mark;
        return result;
    }
    public String countAndSay(int n) {
        if(n==1) return "1";
        else return describe(countAndSay(n-1));
    }
    public static void main(String[] args) {
        System.out.println(new Solution().countAndSay(5));
    }
}
