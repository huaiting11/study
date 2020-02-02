package dp;

/**
 * 一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为“Start” ）。
 *
 * 机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为“Finish”）。
 *
 * 问总共有多少条不同的路径？
 */
public class Q62_unique_paths {
    /**
     *  分治的思想，递归方法，采用自顶向下的思想，
     *  拆分为若干子问题，但是造成了子问题的重复求解。 用数组 把子问题 的先保存起来
     * @param m
     * @param n
     * @return
     */
    public int uniquePaths(int m, int n) {
       int[][] nums = new int[m][n];
       return help(m,n,nums);
    }
    public int help(int m,int n,int[][] num){
        if(m <= 0 || n <= 0) return 0;
        if(m == 1 || n == 1) return 1;
        if(num[m-1][n-1] != 0) return num[m-1][n-1];
        num[m-1][n-1] = help(m-1,n,num)+help(m,n-1,num);
        return num[m-1][n-1];
    }

    /**
     * 动态规划的思想 ， 自底向上
     * 将原问题 拆分为若干子问题，每个子问题只解答一次，把解保存在一个表中，巧妙的避免了子问题的重复求解
     * @param args
     */
    public int uniquePaths1(int m, int n) {
        int[][] dp = new int[m][n];
        for (int i = 0; i < n; i++) {
            dp[0][i] = 1;
        }
        for (int i = 0; i < m; i++) {
            dp[i][0] = 1;
        }
        for (int i = 1; i < m ; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = dp[i-1][j] +dp[i][j-1];
            }
        }
        return dp[m-1][n-1];
    }
    public static void main(String[] args) {
        Q62_unique_paths q62_unique_paths = new Q62_unique_paths();
        int i =q62_unique_paths.uniquePaths(7,3);
        System.out.println(i);
    }



}
