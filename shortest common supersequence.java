Given two strings str1 and str2, the task is to find the length of the shortest string that has both str1 and str2 as subsequences.

Examples : 

Input:   str1 = "geek",  str2 = "eke"
Output: 5
Explanation: 
String "geeke" has both string "geek" 
and "eke" as subsequences.

Input:   str1 = "AGGTAB",  str2 = "GXTXAYB"
Output:  9
Explanation: 
String "AGXGTXAYB" has both string 
"AGGTAB" and "GXTXAYB" as subsequences.
  
  
  import java.util.Scanner;
class Main{
    public static int max(int a,int b){
        return a>b?a:b;
    }
    public static int lcs(String s1,String s2,int m,int n){
        int arr[][]=new int[m+1][n+1];
        for(int i=0;i<=m;i++){
            for(int j=0;j<=n;j++){
                if(i==0 || j==0)
                arr[i][j]=0;
                else if(s1.charAt(i-1)==s2.charAt(j-1))
                arr[i][j]=1+arr[i-1][j-1];
                else
                arr[i][j]=max(arr[i-1][j],arr[i][j-1]);
            }
        }
            return arr[m][n];
        
    }
    public static void main(String[] args){
        Scanner sc= new Scanner(System.in);
        String s1=sc.next();
        String s2=sc.next();
        int m=s1.length();
        int n=s2.length();
        int len=lcs(s1,s2,m,n);
        System.out.print(m+n-len);
    }
}
