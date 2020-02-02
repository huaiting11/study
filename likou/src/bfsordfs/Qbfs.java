package bfsordfs;

import digui.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Qbfs {
    TreeNode node = new TreeNode(3);
    Queue<TreeNode> ques = new LinkedList<>();
    List<Integer> list =  new ArrayList<>();
    public void bfs(){
        if(!ques.isEmpty()){
            TreeNode node = ques.poll();
            list.add(node.val);
            if(node.right!=null){
                ques.add(node.right);
            }
            if(node.left!=null){
                ques.add(node.left);
            }
        }
    }


}
