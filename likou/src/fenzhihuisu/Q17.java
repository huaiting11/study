package fenzhihuisu;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Q17 {
    Map<Character,String> maps = new HashMap<>();
    public List<String> letterCombinations(String digits) {
        maps.put('2', "abc");
        maps.put('3', "def");
        maps.put('4', "ghi");
        maps.put('5', "jkl");
        maps.put('6', "mno");
        maps.put('7', "pqrs");
        maps.put('8', "tuv");
        maps.put('9', "wxyz");
        if(digits.length()== 0){
            return new ArrayList<>();
        }else{
            List<String> res = new ArrayList<>();
            help(res,"",0,digits);
            return res;
        }

    }
    void help( List<String> res,String s,int level,String digits){
        if(level ==digits.length()){
            res.add(s);
            return;
        }
        Character c = digits.charAt(level);
        String mapGet = maps.get(c);
        for (int i = 0; i < mapGet.length(); i++) {
            help(res,s+mapGet.charAt(i),level+1,digits);
        }
    }
}
