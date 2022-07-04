package HashMap;

import java.util.HashMap;
import java.util.Scanner;

public class maximumFrequency {

    static Scanner sc = null;

    public static void main(String[] args) {
        sc = new Scanner(System.in);

        System.out.print("Enter Number of elements : ");
        int sizeOfArray = sc.nextInt();

        System.out.println();

        int[] arr = new int[sizeOfArray];
        System.out.print("Enter elements in array : ");
        for(int i=0; i<sizeOfArray; i++){
            arr[i] = sc.nextInt();
        }

        System.out.println();
        int result = maximumFrequency1(arr);
        System.out.println(result + " has maximum frequency");

    }
    
    public static int maximumFrequency1(int[] arr){

        HashMap<Integer,Integer> map = new HashMap<>();
        for(int val : arr){
            if(map.containsKey(val)){
                map.put(val, map.get(val) + 1);
            }
            else{
               map.put(val, 1); 
            }
        }

        int maximumFrequency = Integer.MIN_VALUE;
        int ans = 0;
        for(int val : arr){
            if(map.containsKey(val)){
                if(map.get(val) > maximumFrequency){
                    maximumFrequency = map.get(val);
                    ans = val;
                }
            }
        }
        return ans;
    }
}
