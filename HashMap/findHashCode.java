package HashMap;

import java.util.Scanner;

public class findHashCode {

    static Scanner sc = null;
    public static void main(String[] args) {
        sc = new Scanner(System.in);

        System.out.print("Enter String : ");
        String str = sc.next();
        int hc = str.hashCode();

        System.out.println();
        System.out.println("HashCode of "+str+" is :"+hc);

    }
}
