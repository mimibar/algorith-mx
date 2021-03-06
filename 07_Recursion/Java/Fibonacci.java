/**
 * @name Miriam Lee
 * @link https://www.hackerrank.com/challenges/ctci-fibonacci-numbers/
 */

import java.util.*;

public class Solution {
    static int f=0;
    
    
    public static int fibonacci(int n) {
        if(n==0)
            return 0;
        if(n==1)
            return 1;
        
        else return fibonacci(n-1)+fibonacci(n-2);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        scanner.close();
        System.out.println(fibonacci(n));
    }
}
