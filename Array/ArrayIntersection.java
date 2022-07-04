package Array;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class ArrayIntersection {

    static Scanner sc = null;

    public static void main(String[] args) {
        sc = new Scanner(System.in);

        System.out.print("Enter Nummber of elements of array1 : ");
        int sizeOfArray1 = sc.nextInt();

        System.out.println();

        int[] arr1 = new int[sizeOfArray1];
        System.out.print("Enter elements in array1 : ");
        for(int i=0; i<sizeOfArray1; i++){
            arr1[i] = sc.nextInt();
        }

        System.out.println();

        System.out.print("Enter Nummber of elements of array2 : ");
        int sizeOfArray2 = sc.nextInt();

        System.out.println();
        
        int[] arr2 = new int[sizeOfArray1];
        System.out.print("Enter elements in array2 : ");
        for(int i=0; i<sizeOfArray2; i++){
            arr2[i] = sc.nextInt();
        }

        System.out.println();

        ArrayList<Integer> result = arrayIntersection(arr1, arr2);
        System.out.print("Intersection eelements of Array1 and Array2 are : ");
        for(int val : result){
            System.out.print(val + " ");
        }

    }
    
    public static ArrayList<Integer> arrayIntersection(int[] arr1 , int[] arr2){

        ArrayList<Integer> result = new ArrayList<>();

        HashMap<Integer,Integer> map = new HashMap<>();
        for(int val : arr1){
            if(map.containsKey(val)){
                map.put(val, map.get(val) + 1);
            }
            else{
                map.put(val,1);
            }
        }

        for(int val : arr2){
            if(map.containsKey(val)){
                if(map.get(val) != 0){
                result.add(val);
                map.put(val,map.get(val) - 1);
                }
            }
        }
     return result;   
    }
}
