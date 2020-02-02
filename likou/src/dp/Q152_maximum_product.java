package dp;

/**
 * 给定一个整数数组 nums ，找出一个序列中乘积最大的连续子序列
 * （该序列至少包含一个数）。
 * 输入: [2,3,-2,4]
 * 输出: 6
 * 解释: 子数组 [2,3] 有最大乘积 6。
 */
public class Q152_maximum_product {
    // 解法一 ：动态规划
    public int maxProduct(int[] nums) {
        int n = nums.length;
        if(n == 0){
            return 0;
        }
        int[] dpMax = new int[n];
        dpMax[0] = nums[0];
        int[] dpMin =  new int[n];
        dpMin[0] = nums[0];
        int max = nums[0];
        for (int i = 1; i < n; i++) {
            dpMax[i] = Math.max(dpMin[i - 1] * nums[i], Math.max(dpMax[i - 1] * nums[i], nums[i]));
            dpMin[i] = Math.min(dpMin[i - 1] * nums[i], Math.min(dpMax[i - 1] * nums[i], nums[i]));
            max = Math.max(max, dpMax[i]);
        }
        return max;
    }
    // 解法2 ： 动态规划  优化写法
    // 动态规划的老问题，我们注意到 更新dp[i] 的时候，我们只用到 dp[i - 1] 的信息，再之前的信息 就用不到了，所以我们完全不需要一个数组，只需要一个
    // 变量去重新覆盖更显即可。
    public int maxProduct01(int[] nums) {
        int n = nums.length;
        if(n == 0){
            return 0;
        }
        int depMax = nums[0];
        int depMin = nums[0];
        int max = nums[0];
        for (int i = 1; i < n; i++) {
            depMax = Math.max(depMin  * nums[i] ,Math.max(depMin * nums[i],nums[i]));
            depMin = Math.min(depMin * nums[i],Math.min(depMax * nums[i],nums[i]));
            max = Math.max(max, depMax);
        }
        return depMax;
    }

}
