package dp;

import sun.util.calendar.Gregorian;

/**
 * 一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为“Start” ）。
 *
 * 机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为“Finish”）。
 *
 * 现在考虑网格中有障碍物。那么从左上角到右下角将会有多少条不同的路径？
 */
public class Q63_unique_paths_ii {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int[][] dp = obstacleGrid;
        if(obstacleGrid[0][0] == 1) return 0;
        dp[0][0] = 1;
        for (int i = 1; i < obstacleGrid.length; i++) {
            dp[i][0]= obstacleGrid[i][0] == 1 ? 0: obstacleGrid[i-1][0];
        }
        for (int i = 1; i < obstacleGrid[0].length; i++) {
            dp[0][i]= obstacleGrid[0][i] == 1 ? 0: obstacleGrid[0][i-1];
        }
        for (int i = 1; i < obstacleGrid.length; i++) {
            for (int j = 1; j < obstacleGrid[0].length; j++) {
                if(obstacleGrid[i][j] == 1){
                    dp[i][j] = 0;
                }else {
                    dp[i][j] = dp[i-1][j] + dp[i][j-1];
                }
            }
        }
        return dp[obstacleGrid.length-1][obstacleGrid[0].length-1];
    }
}
