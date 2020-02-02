package tanxin;

/**
 * 给定一个非负整数数组，你最初位于数组的第一个位置。
 *
 * 数组中的每个元素代表你在该位置可以跳跃的最大长度。
 *
 * 判断你是否能够到达最后一个位置。
 */
public class Q55_jumpGame {
    public boolean canJump(int[] nums) {
        if(nums.length == 0 ){
            return  false;
        }
        int pos = nums.length-1;
        for (int i = nums.length-1; i >= 0; i--) {
            if(nums[i] + i >= pos){
                pos = i;
            }
        }
        return pos==0;
    }
}
