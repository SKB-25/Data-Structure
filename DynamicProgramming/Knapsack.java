package DynamicProgramming;

import java.util.Scanner;
import java.util.Arrays;


public class Knapsack {
    
    static Scanner sc = null;
    public static void main(String[] args) {
        sc = new Scanner(System.in);
        System.out.print("Enter number of Items : ");
        int items = sc.nextInt();

        System.out.println();

        int[] weight = new int[items];
        System.out.print("Enter weight of Items : ");
        for(int i = 0; i<items; i++){
            weight[i] = sc.nextInt();
        }

        System.out.println();

        int[] prices = new int[items];
        System.out.print("Enter prices of Items : ");
        for(int i = 0; i<items; i++){
            prices[i] = sc.nextInt();
        }

        System.out.println();

        System.out.print("Enter weight limit of knapsack : ");
        int weightOfKnapsack = sc.nextInt();

        System.out.println();

        int[][] dp = new int[items+1][weightOfKnapsack+1];
        Arrays.fill(dp, -1);
        int profit = knapsackProfit(weight , prices , weightOfKnapsack , items , dp);
        System.out.println("Total profit : " + profit);
    }

    private static int knapsackProfit(int[] weight, int[] prices, int weightOfKnapsack, int items , int[][] dp) {
       
        if(items == 0 || weightOfKnapsack == 0){
            return 0;
        }

        if(dp[items][weightOfKnapsack]!=-1){
            return dp[items][weightOfKnapsack];
        }

        if(weight[items - 1] <= weightOfKnapsack){
            return dp[items][weightOfKnapsack] = Math.max(prices[items - 1] + knapsackProfit(weight, prices, weightOfKnapsack - weight[items-1], items - 1, dp) , knapsackProfit(weight, prices, weightOfKnapsack, items - 1, dp));
        }
        
        return dp[items][weightOfKnapsack] = knapsackProfit(weight, prices, weightOfKnapsack, items - 1, dp);
    }
}
