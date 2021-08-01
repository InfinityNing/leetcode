package no26.删除排序数组中的重复项;

public class Solution {
    public int removeDuplicates(int[] nums) {
        int flag=0;
        for(int i=1;i<nums.length;i++){
            if(nums[i]!=nums[flag]){
                flag++;
                nums[flag]=nums[i];
            }
        }
        return flag+1;
    }
    public static void main(String[] args) {
        Solution solution = new Solution();
        int nums[]={0,0,1,1,1};
        System.out.println(solution.removeDuplicates(nums));
    }
}


