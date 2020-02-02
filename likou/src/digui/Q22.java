package digui;

import java.util.ArrayList;
import java.util.List;

/**
 * 给出 n 代表生成括号的对数，请你写出一个函数，使其能够生成所有可能的并且有效的括号组合。
 *[
 *   "((()))",
 *   "(()())",
 *   "(())()",
 *   "()(())",
 *   "()()()"
 * ]
 */
public class Q22 {
    public List<String> generateParenthesis(int n) {
        List<String> list = new ArrayList<>();
        help(0,0,"",n,list);
        return list;
    }
    public void help(int left,int right,String s,int max ,List<String> res){

        if(s.length() == max * 2){
            res.add(s);
            return;
        }
        if(left < max){
            help(left+1,right,s+"(",max,res);
        }
        if(right < max && right < left){
            help(left,right+1,s+")",max,res);
        }
    }

    public static void main(String[] args) {
        Q22 q22 = new Q22();
        q22.generateParenthesis(6);
    }

}
