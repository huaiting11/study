package hashTable;

import java.util.Arrays;

/**
 * 给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词。
 */
public class Q242 {
    /**
     * 排序
     */
    public boolean isAnagram(String s, String t) {
        if(s.length() != t.length()){
            return  false;
        }
        char[] chars = s.toCharArray();
        char[] chart = t.toCharArray();
        Arrays.sort(chars);
        Arrays.sort(chart);
        return Arrays.equals(chars,chart);

    }
    public boolean isAnagram01(String s, String t) {
        if(s.length() != t.length()){
            return false;
        }
        int[] countr = new int[26];
        for (int i = 0; i < s.length(); i++) {
            countr[s.charAt(i)-'a']++;
            countr[t.charAt(i)-'a']++;
        }
        for (int i = 0; i < countr.length; i++) {
            if(countr[i]!=0){
                return false;
            }
        }
        return true;
    }

}
