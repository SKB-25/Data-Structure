package DynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class editDistance {
    
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException , NumberFormatException {
        
        System.out.print("String 1 : ");
        String str1 = br.readLine().trim();
        System.out.println();
        System.out.print("String 2 : ");
        String str2 = br.readLine().trim();
        System.out.println();

        int result = editDistance1(str1 , str2);
        System.out.println("Minimum distance to Make Strings Equal : " +  result);

    }

    private static int editDistance1(String str1, String str2) {
        int[][] dp = new int[str1.length() + 1][str2.length() + 1];

        for(int i=0; i<=str1.length(); i++){
            for(int j=0; j<=str2.length(); j++){
                if( i==0){
                    dp[i][j] = j;
                }
                else if(j == 0){
                    dp[i][j] = i;
                }
                else if(str1.charAt(i-1) == str2.charAt(j-1)){
                      dp[i][j] = dp[i-1][j-1];
                }
                else{
                    dp[i][j] = 1 + Math.min(dp[i-1][j], Math.min(dp[i][j-1], dp[i-1][j-1]));
                }
            }
        }

        return dp[str1.length()][str2.length()];
    }
}
