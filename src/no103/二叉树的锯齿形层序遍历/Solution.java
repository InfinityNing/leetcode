package no103.二叉树的锯齿形层序遍历;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Solution {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
        }
    }
    ArrayList<List<Integer>> list;
    Solution(){
        list=new ArrayList<>();
    }
    public void zigzag(TreeNode root,int level){
        if(root==null) return ;
        if(list.size()<=level){
            list.add(new ArrayList<>());
        }
        list.get(level).add(root.val);
        zigzag(root.left,level+1);
        zigzag(root.right,level+1);
    }
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        zigzag(root,0);
        //System.out.println(list);
        list.stream().forEach(e->{
            if(list.indexOf(e)%2==1){
                Collections.reverse(e);
            }
        });
        return list;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        TreeNode node=new TreeNode(3,
                new TreeNode(9,null,null),
                new TreeNode(20,
                        new TreeNode(15,null,null),
                        new TreeNode(7,null,null)));
        System.out.println(solution.zigzagLevelOrder(node));

    }
}
