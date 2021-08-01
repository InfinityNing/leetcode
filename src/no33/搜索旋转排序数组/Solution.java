package no33.搜索旋转排序数组;

/**
 * 给一个升序排列的整数数组nums，和一个整数target，假设按照升序排序的数组在预先未知的某个点上进行了旋转
 * （例如，数组[0,1,2,4,5,6,7]可能变为[4,5,6,7,0,1,2]）
 * 在数组中搜索target，如果数组中存在这个目标值，则返回它的索引，否则返回-1
 *
 * 还是二分查找，在判断时要考虑四种情况，还是挺简单的，就是脑筋没转过来
 */
public class Solution {
    public int binarySearch(int[] nums,int head,int tail,int target) {
        if(head>tail) return -1;
        if (head == tail) {
            if (nums[head] == target) return head;
            else return -1;
        }
        if (nums[(tail + head + 1) / 2] == target)//正好是中间
            return (tail + head + 1) / 2;
        if (nums[head] <= nums[(tail + head + 1) / 2]) {//左侧有序
            if (target >= nums[head] && target < nums[(tail + head + 1) / 2])
                return binarySearch(nums, head, (tail + head + 1) / 2-1, target);//搜索左侧
            else
                return binarySearch(nums, (tail + head + 1) / 2+1, tail, target);//搜索右侧
        } else {//右侧有序
            if (target > nums[(tail + head + 1) / 2] && target <= nums[tail])
                return binarySearch(nums, (tail + head + 1) / 2+1, tail, target);//搜索右侧
            else
                return binarySearch(nums, head, (tail + head + 1) / 2-1, target);//搜索左侧
        }
    }
    public int search(int[] nums, int target) {
        if(nums.length==0) return -1;
        return binarySearch(nums,0,nums.length-1,target);
    }
    public static void main(String[] args) {
        Solution solution = new Solution();
        int nums[]={1,3};
        System.out.println(solution.search(nums,2));
    }
}


