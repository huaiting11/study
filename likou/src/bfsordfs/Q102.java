package bfsordfs;

import digui.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个二叉树，返回其按层次遍历的节点值。 （即逐层地，从左到右访问所有节点）。
 * [
 *   [3],
 *   [9,20],
 *   [15,7]
 * ]
 */
public class Q102 {
    //广度优先搜索，队列
    public List<List<Integer>> levelOrder(TreeNode root) {
        return null;
    }
    //深度优先搜索，栈和递归
    public List<List<Integer>> levelOrder01(TreeNode root) {
        if(root == null) return new ArrayList<>();
        List<List<Integer>> res = new ArrayList<>();
        help(res,root,0);
        return null;
    }
    void help(List<List<Integer>> res , TreeNode root, int level){
       if(root == null){
          return;
       }
      if(res.size()==level){
          res.add(new ArrayList<Integer>());
      }
       res.get(level).add(root.val);
       if(root.right!= null){
           help(res,root.right,level+1);
       }
       if(root.left != null){
           help(res,root.left,level+1);
       }
    }

    public static void main(String[] args) {
        Q102 q102 = new Q102();

    }

}
