package stackqueue;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class Q20 {
    public boolean isValid(String s) {
        Map<Character,Character> hashMap=new HashMap<>();
        hashMap.put(')', '(');
        hashMap.put('}', '{');
        hashMap.put(']', '[');
        Stack<Character> stack = new Stack<Character>();
        for (int i = 0; i < s.length(); i++) {
            char ss  = s.charAt(i);
            if(ss == '[' ||ss == '{' ||ss == '('){
                stack.push(ss);
                continue;
            }else{
                char topElement = stack.empty() ? '#' : stack.pop();
                if (topElement != hashMap.get(ss)) {
                    return false;
                }
            }

        }
        return  stack.isEmpty();
    }

    public static void main(String[] args) {
        Q20 q20 = new Q20();
        boolean s = q20.isValid("()");
    }

}
