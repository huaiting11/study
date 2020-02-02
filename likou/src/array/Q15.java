package array;

import java.util.*;

/**
 * 给定一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？找出所有满足条件且不重复的三元组。
 *
 * 注意：答案中不可以包含重复的三元组。
 * tree sum
 */
public class Q15 {
    //暴力查找，记得去排除重复的组合。
    public List<List<Integer>> threeSum01(int[] nums) {
        List<List<Integer>> s = new ArrayList<>();
        Set<String> set = new HashSet<String>();
        for (int i = 0; i < nums.length-2; i++) {
            for (int j = i+1; j < nums.length-1; j++) {
                for (int k = j+1; k < nums.length; k++) {
                    if(nums[i]+nums[k]+nums[j]==0){
                        int[] a = new int[]{nums[i],nums[k],nums[j]};
                        Arrays.sort(a);
                        if(!set.contains(Arrays.toString(a))){
                            s.add(Arrays.asList(nums[i],nums[k],nums[j]));
                            set.add(Arrays.toString(a));
                        }

                    }
                }

            }
        }
        return s;
    }
    // 双指针法。
    public List<List<Integer>> threeSum02(int[] nums) {
        List<List<Integer>> s = new ArrayList<>();
        Arrays.sort(nums);// 先排序
        for (int i = 0; i < nums.length-2; i++) {
            if(nums[i]>0 && i==0)break;
            if(i>0 && nums[i]==nums[i-1])continue;
            int l = i+1;
            int r = nums.length-1;
            while (l < r){
                int sum = nums[i] +nums[l] + nums[r];
                if( sum== 0){
                    s.add(Arrays.asList(nums[i],nums[l],nums[r]));
                    while (l<r && nums[l+1]==nums[l]){
                        l++;
                    }
                    while (l < r && nums[r-1] == nums[r]){
                        r--;
                    }
                    l++;
                    r--;
                }else if(sum < 0){
                    l++;
                }else{
                    r--;
                }
            }
            
        }
        return s;
    }
}
