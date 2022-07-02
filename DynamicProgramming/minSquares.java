package DynamicProgramming;

import java.util.Arrays;
import java.util.Scanner;

public class minSquares {
  
    static Scanner sc = null;

    public static void main(String[] args) {
        
        sc = new Scanner(System.in);
        System.out.print("Enter a number : ");
        int num = sc.nextInt();

        System.out.println();

        int result = findMinSquares(num);
        System.out.println("Minimum square of "  + num + " : " +  result);

        System.out.println();

        int[] dp = new int[num+1];
        Arrays.fill(dp, -1);
        int result1 = findMinSquaresDP1(num , dp);
        System.out.println("Minimum square of "  + num + " using Dp : " +  result1);

        System.out.println();

       
        int result2 = findMinSquaresDP2(num);
        System.out.println("Minimum square of "  + num + " using Dp : " +  result2);
    }

    //Find minimum square using recusrion only
    private static int findMinSquares(int num) {

        if(num == 0){
            return 0;
        }

        int min = Integer.MAX_VALUE;

        for(int i = 1; i*i<=num; i++){
            int currAns = findMinSquares(num - (i*i));

            if(currAns < min){
                min = currAns;
            }
        }
        return min + 1;
    }

    private static int findMinSquaresDP1(int num , int[] dp){
        if(num == 0){
            return 0;
        }
      
        int min = Integer.MAX_VALUE;

        for(int i = 1; i*i<=num; i++){
            int currAns;

            if(dp[num-(i*i)] == -1){
                currAns = findMinSquaresDP1(num-(i*i), dp);
                dp[num - (i*i)] = currAns;
            }
            else{
                currAns = dp[num - (i*i)];
            }

            if(currAns< min){
                min = currAns;
            }
        }
        return min + 1;
    }

    //Find minimum square using Dynamic Programming (iterative method)
    private static int findMinSquaresDP2(int num){
        
        if( num == 0){
            return 0;
        }

        int[] dp = new int[num+1];
        dp[0] = 0;

        for(int i = 1; i<=num; i++){
              int min = Integer.MAX_VALUE;
              for(int j = 1; j*j<=i; j++){

                int currAns = dp[i - (j*j)];

                if(currAns < min){
                    min = currAns;
                }
              }

              dp[i] = min + 1;
        }
        return dp[num];
    }

}
