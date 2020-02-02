package erfen;

public class Q367_perfectSquare {
    public boolean isPerfectSquare(int num) {
        if(num < 2){
            return  true;
        }
        long left = 2,right = num/2;
        while (left < right){
            long mid = left+(right-left)/2;
            long seq = mid * mid;
            if(seq == num){
                return true;
            }else{
                if(seq > num){
                    right = mid -1;
                }else{
                    left = mid;
                }
            }
        }
        return false;
    }


}
