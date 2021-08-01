package no39.组合总和;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

/**
 * 应该单独写一个dfs，可以控制时间复杂度，像这种写法很浪费时间
 */
public class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        ArrayList<List<Integer>> resultList= new ArrayList<>(),tempList;
        for(int i=0;i<candidates.length;i++){
            if(candidates[i]==target){
                ArrayList<Integer> intList=new ArrayList<>();
                intList.add(candidates[i]);
                resultList.add(intList);
            }
            if(candidates[i]<target){
                tempList= (ArrayList<List<Integer>>) combinationSum(candidates,target-candidates[i]);
                if(tempList.size()!=0){
                    for(List l:tempList){
                        l.add(candidates[i]);
                        Collections.sort(l);
                    }
                    resultList.addAll(tempList);
                }
            }
        }
        //去重
        HashSet h = new HashSet(resultList);
        resultList.clear();
        resultList.addAll(h);
        return resultList;
    }
    public static void main(String[] args) {
        int a[]={2,3,6,7},b[]={2,3,5};
        System.out.println(new Solution().combinationSum(a,7));
        System.out.println("==================");
        System.out.println(new Solution().combinationSum(b,8));
    }
}
