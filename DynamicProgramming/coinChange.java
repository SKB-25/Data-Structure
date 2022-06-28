package DynamicProgramming;

import java.util.Arrays;
import java.util.Scanner;

public class coinChange {
    
    static Scanner sc = null;

    public static void main(String[] args) {
        sc = new Scanner(System.in);
        System.out.print("Enter size of bag : ");
        int sizeOfArray = sc.nextInt();
       
        int[] coins = new int[sizeOfArray];
        
        for(int i = 0; i<sizeOfArray; i++){
            coins[i] = sc.nextInt();
        }
        System.out.println();

        System.out.print("Enter amount :");
        int amount = sc.nextInt();
        System.out.println();

        int result = coinChangeCount(coins, amount);

        System.out.println("Coins required : "+result);
    }
    
    public static int coinChangeCount(int[] coins , int amount){
        
        Arrays.sort(coins);
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, -1);
        dp[0] = 0;

        int result = count(coins , amount , dp);
        
        return result;
    }

    private static int count(int[] coins, int n, int[] dp) {
        if(n == 0){
            return 0;
        }
        int ans = Integer.MAX_VALUE;

        for(int i = 0; i<coins.length; i++){
            if(n-coins[i] >=0){
            int subAns = 0;
            if(dp[n-coins[i]] != -1){
                subAns = dp[n-coins[i]];
            }
            else{
                subAns = count(coins, n-coins[i], dp);
            }
             if( subAns != Integer.MAX_VALUE && subAns + 1 < ans){
                    ans = subAns + 1;
                }
            }
        }
        return dp[n] = ans;
    }   
    }

