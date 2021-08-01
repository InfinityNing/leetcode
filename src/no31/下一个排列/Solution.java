package no31.下一个排列;

import java.util.Arrays;

/*
实现获取下一个排列的函数，算法需要将给定数字序列重新排列成字典序中下一个更大的排列。
如果不存在下一个更大的排列，则将数字重新排列成最小的排列（即升序排列）。必须原地修改，只允许使用额外常数空间。
e.g.
1   2   3   ->  1   3   2
3   2   1   ->  1   2   3
1   1   5   ->  1   5   1
*/
public class Solution {
    public void swap(int[] nums,int a,int b){
        int temp=nums[a];
        nums[a]=nums[b];
        nums[b]=temp;
    }
    public void nextPermutation(int[] nums) {
        int i;
        for(i=nums.length-2;i>=0;i--){
            if(nums[i]<nums[i+1]) break;//扫描到两个左小右大的数
        }
        Arrays.sort(nums,i+1,nums.length);//将小数右边的字串低到高排序
        if(i<0) return;//如果没找到左小右大的数，说明整个序列已达到最大，低到高排序后就可以return了
        for(int j=i+1;j<nums.length;j++){//将小数和右边排完序中【第一个】大于小数的数交换（也就是大于小数的数中最小的那个）
            if(nums[j]>nums[i]) {
                swap(nums,i,j);
                return;
            }
        }
    }
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums={3,2,1};
        solution.nextPermutation(nums);
        for(int i:nums){
            System.out.print(i+"\t");
        }
    }
}


