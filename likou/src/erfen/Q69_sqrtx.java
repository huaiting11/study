package erfen;

public class Q69_sqrtx {
    public int mySqrt(int x) {
        long left = 0;
        long right = x/2+1;
        while (left < right){
            long mid = left+(right - left+1) /2;
            long seq = mid* mid;
            if(seq > x ){
                right = mid-1;
            }else{
                left = mid;
            }
        }
        return (int) left;

    }
}
