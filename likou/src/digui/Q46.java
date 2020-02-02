package digui;

import java.util.ArrayList;
import java.util.List;

public class Q46 {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        help(0,nums,list,new ArrayList<>());
        System.out.println(list);
        return list;
    }
    public void help(int level,int[] nums,List<List<Integer>> list,List<Integer> temp){
        if(level == nums.length){
            list.add(new ArrayList<>(temp));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if(temp.contains(nums[i])) continue;
            temp.add(nums[i]);
            help(level+1,nums,list,temp);
            temp.remove(temp.size()-1);
        }
    }

    public static void main(String[] args) {
        Q46 q46 = new Q46();
        int[] c = {1,2,3};
        q46.permute(c);
    }



}
