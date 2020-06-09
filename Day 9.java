/*
Given a string s and a string t, check if s is subsequence of t.
A subsequence of a string is a new string which is formed from the original string by deleting some (can be none) of the characters without disturbing the relative positions of the remaining characters. (ie, "ace" is a subsequence of "abcde" while "aec" is not).
Follow up:
If there are lots of incoming S, say S1, S2, ... , Sk where k >= 1B, and you want to check one by one to see if T has its subsequence. In this scenario, how would you change your code?
Example 1:
Input: s = "abc", t = "ahbgdc"
Output: true
*/
public class Solution {
    public boolean isSubsequence(String s, String t) {
        if (s.length() == 0) return true;
        int indexS = 0, indexT = 0;
        while (indexT < t.length()) {
            if (s.charAt(indexS) == t.charAt(indexT)) {
                indexS++;
                if (indexS == s.length()) return true;
            }
            indexT++;
        }
        return false;
    }
}
/*
By Longest Subsequence Method(Using extra memeory)
class Solution {
    public boolean isSubsequence(String s, String t) {
        int s_len = s.length();
        int t_len = t.length();
        int dp [][] = new int[s_len + 1][t_len + 1];
        for(int i = 1;i <= s_len; i++){
            for(int  j = 1;j <= t_len; j++){
                if(s.charAt(i - 1) == t.charAt(j - 1))
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                else
                    dp[i][j] = Math.max(dp[i - 1][j],dp[i][ j - 1]);                
            }
        }
        return s_len == dp[s_len][t_len];        
    }
}
*/