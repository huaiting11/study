package digui;

public class Q70 {
    public int climbStairs(int n) {
        int memo[] = new int[n + 1];
        return  help(n,memo);
    }
    int help(int n,int[] memo){
        if(n == 1){
            return 1;
        }else if(n == 2){
            return 2;
        }
        if(memo[n] > 0){
            return memo[n];
        }
        memo[n]=help(n-1,memo)+help(n-2,memo);
        return  memo[n];
    }

}
