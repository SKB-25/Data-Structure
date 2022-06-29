package Array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class TwoSum {

   static Scanner sc = null;

    public static void main(String[] args) {
        sc = new Scanner(System.in);
        System.out.print("Enter size of Array : ");
        int sizeOfArray = sc.nextInt();
        int[] arr = new int[sizeOfArray];
        System.out.println();
        for(int i = 0; i<sizeOfArray; i++){
            arr[i] = sc.nextInt();
        }
        int sum = sc.nextInt();
        ArrayList<Integer> result = twoSumBetter(arr, sum);
        for(int n : result){
            System.out.println(n + " ");
        }
        int[] ans = twoSum(arr , sum);
        for(int n : ans){
            System.out.print(n +" ");

        }
    }

    // Find two numbers whose sum is equals to target value
    private static ArrayList<Integer> twoSumBetter(int[] arr , int sum){

        Arrays.sort(arr);
        ArrayList<Integer> ans = new ArrayList<>();

        for(int i = 0; i<arr.length; i++){
            int target = sum - arr[i];

            int front = i+1;
            int end = arr.length-1;

            while(front<end){
                int mid = (front + end)/2;

                if(arr[mid] < target){
                     front = mid +1;
                }
                else if(arr[mid] > target){
                    end = mid - 1;
                }
                else{
                    ans.add(arr[i]);
                    ans.add(arr[mid]);
                }
            }
        }
        return ans;
    }

    //find indices of two numbers whose sum is equals to target value
    private static int[] twoSum(int[] arr, int sum) {
        int[] ans = new int[2];
    
        for(int i = 0; i<arr.length; i++){
            for(int j = i+1; j<arr.length; j++){
                if(arr[i] + arr[j] == sum){
                    ans[0] = i;
                    ans[1] = j;
                }
            }
        }
        
        return ans;
        }
    }

