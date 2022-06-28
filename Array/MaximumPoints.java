package Array;

import java.util.Scanner;

public class MaximumPoints {
    
    static Scanner sc = null;
    public static void main(String args[]){
     
        sc = new Scanner(System.in);
        int size = sc.nextInt();
        int[] arr = new int[size];

        for(int i = 0; i<size ; i++){
            arr[i] = sc.nextInt();
        }
        int k = sc.nextInt();
        int result = maxScore(arr, k);
        System.out.println(result);
    }

    public static int maxScore(int[] arr , int k){
        
       int total = 0;
       for(int i = 0; i<k; i++){
        total+=arr[i];}
        int best = total;
        for(int i = k-1 , j = arr.length - 1; i>=0; i-- , j--){
             total+=arr[j] - arr[i];
             best = Math.max(best, total);
        }
       return best;
    }

}
