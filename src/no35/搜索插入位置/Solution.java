package no35.搜索插入位置;

//跟上一题思想相同，求该值第一个位置，若不存在该值就会返回比该值大的数中最接近的一个位置
//e.g. {1,3,5,7} 6 返回3
//本题没有重复元素，更简单
public class Solution {
    public int searchInsert(int[] nums, int target) {
        int left=0, right=nums.length/*这个重点，注意不要减一*/,mid;
        while(left!=right){
            mid=(left+right)/2;
            if(nums[mid]<target)
                left=mid+1;
            else
                right=mid;
        }
        return left;
    }
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums={1,3,5,6};
        int target=7;
        System.out.println(solution.searchInsert(nums,target));
    }
}


