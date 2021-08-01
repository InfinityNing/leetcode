package no110.平衡二叉树;

class Solution {
    public boolean isBalanced(TreeNode root) {
        return height(root)>=0;
    }
    public int height(TreeNode root){
        if(root==null){
            return 0;
        }
        int l=height(root.left),r=height(root.right);
        if(l==-1||r==-1)
            return -1;
        if(Math.abs(l-r)>1)
            return -1;
        return Math.max(l,r)+1;
    }

    public static void main(String[] args) {
        Solution solution=new Solution();
        TreeNode tree=new TreeNode(3);
        tree.left=new TreeNode(9);
        tree.right=new TreeNode(20);
        tree.right.left=new TreeNode(15);
        tree.right.right=new TreeNode(7);
        boolean isBalanced = solution.isBalanced(tree);
        System.out.println(isBalanced);
    }
}
