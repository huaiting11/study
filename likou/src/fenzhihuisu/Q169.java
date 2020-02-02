package fenzhihuisu;

import java.util.Arrays;

/**
 * 给定一个大小为 n 的数组，找到其中的多数元素。多数元素是指在数组中出现次数大于 ⌊ n/2 ⌋ 的元素。

 你可以假设数组是非空的，并且给定的数组总是存在多数元素。
 *
 */
public class Q169 {
    // 暴力法;
    public int majorityElement(int[] nums) {
        int majorityCount = nums.length/2;
        for (int i = 0; i < nums.length; i++) {
            int count = 0;
            for (int j = i+1; j < nums.length; j++) {
                if(nums[i] == nums[j]) count++;
            }
            if(count > majorityCount) return nums[i];
        }
        return -1;
    }
    // 排序
    public int majorityElement01(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length/2];
    }
    // 分治
    //如果我们知道数组左边一半和右边一半的众数，我们就可以用线性时间知道全局的众数是哪个。

}
