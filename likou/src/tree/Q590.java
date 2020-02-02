package tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Q590 {
    //递归
    public List<Integer> postorder(Node root) {
        List<Integer> res = new ArrayList<>();
        help(root,res);
        return res;
    }
    public void help(Node root,List<Integer> res){
        if(root != null){
            for (int i = 0; i < root.children.size(); i++) {
                help(root.children.get(i),res);
            }
            res.add(root.val);
        }
    }
    //栈
    public List<Integer> postorder01(Node root) {
        Stack<Node> stack = new Stack<Node>();
        List<Integer> res = new ArrayList<>();
        if(root == null){
            return res;
        }
        stack.add(root);
        while (!stack.isEmpty()){
            Node node = stack.pop();
            res.add(0,node.val);
            for(Node item :node.children){
                if(item != null){
                    stack.add(item);
                }
            }
        }
        return res;
    }
}
