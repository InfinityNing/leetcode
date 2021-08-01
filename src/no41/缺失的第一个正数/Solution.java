package no41.缺失的第一个正数;

import java.util.Arrays;

public class Solution {
    public int firstMissingPositive(int[] nums) {
        boolean contains1 = false;
        int temp=0;
        Arrays.sort(nums);
        for(int i=0;i<nums.length;i++){
            if(nums[i]<=0) {
                continue;
            }
            if(nums[i]==1){
                contains1 = true;
                temp=1;
                continue;
            }
            if(!contains1) {
                return 1;
            } else if(temp<nums[i]-1){
                break;
            } else{
                temp=nums[i];
            }
        }
        return temp+1;
    }

    public static void main(String[] args) {
        int[] a={3,4,-1,1};
        int[] b={1,2,0};
        Solution solution = new Solution();
        System.out.println(solution.firstMissingPositive(a));
        System.out.println(solution.firstMissingPositive(b));
    }
}
