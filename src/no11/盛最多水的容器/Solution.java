package no11.盛最多水的容器;

public class Solution {
    public int min(int a,int b){
        return a<b?a:b;
    }
    public int maxArea(int[] height) {
        int a=0,b=height.length-1;
        int maxValue=0;
        while(a!=b){
            maxValue=(b-a)*min(height[a],height[b])>maxValue?(b-a)*min(height[a],height[b]):maxValue;
            //System.out.println(height[a]+"\t"+height[b]);
            if(height[a]>height[b]) b--;//每次移动短边，因为移动长边并不会让水量变大，盛水多少取决于短边
            else a++;
        }
        return maxValue;
    }
    public static void main(String[] args) {
        Solution solution = new Solution();
        int height[]={4,3,2,1,4};
        System.out.println(solution.maxArea(height));
    }
}

