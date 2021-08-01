package no199.二叉树的右视图;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public void watch(List list,TreeNode root,int level){
        if(root==null)
            return ;
        if(list.size()<=level){
            list.add(root.val);
        }else{
            list.set(level,root.val);
        }
        watch(list,root.left,level+1);
        watch(list,root.right,level+1);
    }
    public List<Integer> rightSideView(TreeNode root) {
        ArrayList<Integer> list = new ArrayList<>();
        watch(list,root,0);
        return list;
    }

    public static void main(String[] args) {
        Solution solution=new Solution();
        TreeNode tree=new TreeNode(1);
        tree.left=new TreeNode(2);
        tree.right=new TreeNode(3);
        tree.left.right=new TreeNode(5);
        tree.right.right=new TreeNode(4);
        System.out.println(solution.rightSideView(tree));
    }
}
