package DynamicProgramming;

import java.util.Arrays;
import java.util.Scanner;

public class minimumTo1 {
    
    static Scanner sc = null;
    
    public static void main(String[] args) {
        sc = new Scanner(System.in);
        System.out.print("Enter Number : ");
        int number = sc.nextInt();

        System.out.println();

        int result = minCount(number);
        System.out.println("Minimum Step to 1 : " + result);
    }

    private static int minCount(int number) {
        
        if(number==0||number==1){
            return 0;
        }
        

        else if(number==2 || number==3){
             return 1;
        }

        int[] dp = new int[number+1];

        Arrays.fill(dp , -1);

        dp[1] = 0;
        dp[2] = 1;
        dp[3] = 1;
        
        for(int i = 4; i<=number; i++){
            int ans1 = dp[i-1];
            int ans2 = Integer.MAX_VALUE , ans3 = Integer.MAX_VALUE;

            if(i%2 == 0){
                ans2 = dp[i/2];
            }

            else if(i%3 == 0){
                ans3 = dp[i/3];
            }

            dp[i] = Math.min(ans1 , Math.min(ans2 ,ans3)) + 1;
        }

        return dp[number];
    }
}