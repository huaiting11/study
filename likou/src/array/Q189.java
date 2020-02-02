package array;

/**
 * 给定一个数组，将数组中的元素向右移动 k 个位置，其中 k 是非负数。
 *
 * 示例 1:
 *
 * 输入: [1,2,3,4,5,6,7] 和 k = 3
 * 输出: [5,6,7,1,2,3,4]
 * 解释:
 * 向右旋转 1 步: [7,1,2,3,4,5,6]
 * 向右旋转 2 步: [6,7,1,2,3,4,5]
 * 向右旋转 3 步: [5,6,7,1,2,3,4]
 * 示例 2:
 *
 * 输入: [-1,-100,3,99] 和 k = 2
 * 输出: [3,99,-1,-100]
 * 解释:
 * 向右旋转 1 步: [99,-1,-100,3]
 * 向右旋转 2 步: [3,99,-1,-100]
 */
public class Q189 {
    //暴力 旋转k次
    public void rotate01(int[] nums, int k) {
        for (int i = 0; i < k; i++) {
            //向右旋转
            rev(nums);
        }
    }
    public  int[] rev(int[] nums){
        int temp, previous=nums[nums.length-1];
        for (int i = 0; i < nums.length; i++) {
            temp = nums[i];
            nums[i] = previous;
            previous = temp;

        }
        return  nums;
    }
    //方法 2：使用额外的数组
    // 除号/   % 取余 num[] = num[(i+k )% 数组长度];
    public void rotate02(int[] nums, int k) {
        int[] newInt = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            newInt[(i+k) % nums.length] = nums[i];
        }
        for (int i = 0; i < nums.length; i++) {
            nums[i]=newInt[i];
        }
    }
    //方法 3：使用环状替换



    //方法 4：使用反转
    public void rotate04(int[] nums, int k) {
        k %= nums.length;
        revNums(nums,0,nums.length);
        revNums(nums,0,k-1);
        revNums(nums,nums.length-k-1,k);

    }
    void revNums(int[]nums,int start,int end){
        while(start < end){
            int temp = nums[start];
            nums[start] = nums [end];
            nums[start] =temp;
            start++;
            end--;
        }
    }

}
