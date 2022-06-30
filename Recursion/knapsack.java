package Recursion;

import java.util.Scanner;

public class knapsack {
    
    static Scanner sc = null;

    private static int knapsackProfit(int[] weight , int[] prices , int knapsackWeight , int items){
        
        if(items == 0 || knapsackWeight == 0){
            return 0;
        }

        if(weight[items -1] <= knapsackWeight){
            return Math.max(prices[items-1] + knapsackProfit(weight, prices, knapsackWeight - weight[items-1], items-1) , knapsackProfit(weight, prices, knapsackWeight, items-1));
        }

        return knapsackProfit(weight, prices, knapsackWeight, items-1);
        
    }


    public static void main(String[] args) {
        sc = new Scanner(System.in);
        System.out.print("Enter number of items available : ");
        int sizeOfArray = sc.nextInt();

        System.out.println();

        int[] weight = new int[sizeOfArray];
        System.out.print("Enter weight of items : ");
        for( int i = 0; i<sizeOfArray; i++){
            weight[i] = sc.nextInt();
        }

        System.out.println();

        int[] valueOfItem = new int[sizeOfArray];
        System.out.print("Enter prices of items : ");
        for(int i = 0; i<sizeOfArray; i++){
            valueOfItem[i] = sc.nextInt();
        }

        System.out.println();

        System.out.print("Enter weight limit of knapsack : ");
        int weightOfKnapsack = sc.nextInt();

        System.out.println();

        int profit = knapsackProfit(weight, valueOfItem, weightOfKnapsack, sizeOfArray);
        
        System.out.println("Maximum Profit : " + profit);
    }
}
