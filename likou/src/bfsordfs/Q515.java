package bfsordfs;

import digui.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 您需要在二叉树的每一行中找到最大的值。
 */
public class Q515 {
    public List<Integer> largestValues(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if(root == null) return res;
        help(res,0,root);
        return res;
    }
    void help(List<Integer> res, int level, TreeNode root){
        if(res.size() == level){
            res.add(Integer.MIN_VALUE);
        }
        int max = res.get(level) > root.val?res.get(level):root.val;
        res.set(level,max);
        if(root.left!=null){
            help(res,level+1,root.left);
        }
        if(root.right!=null){
            help(res,level+1,root.right);
        }
    }
}
