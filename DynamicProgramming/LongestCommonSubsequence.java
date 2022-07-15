package DynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class LongestCommonSubsequence {
    
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException , NumberFormatException {
        System.out.print("String 1 : ");  
        String str1 = br.readLine().trim();
        System.out.println();
        System.out.print("String 2 : ");
        String str2 = br.readLine().trim();
        System.out.println();
           int result = lcs(str1 , str2);
           System.out.println("Longest Common Subsequence(Dynamic programming solution) : " + result);
        System.out.println();
           int result1 = lcs1(str1, str2, 0, 0);
           System.out.println("Longest Common Subsequence(Recursion solution) : " + result1);   
    }

    private static int lcs1(String str1 ,String str2 , int i , int j ){
        if(i>=str1.length() || j>=str2.length()){
            return 0;
        }
        
        int myAns;
        if(str1.charAt(i) == str2.charAt(j)){
            int smallOutput = lcs1(str1, str2, i+1, j+1);
            myAns = 1 + smallOutput;
        }
        else{
            int ans1 = lcs1(str1, str2, i+1, j);
            int ans2 = lcs1(str1, str2, i, j+1);
            myAns = Math.max(ans1, ans2);
        }
        return myAns;
    } 

    private static int lcs(String str1, String str2) {
        
        int[][] dp = new int[str1.length()+1][str2.length()+1];

        for(int i=str1.length()-1; i>=0; i--){
           for(int j=str2.length()-1; j>=0; j--){
            int ans;
            if(str1.charAt(i)==str2.charAt(j)){
                ans= 1+dp[i+1][j+1];
            }
            else{
                int ans1 = dp[i+1][j];
                int ans2 = dp[i][j+1];
                ans = Math.max(ans1, ans2);
            }
            dp[i][j] = ans;
           }
        }

        return dp[0][0];
    }

}
