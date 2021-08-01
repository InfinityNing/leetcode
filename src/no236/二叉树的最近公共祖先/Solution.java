package no236.二叉树的最近公共祖先;

public class Solution {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
        TreeNode(int x,TreeNode left,TreeNode right) {
            val = x;
            this.left=left;
            this.right=right;
        }
    }
    TreeNode node;
    public boolean containsChild(TreeNode root, TreeNode p, TreeNode q){
        boolean left,right;
        if(root==null) return false;
        left=containsChild(root.left,p,q);
        right=containsChild(root.right,p,q);
        if(left&&right){
            node=root;
        }
        if((left||right)&&(root==p||root==q)){
            node=root;
        }
        return left||right||root==p||root==q;
    }
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        containsChild(root,p,q);
        return node;
    }

    public static void main(String[] args) {
        TreeNode a=new TreeNode(4,null,null);
        TreeNode b=new TreeNode(5,
                new TreeNode(6,null,null),
                new TreeNode(2,
                        new TreeNode(7,null,null),
                        a
                )
        );
        TreeNode node = new TreeNode(3,
                b,
                new TreeNode(1,
                        new TreeNode(0,null,null),
                        new TreeNode(8,null,null)
                )
        );
        System.out.println(new Solution().lowestCommonAncestor(node,a,b).val);
    }
}
