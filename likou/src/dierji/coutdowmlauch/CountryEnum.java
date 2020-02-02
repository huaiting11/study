package dierji.coutdowmlauch;

public enum CountryEnum {
    ONE(1,"齐国"),
    TWO(2,"楚国"),
    THREE(3,"燕国"),
    FOUR(4,"赵国"),
    FIVE(5,"魏国"),
    SIX(6,"韩国");
    private Integer retCode;
    private String retMessage;
    CountryEnum(Integer retCode, String retMessage) {
        this.retCode = retCode;
        this.retMessage = retMessage;
    }
    public static CountryEnum foreach(Integer index){
        CountryEnum[] my = CountryEnum.values();
        for (CountryEnum ele : my){
            if(index == ele.retCode){
                return ele;
            }
        }
        return null;
    }
    public Integer getRetCode() {
        return retCode;
    }
    public void setRetCode(Integer retCode) {
        this.retCode = retCode;
    }
    public String getRetMessage() {
        return retMessage;
    }
    public void setRetMessage(String retMessage) {
        this.retMessage = retMessage;
    }
}
