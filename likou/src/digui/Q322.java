package digui;

import java.util.Arrays;

/**
 * 给定不同面额的硬币 coins 和一个总金额 amount。编写一个函数来计算可以凑成总金额所需的最少的硬币个数。
 * 如果没有任何一种硬币组合能组成总金额，返回 -1。
 */
public class Q322 {
    // 分治递归
    /*public int coinChange(int[] coins, int amount) {
        if (amount < 1) return 0;
        return coinChange(coins, amount, new int[amount]);
    }

    private int coinChange(int[] coins, int rem, int[] count) {
        if (rem < 0) return -1;
        if (rem == 0) return 0;
        if (count[rem - 1] != 0) return count[rem - 1];
        int min = Integer.MAX_VALUE;
        for (int coin : coins) {
            int res = coinChange(coins, rem - coin, count);
            if (res >= 0 && res < min)
                min = 1 + res;
        }
        count[rem - 1] = (min == Integer.MAX_VALUE) ? -1 : min;
        return count[rem - 1];
    }*/
    public int coinChange1(int[] coins, int amount) {
        int[] temp = new int[amount];
        return help(coins,amount,temp);

    }
    int help(int[] coins,int amount,int[] temp){
        if(amount < 0) return -1;
        if(amount == 0) return 0;
        Integer min = Integer.MAX_VALUE;
        for (int i = 0; i < coins.length; i++) {
            int res = help(coins,amount-coins[i],temp);
            if(res >= 0 && res < min){
                min = 1+ res;
            }
        }
        temp[amount - 1] = (min == Integer.MAX_VALUE) ? -1:min;
        return temp[amount - 1];
    }
    // 动态规划
    public int coinChange01(int[] coins, int amount) {
        int max = amount + 1;
        int[] dp = new int[amount + 1];
        Arrays.fill(dp,max);
        dp[0] = 0;
        for (int i = 1; i <= amount; i++) {
            for (int j = 0; j < coins.length; j++) {
                if(coins[j] <= i ) {
                    dp[i] = Math.min(dp[i],dp[i - coins[j]]+1);
                }
            }
        }
        return dp[amount] > amount ? -1 : dp[amount];
    }
    public static void main(String[] args) {

    }

}
