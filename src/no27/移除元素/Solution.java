package no27.移除元素;

public class Solution {
    public int removeElement(int[] nums, int val) {
        int flag=0,result=nums.length;
        for(int i=0;i<nums.length;i++){
            if(nums[i]==val) result--;
            if(nums[flag]==val&&nums[i]!=val){
                nums[flag]=nums[i];
                nums[i]=val;
            }
            while(nums[flag]!=val&&flag!=i){
                flag++;
            }
        }
        return result;
    }
    public static void main(String[] args) {
        Solution solution = new Solution();
        int nums[]={3,2,2,3};
        int val=2;
        int result=solution.removeElement(nums,val);
        System.out.println(result);
        for(int i=0;i<result;i++){
            System.out.print(nums[i]+"\t");
        }
    }
}


