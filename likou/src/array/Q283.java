package array;

/**
 * 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
 */
public class Q283 {
    public void moveZeroes(int[] nums) {
        int j=0;
        for (int i = 0; i < nums.length; i++) {
            if(nums[i] != 0){
                nums[j]= nums[i];
                j=j+1;
            }
        }
        for (int i = j; i < nums.length; i++) {
            nums[i]=0;
        }
    }
}
