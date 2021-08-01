package no239.滑动窗口最大值;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;

public class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if(k<=0){
            return new int[0];
        }
        if(nums.length==0){
            return new int[0];
        }
        Deque<Integer> deque = new ArrayDeque();
        ArrayList<Integer> result=new ArrayList();
        for(int i=0;i<nums.length;i++){
            if(deque.size()>0&&deque.getFirst()<=i-k){
                deque.removeFirst();
            }
            while(deque.size()>0&&nums[deque.getLast()]<nums[i]){
                deque.removeLast();
            }
            deque.addLast(i);
            if(i>=k-1){
                result.add(nums[deque.getFirst()]);
            }
        }
        return result.stream().mapToInt(Integer::intValue).toArray();
    }
    public static void main(String[] args) {
        int[] arr={1,3,1,2,0,5};
        int[] result=new Solution().maxSlidingWindow(arr,3);
        System.out.println(Arrays.toString(result));
    }
}
