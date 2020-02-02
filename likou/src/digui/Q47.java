package digui;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *给定一个可包含重复数字的序列，返回所有不重复的全排列。
 * [1,1,2]
 */
public class Q47 {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        int[] flag = new int[nums.length];
        help(0,res,nums,new ArrayList<Integer>(),flag);
        return res;
    }
    void help(int level, List<List<Integer>> res,int[] nums,List<Integer> temp, int[] flag ){
        if(level == nums.length){
            res.add(new ArrayList<>(temp));
        }
        for (int i = 0; i < nums.length; i++) {
            if(flag[i] == 1)continue;
            if(i > 0 &&flag[i]== flag[i-1] && flag[i-1]==1) continue;
            temp.add(nums[i]);
            flag[i]=1;
            help(level+1,res,nums,temp,flag);
            flag[i]=0;
            temp.remove(temp.size()-1);
        }
    }
}
