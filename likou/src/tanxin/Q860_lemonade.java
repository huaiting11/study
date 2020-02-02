package tanxin;

public class Q860_lemonade {
    public boolean lemonadeChange(int[] bills) {
        int five=0,ten=0;
        for (int  b: bills) {
            if(b == 5){
                five++;
            }else if(b == 10){
                if(five < 0) return false;
                five--;
                ten++;
            }else if(b==20){
                if(five > 0 && ten > 0){
                    five--;
                    ten--;
                }else if(five > 3){
                    five=five-3;
                }else{
                    return false;
                }
            }
        }
        return true;
    }
    //优先使用1张10元和1张5元的给20找零，而不是用3张5元的找零就是贪心，这可真是说明了贪心只是一种思想啊
}
