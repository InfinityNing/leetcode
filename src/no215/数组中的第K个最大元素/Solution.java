package no215.数组中的第K个最大元素;


public class Solution {
    public int findKthLargest(int[] nums, int k) {
        int temp;
        for(int i=0;i<k;i++){
            for(int j=1;j< nums.length-i;j++){
                if(nums[j]<nums[j-1]){
                    temp=nums[j];
                    nums[j]=nums[j-1];
                    nums[j-1]=temp;
                }
            }
        }
        return nums[nums.length-k];
    }

    public static void main(String[] args) {
        int[] arr={7,6,5,4,3,2,1};
        System.out.println(new Solution().findKthLargest(arr,2));
    }
}
