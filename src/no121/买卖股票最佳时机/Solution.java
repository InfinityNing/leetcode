package no121.买卖股票最佳时机;

import java.util.Arrays;

/**
 * o(n²)会超时
 * 动态规划可以设计一个minBuy数组，存储某天以前的最小买入，
 * 不过因为数组只循环一次，将其与上边的循环整合后，直接用一个数字来存就可以
 */
public class Solution {
    public static int maxProfit(int[] prices) {
        int max=0;
//        int[] minBuy=new int[prices.length];
//        minBuy[0]=Integer.MAX_VALUE;
        int minBuy=Integer.MAX_VALUE;
        for(int i=1;i<prices.length;i++){
            minBuy=Math.min(minBuy,prices[i-1]);
            max=Math.max(prices[i]-minBuy,max);
        }
        //System.out.println(Arrays.toString(minBuy));

        return max;
    }

    public static void main(String[] args) {
        int[] prices={7,6,4,3,1};
        System.out.println(maxProfit(prices));
    }
}
