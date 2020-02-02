package dp;

/**
 * 你是一个专业的小偷，计划偷窃沿街的房屋。每间房内都藏有一定的现金，影响你偷窃的唯一制约因素就是相邻的房屋装有相互连通的防盗系统，如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警。
 *
 * 给定一个代表每个房屋存放金额的非负整数数组，计算你在不触动警报装置的情况下，能够偷窃到的最高金额。
 */
public class Q198_robber {
    public int rob(int[] nums) {
        int len = nums.length;
        if(len == 0) return 0;
        int[] dp  = nums;
        dp[1] = Math.max(nums[0],nums[1]);
        for (int i = 2; i < len ; i++) {
            dp[i] = Math.max(dp[i-1]+nums[i],dp[i-2]);
        }
        return dp[len -1];
    }

    public static void main(String[] args) {
        Q198_robber robber = new Q198_robber();
        robber.rob(new int[]{1,2,3,1});
    }
}
