package no16.最接近的三数之和;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int a,b,result=Integer.MAX_VALUE,dist=Integer.MAX_VALUE;
        for(int i=0;i<nums.length;i++){
            a=i+1;b=nums.length-1;
            while(a<b){
                if(Math.abs(nums[a]+nums[b]+nums[i]-target)<dist){
                    dist=Math.abs(nums[a]+nums[b]+nums[i]-target);
                    result=nums[a]+nums[b]+nums[i];

                }
                if(nums[a]+nums[b]+nums[i]>target) b--;
                else a++;
            }
        }
        return result;
    }
    public static void main(String[] args) {
        Solution solution = new Solution();
        int nums[]={0,2,1,-3};
        System.out.println(solution.threeSumClosest(nums,1));
    }
}


