package dp;

/**
 * 给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），
 * 返回其最大和。
 *
 *  分治法解决问题的模板：
 *  定义基本情况
 *  将问题分解为子问题并递归的解决它们。
 *  合并子问题的解以获得原始问题的解。
 */
public class Q53_maximum_subarray {
    public int maxSubArray(int[] nums) {
        int[] dp = nums;
        Integer max =Integer.MIN_VALUE;
        for (int i = 1; i < dp.length; i++) {
            dp[i] = Math.max(dp[i-1],0)+nums[i];
            max = Math.max(max,dp[i]);
        }
        System.out.println(dp.toString());
        return max;
    }

    public static void main(String[] args) {
        Q53_maximum_subarray q53_maximum_subarray = new Q53_maximum_subarray();
        int[] i = {1,2};
        q53_maximum_subarray.maxSubArray(new int[]{-1,-2});
    }
    /**
     * dp 问题，公式为dp[i] = max(nums[i]+0,num[i]+dp[i]-1)
     * 2.最大子序列和 = 当前元素自身最大，或者包含之前后最大
     */
}
