package array;

/**
 * 给定 n 个非负整数 a1，a2，...，an，每个数代表坐标中的一个点 (i, ai) 。在坐标内画 n 条垂直线，
 * 垂直线 i 的两个端点分别为 (i, ai) 和 (i, 0)。找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。
 *
 * 说明：你不能倾斜容器，且 n 的值至少为 2。
 *。
 */
public class Q11 {
    //暴力查找
    public int maxArea01(int[] height) {
        int earea = 0;
        for (int i = 0; i < height.length-1; i++) {
            for (int j = i+1; j < height.length; j++) {
                int minHeight= Math.min(height[i],height[j]);
                earea =Math.max(earea,(j-i)*minHeight);
            }
        }
        return earea;

    }
    //双指针，哪个小，哪个往中间移动，
    public int maxArea02(int[] height) {
       int earea =0,l= 0,r=height.length-1;
       while (l < r) {
           int minHeight=  Math.min(height[l],height[r]);
           earea = Math.max(earea,minHeight*(r-l));
           if(height[r]>height[l] ){
               l++;
           }else {
               r--;
           }

       }
       return earea;
    }
}
