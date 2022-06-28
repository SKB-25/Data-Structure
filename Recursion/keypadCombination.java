package Recursion;

import java.util.Scanner;

public class keypadCombination {
    static Scanner sc = null;
    public static void main(String[] args) {
        sc = new Scanner(System.in);
        System.out.print("Enter Number :");
        int input = sc.nextInt();
        String[] outStrings = keyCombinationStrings(input);

        for(String s : outStrings){
            System.out.print(s + " ");
        }
    }
    
    public static String[] keyCombinationStrings(int input){
        if(input == 0){
            String[] output = new String[1];
            output[0] = "";
            return output;
        }

        String[] smallOutput = keyCombinationStrings(input/10);
        int lastDigit = input%10;
        String lastDigitString = getLastDigitString(lastDigit);
        String[] output = new String[smallOutput.length * lastDigitString.length()];

        int k = 0;
        
        for(int i = 0; i<smallOutput.length; i++){
            for(int j = 0; j<lastDigitString.length(); j++){
                output[k] =  smallOutput[i]  + lastDigitString.charAt(j);
                k++;
            }
        }

        return output;
    }

    private static String getLastDigitString(int lastDigit) {
        if(lastDigit == 2){
            return "abc";
        }

        else if(lastDigit == 3){
            return "def";
        }

        else if(lastDigit == 4){
            return "ghi";
        }

        else if(lastDigit == 5){
            return "jkl";
        }

        else if(lastDigit == 6){
            return "mno";
        }

        else if(lastDigit == 7){
            return "pqrs";
        }

        else if(lastDigit == 8){
            return "tuv";
        }
        
        else if(lastDigit == 9){
            return "wxyz";
        }
        return "";
    }
}
