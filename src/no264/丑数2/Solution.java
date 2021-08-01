package no264.丑数2;

/**
 * 给你一个整数 n ，请你找出并返回第 n 个 丑数 。
 * 丑数 就是只包含质因数 2、3 和/或 5 的正整数。
 */

/**
 * p2.p3.p5记录需要乘2,3,5的下标，初始三个指针都指向1，因为所有丑数都是先前的丑数乘2，3，5得来的，
 * 三个指针可以确保每个丑数最终都会乘上2,3,5，最小值是保证数组有序
 */
public class Solution {

    public int nthUglyNumber(int n) {
        int[] dp=new int[n];
        int p2=0,p3=0,p5=0;
        dp[0]=1;
        for(int i=1;i<n;i++){
            dp[i]=Math.min(dp[p2]*2,Math.min(dp[p3]*3,dp[p5]*5));
            if(dp[i]==dp[p2]*2) p2++;
            if(dp[i]==dp[p3]*3) p3++;//在2*3和3*2的情况下，两者都前移
            if(dp[i]==dp[p5]*5) p5++;
        }
        return dp[n-1];
    }

    public static void main(String[] args) {
        System.out.println(new Solution().nthUglyNumber(10));
    }
}
