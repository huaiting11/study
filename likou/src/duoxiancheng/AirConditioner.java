package duoxiancheng;

public class AirConditioner {
    private  int num = 0;
    public  void increment(){
        num++;
    }
    public void decrement(){
        if(num > 0){
            num--;
        }
    }
}
