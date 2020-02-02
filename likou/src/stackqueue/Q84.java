package stackqueue;

import java.util.Stack;

/**
 * 给定 n 个非负整数，用来表示柱状图中各个柱子的高度。每个柱子彼此相邻，且宽度为 1 。
 *
 * 求在该柱状图中，能够勾勒出来的矩形的最大面积。
 */
public class Q84 {
    //方法 1：暴力
    public int largestRectangleArea(int[] heights) {
        int eara = 0;
        for (int i = 0; i < heights.length; i++) {
            for (int j = i; j < heights.length; j++) {
                int minHight = Integer.MIN_VALUE;
                for (int k = i; k <=j ; k++) {
                    minHight = Math.min(minHight,heights[k]);
                }
                eara = Math.max(eara,minHight*(j-i+1));
            }

        }
        return eara;
    }
    //用栈的思想。
    public int largestRectangleArea01(int[] heights) {
        Stack< Integer > stack = new Stack < > ();
        stack.push(-1);
        int maxarea = 0;
        for (int i = 0; i < heights.length; ++i) {
            while (stack.peek() != -1 && heights[stack.peek()] >= heights[i])
                maxarea = Math.max(maxarea, heights[stack.pop()] * (i - stack.peek() - 1));
            stack.push(i);
        }
        while (stack.peek() != -1)
            maxarea = Math.max(maxarea, heights[stack.pop()] * (heights.length - stack.peek() -1));
        return maxarea;
    }

}
