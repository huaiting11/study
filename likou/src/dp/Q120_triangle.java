package dp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Level;

/**
 * 给定一个三角形，找出自顶向下的最小路径和。每一步只能移动到下一行中相邻的结点上。
 * [
 *      [2],
 *     [3,4],
 *    [6,5,7],
 *   [4,1,8,3]
 * ]
 * （即，2 + 3 + 5 + 1 = 11）
 */

/**
 * DP
 * 1.重复性（分治）
 *  1.problem（i，j） = min(sub(i+1,j),sub(i+1,j+1))+a[i,j]
 *  2.sub(i+1,j): 下一行当前列（即向下并向左走）的路径总数
 *  3.sub(i+1,j+1): 下一行下一列 (即向下并向右走)的路径总数
 *  4.路径总数包括自己所在位置a[i,j] ,即到达当前位置所需的步数
 * 2、定义状态数组
 *  1 dp[i,j]
 * 3 dp 方程
 *  dp[i,j] =
 */
public class Q120_triangle {
    // 动态规划 ，自底向上，从底部往上走
    public int minimumTotal(List<List<Integer>> triangle) {
        List<List<Integer>> list = triangle;
        for (int i = list.size()-2; i >= 0 ; i--) {
            for (int j = 0; j < list.get(i).size(); j++) {
                list.get(i).set(j,list.get(i).get(j)+Math.min(list.get(i+1).get(j),list.get(i+1).get(j+1)));
            }

        }
        return list.get(0).get(0);
    }
    // 递归 ，自顶向下，从上往下
    public int minimumTotal01(List<List<Integer>> triangle){
        Integer[][] temp = new Integer[triangle.size()][triangle.get(triangle.size()-1).size()];
        return  help(triangle,0,0,temp);


    }
    public int help(List<List<Integer>> triangle,Integer m,Integer n,Integer[][] temp){
        if(m == triangle.size()-1){
            return triangle.get(m).get(n);
        }
        if(temp[m][n] != null) return temp[m][n];
        int a = help(triangle,m+1,n,temp);
        int b = help(triangle,m+1,n+1,temp);
        int tem = Math.min(a,b)+triangle.get(m).get(n);
        temp[m][n]= tem;
        return tem;
    }

    public static void main(String[] args) {
        Q120_triangle triangle = new Q120_triangle();
        //[[2],[3,4],[6,5,7],[4,1,8,3]]
        Integer[][] li ={{2},{3,4},{6,5,7},{4,1,8,3}};
        List<List<Integer>> list = new ArrayList<>();
        for (int i = 0; i < li.length; i++) {
            List<Integer> temp  =  new ArrayList<>();
            for (int j = 0; j < li[i].length; j++) {
                temp.add(j,li[i][j]);
            }
            list.add(i,temp);
        }
        int a = triangle.minimumTotal01(list);
        System.out.println(a);
    }
}
