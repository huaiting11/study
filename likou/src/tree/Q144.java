package tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

//给定一个二叉树，返回它的 前序 遍历。
public class Q144 {
    //递归
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        helpr(root,res);
        return res;
    }
    void helpr(TreeNode root,List<Integer> res){
        if(root != null){
            res.add(root.val);
            if(root.left != null){
                helpr(root.left,res);
            }
            if(root.right != null){
                helpr(root.right,res);
            }
        }
    }
    //栈
    public List<Integer> preorderTraversal01(TreeNode root) {
        List<Integer> list = new LinkedList<Integer>();
        if(root == null){
            return list;
        }
        Stack<TreeNode> tovisit = new Stack<TreeNode>();
        tovisit.push(root);
        while (!tovisit.empty()){
            TreeNode visiting = tovisit.pop();
            list.add(visiting.val);
            if(visiting.right!=null){
                tovisit.push(visiting.right);
            }
            if(visiting.left !=null){
                tovisit.push(visiting.left);
            }
        }
        return list;
    }
}
