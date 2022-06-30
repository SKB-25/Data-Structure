package DynamicProgramming;

import java.util.Scanner;

public class StairsCase {
    
    //recusive solution with Dynamic programming
    public static int staircase(int n){

       if(n == 0){
        return 1;
       }

       if(n<0){
        return 0;
       }
        
       return staircase(n-1) + staircase(n-2) + staircase(n-3);
        
    }

    //using Iterative Dynamic programming
    private static long staircaseBetter(int n){
        if(n<=1){
            return 1;
        }
        else if(n == 2){
            return 2;
        }

        long[] dp = new long[n+1];
        dp[0] = 1;
        dp[1] = 1;
        dp[2] = 2;

        for(int i = 3; i<=n; i++){
            dp[i] = dp[i-1] + dp[i-2] + dp[i-3];
        }

        return dp[n];
    }

    static Scanner sc = null;
    public static void main(String[] args) {
        sc = new Scanner(System.in);
        System.out.print("Enter size of stairs : ");
        int NumberOfStairs = sc.nextInt();

        System.out.println("without Dynamic Programming");
        int result = staircase(NumberOfStairs);
        System.out.println("Total Number of Ways : " + result);
        
        System.out.println(); 

        System.out.println("With Dynamic Programming");
        long ans = staircaseBetter(NumberOfStairs);
        System.out.println("Total Number of way : " + ans);
    }
}
