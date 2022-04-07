Given two strings text1 and text2, return the length of their longest common subsequence. If there is no common subsequence, return 0.

A subsequence of a string is a new string generated from the original string with some characters (can be none) deleted without changing the relative order of the remaining characters.

For example, "ace" is a subsequence of "abcde".
A common subsequence of two strings is a subsequence that is common to both strings.

 

Example 1:

Input: text1 = "abcde", text2 = "ace" 
Output: 3  
Explanation: The longest common subsequence is "ace" and its length is 3.
Example 2:

Input: text1 = "abc", text2 = "abc"
Output: 3
Explanation: The longest common subsequence is "abc" and its length is 3.
Example 3:

Input: text1 = "abc", text2 = "def"
Output: 0
Explanation: There is no such common subsequence, so the result is 0.


class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int l1=text1.length();
        int l2=text2.length();
        int arr[][]=new int[l1+1][l2+1];
        for(int i=0;i<l1+1;i++){
             for(int j=0;j<l2+1;j++){
                 if(i==0 || j==0)
                     arr[i][j]=0;
                 else if(text1.charAt(i-1)==text2.charAt(j-1))
                     arr[i][j]=1+arr[i-1][j-1];
                 else
                     arr[i][j]=max(arr[i-1][j],arr[i][j-1]);
             }
        }
        return arr[l1][l2];
    }
    public static int max(int a,int b){
        return a>b?a:b;
    }
}
