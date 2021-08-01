package no29.XXX两数相除;


public class Solution {
    public boolean same(int a,int b){
        return a>=0&&b>=0||a<=0&&b<=0;
    }
    public int divide(int dividend, int divisor) {
        int result=0;
        int temp=dividend;
        boolean isSame=same(dividend,divisor);
        if(dividend==Integer.MIN_VALUE&&divisor==-1)
            return Integer.MAX_VALUE;
        if(dividend==0) return 0;
        if(divisor==1) return dividend;
        while(true){
            dividend=isSame?dividend-divisor:dividend+divisor;
            if(same(dividend,temp)){
                if(isSame) result++;
                else result--;
                continue;
            }
            return result;
        }
    }
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.divide(Integer.MIN_VALUE,2));
    }
}


