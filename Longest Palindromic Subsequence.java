Given a string s, find the longest palindromic subsequence's length in s.

A subsequence is a sequence that can be derived from another sequence by deleting some or no elements without changing the order of the remaining elements.

 

Example 1:

Input: s = "bbbab"
Output: 4
Explanation: One possible longest palindromic subsequence is "bbbb".
Example 2:

Input: s = "cbbd"
Output: 2
Explanation: One possible longest palindromic subsequence is "bb".
  
  
  class Solution {
    public int longestPalindromeSubseq(String s) {
        StringBuilder sb=new StringBuilder(s).reverse();
        int m=s.length();
        int i,j;
        int dp[][]=new int[m+1][m+1];
        for(i=1;i<=m;i++){
            for(j=1;j<=m;j++){
                if(i==0 || j==0)
                    dp[i][j]=0;
                else if(s.charAt(i-1)==sb.charAt(j-1))
                    dp[i][j]=1+dp[i-1][j-1];
                else
                    dp[i][j]=max(dp[i-1][j],dp[i][j-1]);
            }
        }
        return dp[m][m];
    }
    public static int max(int a,int b){
        return a>b?a:b;
    }
}
