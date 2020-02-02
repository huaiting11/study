package digui;



/**
 * 翻转一棵二叉树。
 */
public class Q226 {
    public TreeNode invertTree(TreeNode root) {
        if(root == null){
            return  null;
        }
        TreeNode right = invertTree(root.right);
        TreeNode left = invertTree(root.left);
        root.right = left;
        root.left = right;
        return root;
    }
}
