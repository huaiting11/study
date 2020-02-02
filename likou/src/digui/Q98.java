package digui;

/**
 * 给定一个二叉树，判断其是否是一个有效的二叉搜索树。
 */
public class Q98 {
    public boolean isValidBST(TreeNode root) {
        return helper(root, null, null);
    }
    public boolean helper(TreeNode node, Integer lower, Integer uper){
        if(node == null) return true;

        int val = node.val;
        if(lower != null && val <= lower) return  false;
        if(uper != null  && val >= uper) return  false;

        if(!helper(node.right, val,uper)) return false;
        if(!helper(node.left,lower,val)) return false;
        return true;
    }

}
