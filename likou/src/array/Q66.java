package array;

/**
 * 给定一个由整数组成的非空数组所表示的非负整数，在该数的基础上加一。
 *
 * 最高位数字存放在数组的首位， 数组中每个元素只存储单个数字。
 *
 * 你可以假设除了整数 0 之外，这个整数不会以零开头。
 *
 */
public class Q66 {
    public int[] plusOne01(int[] digits) {
        for (int i = digits.length-1; i >=0; i--) {
            digits[i]++;
            digits[i] %= 10;
            if(digits[i] != 0)
                return digits ;
        }
        digits = new int[digits.length+1];
        digits[0]=1;
        return digits;
    }
    public int[] plusOne02(int[] digits) {
        int n = digits.length;
        for (int i = n-1; i >= 0 ; i--) {
            if(digits[i] < 9){
                digits[i]++;
                return  digits;
            }else {
                digits[i]=0;
            }
        }
        digits = new int[digits.length+1];
        digits[0]=1;
        return digits;
    }
}
