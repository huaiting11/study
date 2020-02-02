package day1226;

public class Q84 {
    public int largestRectangleArea(int[] heights) {
        int earea=0;
        for (int i = 0; i < heights.length-1; i++) {
            for (int j = i; j < heights.length; j++) {
                int minheight = Integer.MAX_VALUE;
                for (int k = i; k <=j; k++) {
                    minheight = Math.min(minheight,heights[k]);
                }
                earea = Math.max(earea,(j-i+1)*minheight);
            }
        }
        return earea;
    }
    public int largestRectangleArea01(int[] heights) {
        int maxarea = 0;
        for (int i = 0; i < heights.length; i++) {
            for (int j = i; j < heights.length; j++) {
                int minheight = Integer.MAX_VALUE;
                for (int k = i; k <= j; k++)
                    minheight = Math.min(minheight, heights[k]);
                maxarea = Math.max(maxarea, minheight * (j - i + 1));
            }
        }
        return maxarea;
    }


}
