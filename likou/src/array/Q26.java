package array;
// 双指针 一快一慢
public class Q26 {
    // 双指针；
    public int removeDuplicates01(int[] nums) {
        if ( nums.length == 0 ) return 0;
        int i = 0;
        for (int j = 1; j < nums.length ; j++) {
            if( nums[j] != nums [i]){
                i++;
                nums[i] = nums[j];
            }
        }
        return  i+1;
    }

    public static void main(String[] args) {
        Q26 q26 = new Q26();
        int[] n = {1,1,3,4,5,6};
        q26.removeDuplicates01(n);
    }
}
