package dp;

/**
 * 给定两个字符串 text1 和 text2，返回这两个字符串的最长公共子序列。
 *
 * 一个字符串的 子序列 是指这样一个新的字符串：它是由原字符串在不改变字符的相对顺序的情况下删除某些字符（也可以不删除任何字符）后组成的新字符串。
 * 例如，"ace" 是 "abcde" 的子序列，但 "aec" 不是 "abcde" 的子序列。两个字符串的「公共子序列」是这两个字符串所共同拥有的子序列。
 *
 * 若这两个字符串没有公共子序列，则返回 0。
        */
public class Q1143_longest {
    public int longestCommonSubsequence(String text1, String text2) {
        char[] s1 = text1.toCharArray();
        char[] s2 = text2.toCharArray();
        int[][] dp = new int[s1.length+1][s2.length+1];
        for (int i = 1; i < s1.length; i++) {
            for (int j = 1; j < s2.length; j++) {
                if(s1[i] ==  s2[j]){
                    dp[i][j] = dp[i -1][j-1]+1;
                }else{
                    dp[i][j] = Math.max(dp[i-1][j],dp[i][j-1]);
                }
            }
        }
        return dp[s1.length][s2.length];
    }
    public int longestCommonSubsequence1(String text1, String text2) {
        char[] s1 = text1.toCharArray();
        char[] s2 = text2.toCharArray();
        return help(s1.length-1,s2.length-1,s1,s2);

    }
    public int help(int i,int j,char[]  s1,char[] s2){
        if(i == -1 || j == -1) return 0;
        if(s1[i] == s1[j]){
            return help(i-1,j-1,s1,s2)+1;
        }else{
            int res;
            int temp = help(i-1,j,s1,s2);
            int temp1 = help(i,j-1,s1,s2);
            res = Math.max(temp,temp1);
            return res;
        }

    }

    public static void main(String[] args) {
        Q1143_longest longest = new Q1143_longest();
        int i =longest.longestCommonSubsequence1("abc","def");
        System.out.println(i);
    }

}
