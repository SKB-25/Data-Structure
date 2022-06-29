package DynamicProgramming;

import java.util.Arrays;
import java.util.Scanner;

public class fibbonacci {
    
    public static int fibbonacci1(int n , int[] dp){
        if(n == 0 || n == 1){
            return n;
        }

        int ans1 , ans2;

        if(dp[n-1] == -1){
            ans1 = fibbonacci1(n-1, dp);
            dp[n-1] = ans1;
        }
        else{
           ans1 = dp[n-1];
        }

        if(dp[n-2] == -1){
            ans2 = fibbonacci1(n-2, dp);
            dp[n-2] = ans2;
        }
        else{
            ans2 = dp[n-2];
        }

        int myAns = ans1 + ans2;
    
        return myAns;
    }

    static Scanner sc= null;
    public static void main(String[] args) {
        sc = new Scanner(System.in);
        System.out.print("Enter Number : ");
        int n = sc.nextInt();
        int[] dp = new int[n+1];
        Arrays.fill(dp, -1);
        int ans = fibbonacci1(n , dp);
        System.out.println();
        System.out.println("Fibbonacci Number of " +n+ " : "+ ans);
    }
}
