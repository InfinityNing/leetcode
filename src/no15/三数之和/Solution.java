package no15.三数之和;
import java.util.*;

/**
 * 共有四种情况
 *   -   0   +
 *   1   1   1
 *   2   0   1
 *   1   0   2
 *   0   3   0
 * 该题本身思路是左右指针从两头出发，动指针在中间寻找目标，后来发现这样处理会有丢解情况且无法解决
 * 于是使用题解的动指针从头出发，左右指针在静指针右侧逐渐向中间收紧
 */

public class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        ArrayList<List<Integer>> result=new ArrayList<>();
        ArrayList<Integer> temp=new ArrayList<>();
        Arrays.sort(nums);
        int a,b;
        if(nums==null||nums.length<3) return result;
        for(int i=0;i<nums.length&&nums[i]<=0;i++){
            if(i>0&&nums[i]==nums[i-1]) continue;
            a=i+1;b=nums.length-1;
            while(a<b){
                if(nums[a]+nums[b]+nums[i]==0){
                    temp.add(nums[i]);
                    temp.add(nums[a]);
                    temp.add(nums[b]);
                    result.add((List<Integer>) temp.clone());
                    temp.clear();
                    while(a<b&&nums[a]==nums[a+1]){
                        a++;
                    }
                    while(a<b&&nums[b]==nums[b-1]){
                        b--;
                    }
                    a++;b--;
                }
                else if(nums[a]+nums[b]+nums[i]>0) b--;
                else a++;
            }
        }
        return result;
    }
    public static void main(String[] args) {
        Solution solution = new Solution();
        int nums[]={0,0,0};
        List<List<Integer>> result=solution.threeSum(nums);
        System.out.println(result);
    }
}


//public class Solution {
//    public List<List<Integer>> threeSum(int[] nums) {
//        ArrayList<List<Integer>> result=new ArrayList<>();
//        ArrayList<Integer> temp=new ArrayList<>();
//        Arrays.sort(nums);
//        int a=0,b=nums.length-1,index;
//        boolean mark=false;//true表示需要回滚
//        while(b-a>1){
//            mark=Math.abs(nums[a])>Math.abs(nums[b]);
//            index=mark?b-1:a+1;
//            while(index!=a&&index!=b){//寻找能与两数配成0的数字
//                if(nums[a]+nums[b]+nums[index]==0){//找到了
//                    temp.add(nums[a]);
//                    temp.add(nums[index]);
//                    temp.add(nums[b]);
//                    result.add((List<Integer>) temp.clone());
//                    temp.clear();
//                    break;
//                }
//                if(mark) index--;
//                else index++;
//            }
//            if(mark) {
//                index=a;
//                while(nums[index]==nums[a]&&b-a>1){
//                    a++;
//                }
//            } else {
//                index=b;
//                while(nums[index]==nums[b]&&b-a>1){
//                    b--;
//                }
//            }
//        }
//        return result;
//    }
//}


