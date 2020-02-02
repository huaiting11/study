package erfen;

/**
 * 假设按照升序排序的数组在预先未知的某个点上进行了旋转。
 *
 * ( 例如，数组 [0,1,2,4,5,6,7] 可能变为 [4,5,6,7,0,1,2] )。
 *
 * 搜索一个给定的目标值，如果数组中存在这个目标值，则返回它的索引，否则返回 -1 。
 *
 * 你可以假设数组中不存在重复的元素。
 *
 * 你的算法时间复杂度必须是 O(log n) 级别。
 */
public class Q33 {
    public int search(int[] nums, int target) {
        int left = 0,right = nums.length-1;
        if(nums.length == 1){
            return nums[0]== target ? nums[0]:-1;
        }
        int min = find(left,right,nums);
        if(min==0){
            return search(nums,0,right,target);
        }
        if(target < nums[0]){
            return search(nums,min,right,target);
        }else{
            return search(nums,0,min,target);
        }
    }
    int search(int[] nums,int left,int right,int target){
        while(left <= right){
            int mid = (right-left)/2 + left;
            if(nums[mid] == target){
                return mid;
            }else{
                if(nums[mid] < target){
                    left = mid;
                }else{
                    right = mid-1;
                }
            }
        }
        return -1;
    }
    int find(int left,int right,int[] nums){
        if(nums[left] < nums[right]){
            return left;
        }
        while (left <= right){
            int mid = left+(right-left)/2;
            if(nums[mid] > nums[mid+1]){
                return mid+1;
            }else if(nums[mid-1] > nums[mid]){
                return mid;
            }
            if(nums[mid] > nums[0]){
                left= left+1;
            }else {
                right= right-1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Q33 q33=new Q33();
        int[] n= {1,3};
        System.out.println(q33.search(n,3));
    }
}
