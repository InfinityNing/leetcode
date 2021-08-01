package no7.整数反转;

public class Solution {
    public int reverse(int x) {
        int result=0,temp=Math.abs(x);
        while(temp!=0){
            System.out.println((Integer.MAX_VALUE-temp%10)/10+"\t"+result);
            if(result>(Integer.MAX_VALUE-temp%10)/10){
                result=0;
                break;
            }
            result=result*10+temp%10;
            temp/=10;
        }
        return x<0?-1*result:result;
    }
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.reverse(-123));
    }
}
