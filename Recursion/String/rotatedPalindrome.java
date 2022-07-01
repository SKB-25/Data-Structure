package Recursion.String;

import java.util.Scanner;

public class rotatedPalindrome {
    
    static Scanner sc = null;

    public static void main(String[] args) {
    
        sc = new Scanner(System.in);
        System.out.print("Enter String : ");
        String str = sc.next();

        System.out.println();
        int length = str.length();
        boolean result = isPalinrome(str , length);
        System.out.println(result);
    }

    private static boolean isPalinrome(String str , int count) {
        
        if(str.length() == 0){
            return false;
        }

        String reverse = "";

        for(int i = 0; i<str.length(); i++){
             reverse = str.charAt(i) + reverse;
        }
       

        if(reverse == str){
            return true;
        }
        
        return isPalinrome(str.substring(1) + str.charAt(0) , count - 1);

    }
   
    // private static boolean isPalinromeHelper(String str) {
    //     if(str.length() == 0){
    //         return true;
    //     }

    //     String reverse = "";

    //     for(int i = 0; i<str.length(); i++){
    //          reverse = str.charAt(i) + reverse;
    //     }
       

    //     if(reverse == str){
    //         return true;
    //     }
    //     else{
    //         return false;
    //     }
    // }
}
