package no34.在排序数组中查找元素的第一个和最后一个位置;

//这是看到的一个非常不错的题解
//思想是通过searchFirst中二分查找得到大于等于该目标值的下标
//然后调用相同的函数得到目标值下一个数的下标，相当于取巧
//好处就是通过一个函数就可以实现功能，缺点是如果目标值是最大整型数需要判断
public class Solution {
    public int searchFirst(int[] nums,int target){
        int left=0, right=nums.length,mid;
        while(left!=right){
            mid=(left+right)/2;
            if(nums[mid]<target)
                left=mid+1;
            else
                right=mid;
        }
        System.out.println(left);
        return left;
    }
    public int[] searchRange(int[] nums, int target) {
        int a=searchFirst(nums,target);
        if(a==nums.length||nums[a]!=target)//不存在target
            return new int[]{-1, -1};
        if(target==Integer.MAX_VALUE)
            return new int[]{a, nums.length-1};
        int b=searchFirst(nums,target+1);
        return new int[]{a, b-1};
    }
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums={5,7,7,8,8,10};
        int target=8;
        for(int i:solution.searchRange(nums,target)){
            System.out.print(i+"\t");
        }
    }
}


