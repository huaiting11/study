package stackqueue;

import java.util.Stack;

/**
 * 给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。
 */
public class Q42 {
    /**
     * 暴力
     * @param height
     * @return
     */
    public int trap01(int[] height) {
        int ans=0;
        for (int i = 0; i < height.length-1; i++) {
            int max_left = 0, max_right = 0;
            for (int j = 0; j <=i; j++) {
                max_left = Math.max(max_left, height[j]);
            }
            for (int j = i; j <height.length ; j++) {
                max_right = Math.max(max_right, height[j]);
            }
            //ans = ans + Math.max(max_left,max_right)-height[i];
            ans += Math.min(max_left, max_right) - height[i];
        }
        return ans;
    }
    //暴力求解。
    public int trap03(int[] height) {
        // 最两端不用考虑，因为不会有水
        int aera=0;
        for (int i = 1; i < height.length-1; i++) {
            // 找出最左端，的最高高度
            int left_max = 0;
            for (int j = 0; j <i ; j++) {
                left_max = Math.max(left_max,height[j]);
            }
            int left_Rigth = 0;
            for (int j = i+1; j <height.length ; j++) {
                left_Rigth= Math.max(left_Rigth,height[j]);
            }
            int min_height = Math.min(left_max,left_Rigth);
            if(min_height > height[i]){
                aera += min_height-height[i];
            }
        }
        return aera;
    }
    //栈
    public int trap04(int[] height) {
        int eara = 0;
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < height.length; i++) {
            while (!stack.empty() && height[stack.peek()] < height[i]){
                int h = height[stack.pop()];
                if(stack.empty())break;
                int distance = i -stack.peek()-1;
                int min = Math.min(height[stack.peek()],height[i]);
                eara += distance * (min-h);
            }
            stack.push(i);
        }
        return  eara;
    }



}
